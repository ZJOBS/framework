package zjobs.filter;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import zjobs.entity.Page;
import zjobs.utils.PropertiesUtil;

/**
 * 分页查询（没用上）
 *
 * @author ZJOBS
 * @date 2015/2/22
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}))
public class PaginationInterceptor implements Interceptor {
    private static final String DATABASETYPE;

    static {
        DATABASETYPE = PropertiesUtil.loadProperties("properties/jdbc.properties").get("database_DATABASETYPE");
    }

    private static Map<String, String> Q2Oper;

    public PaginationInterceptor() {
        Q2Oper = new HashMap();
        //['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
        Q2Oper.put("eq", " = ");
        Q2Oper.put("ne", " <> ");
        Q2Oper.put("lt", " < ");
        Q2Oper.put("le", " <= ");
        Q2Oper.put("gt", " > ");
        Q2Oper.put("ge", " >= ");
        Q2Oper.put("bw", " LIKE ");
        Q2Oper.put("bn", " NOT LIKE ");
        Q2Oper.put("in", " IN ");
        Q2Oper.put("ni", " NOT IN ");
        Q2Oper.put("ew", " LIKE ");
        Q2Oper.put("en", " NOT LIKE ");
        Q2Oper.put("cn", " LIKE ");
        Q2Oper.put("nc", " NOT LIKE ");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation
                .getTarget();
        StatementHandler delegate = (StatementHandler) ReflectUtil
                .getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object obj = boundSql.getParameterObject();
        if (obj instanceof Page) {
            Page page = (Page) obj;
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil
                    .getFieldValue(delegate, "mappedStatement");
            Connection connection = (Connection) invocation.getArgs()[0];
            String sql = boundSql.getSql();
            this.setTotalRecord(page, mappedStatement, connection);


            sql += constructWhere(page.getFilters(), new CallBack() {
                @Override
                public String executeData(String f, String o, String d) {
                    if ("bw".equals(o) || "bn".equals(o)) {
                        return "'" + d + "%'";
                    } else if ("ew".equals(o) || "en".equals(o)) {
                        return "'%" + d + "'";
                    } else if ("cn".equals(o) || "nc".equals(o)) {
                        return "'%" + d + "%'";
                    } else {
                        return "'" + d + "'";
                    }
                }
            });

            //分页
            String pageSql = this.getPageSql(page, sql);
            ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //   this.DATABASETYPE = properties.getProperty("databaseType");
        System.out.println("数据库类型为" + DATABASETYPE);
    }

    @SuppressWarnings("rawtypes")
    private String getPageSql(Page page, String sql) {
        StringBuffer sqlBuffer = new StringBuffer(sql);
        //需要优化，将此数据库类型放到常量中，因经常使用
        if ("mysql".equalsIgnoreCase(DATABASETYPE)) {
            return getMysqlPageSql(page, sqlBuffer);
        } else if ("oracle".equalsIgnoreCase(DATABASETYPE)) {
            return getOraclePageSql(page, sqlBuffer);
        }
        return sqlBuffer.toString();
    }

    @SuppressWarnings("rawtypes")
    private String getMysqlPageSql(Page page, StringBuffer sqlBuffer) {
        //int offset = (page.getCurrentPage() - 1) * page.getPageSize();
        int offset = (page.getPage() - 1) * page.getPageSize();
        sqlBuffer.append(" limit ").append(offset).append(",")
                .append(page.getPageSize());
        return sqlBuffer.toString();
    }

    @SuppressWarnings("rawtypes")
    private String getOraclePageSql(Page page, StringBuffer sqlBuffer) {
        //int offset = (page.getCurrentPage() - 1) * page.getPageSize() + 1;
        int offset = (page.getPage() - 1) * page.getPageSize();
        sqlBuffer.insert(0, "select u.*, rownum r from (")
                .append(") u where rownum < ")
                .append(offset + page.getPageSize());
        sqlBuffer.insert(0, "select * from (").append(") where r >= ")
                .append(offset);
        return sqlBuffer.toString();
    }

    @SuppressWarnings("rawtypes")
    private void setTotalRecord(Page page, MappedStatement mappedStatement, Connection connection) {
        BoundSql boundSql = mappedStatement.getBoundSql(page);
        String sql = boundSql.getSql();
        String countSql = this.getCountSql(sql);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(countSql);
            parameterHandler.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                page.setRecords(totalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCountSql(String sql) {
        int index = sql.indexOf("from") == -1 ? sql.indexOf("FROM") : -1;
        return "select count(*) " + sql.substring(index);
    }

    private static class ReflectUtil {
        public static Object getFieldValue(Object obj, String fieldName) {
            Object result = null;
            Field field = ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                field.setAccessible(true);
                try {
                    result = field.get(obj);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        private static Field getField(Object obj, String fieldName) {
            Field field = null;
            for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz
                    .getSuperclass()) {
                try {
                    field = clazz.getDeclaredField(fieldName);
                    break;
                } catch (NoSuchFieldException e) {
                    //
                }
            }
            return field;
        }

        public static void setFieldValue(Object obj, String fieldName,
                                         String fieldValue) {
            Field field = ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                try {
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public interface CallBack {//回调函数接口

        public String executeData(String f, String o, String d);
    }

    public String constructWhere(String filter, CallBack cb) {
        String query = "";
        if (!filter.isEmpty()) {
            JsonObject jsono = new JsonParser().parse(filter).getAsJsonObject();
            if (jsono.isJsonObject()) {
                String group = jsono.get("groupOp").getAsString();
                JsonElement rules = jsono.get("rules");
                int i = 0;
                for (JsonElement o : rules.getAsJsonArray()) {
                    String field = o.getAsJsonObject().get("field").getAsString();
                    String op = o.getAsJsonObject().get("op").getAsString();
                    String data = o.getAsJsonObject().get("data").getAsString();
                    if (!op.isEmpty() && !data.isEmpty()) {
                        i++;
                        data = cb.executeData(field, op, data);
                        if (i == 1) {
                            query = " WHERE ";
                        } else {
                            query += " " + group + " ";
                        }
                        if ("in".equals(op) || "ni".equals(op)) {
                            query += field + Q2Oper.get(op) + " (" + data + ")";
                        } else {
                            query += field + Q2Oper.get(op) + data;
                        }
                    }
                }
            }
        }
        return query;
    }
}
