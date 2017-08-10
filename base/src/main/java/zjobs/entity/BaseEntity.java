package zjobs.entity;


import zjobs.common.utils.DataConversionUtil;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 基类
 * Created by Administrator on 2015/2/12.
 */
public class BaseEntity {
    protected String id;

    protected String createUserName;

    protected String updateUserName;

    protected Date createDate;

    protected Date updateDate;

    protected int sequence;

    protected String createDateStr;

    protected String updateDateStr;

    /*状态为多种时*/
    protected int state;

    /*只有禁用和启用状态*/
    protected Boolean activating;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        this.createDateStr = this.createDate == null ? "" : sdf
                .format(this.createDate);
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = new Date();
        this.updateDateStr = this.updateDate == null ? "" : sdf
                .format(this.updateDate);

    }

    public String getCreateDateStr() {
        return createDateStr;

    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getUpdateDateStr() {
        return updateDateStr;
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Boolean getActivating() {
        return activating;
    }

    public void setActivating(Boolean activating) {
        this.activating = activating;
    }

    /**
     * 将对象转换为map
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> toMap() {
        return DataConversionUtil.toMap(this);
    }

    /**
     * 将Map值设置到对象中,map的值
     */
    public void assignment(Map<String, Object> data) {
        Method[] methods = this.getClass().getMethods();
        try {
            for (Method method : methods) {
                if (method.getName().startsWith("set")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("set") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    method.invoke(this, new Object[]{data.get(field)});
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    //    /*获取数据库主键字段的Field*/
    private Field getIdField() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class))
                return field;
        }
        throw new RuntimeException("undefine POJO @Id");
    }

    public void putIdField() {
        Field idField = getIdField();
        String name = idField.getName();
        String methodName = "set" + name.toUpperCase().charAt(0) + name.substring(1);
        Method method = null;
        try {
            Method[] methods = this.getClass().getDeclaredMethods();
            method = this.getClass().getDeclaredMethod(methodName, String.class);
            method.invoke(this, new Object[]{getId()});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("获取method方法失败。");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        }
    }

    public void putIdField(String id) {
        Field idField = getIdField();
        String name = idField.getName();
        String methodName = "set" + name.toUpperCase().charAt(0) + name.substring(1);
        Method method = null;
        try {
            Method[] methods = this.getClass().getDeclaredMethods();
            method = this.getClass().getDeclaredMethod(methodName, String.class);
            method.invoke(this, id);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("获取method方法失败。");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("设置ID的值失败。");
        }
    }
}

