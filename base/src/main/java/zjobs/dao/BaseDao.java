package zjobs.dao;

import org.apache.ibatis.annotations.InsertProvider;
import zjobs.entity.BaseEntity;
import zjobs.entity.DataTablePage;
import zjobs.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * 增删改查通用Dao接口
 *
 * @param <T> 对象
 * @param <E> 异常
 * @author ZhangJie
 * @date 2018/02/09
 */
public interface BaseDao<T extends BaseEntity, E extends Exception> {


    /**
     * 增
     *
     * @param parameter
     * @return
     * @throws E
     */
    public int insertEntity(Map<String, Object> parameter) throws E;

    /**
     * 删
     *
     * @param parameter
     * @return
     * @throws E
     */
    public int deleteEntity(Map<String, Object> parameter) throws E;

    /**
     * 改
     *
     * @param parameter
     * @return
     * @throws E
     */
    public int updateEntity(Map<String, Object> parameter) throws E;

    /**
     * 查询一条数据
     *
     * @param parameter
     * @return
     * @throws E
     */
    public T selectEntity(Map<String, Object> parameter) throws E;


    /**
     * 第一版，mybatis中可拦截生成sql，现已无法使用
     *
     * @param page
     * @return
     * @throws E
     */
    public List<T> queryPage(Page<T> page) throws E;

    /**
     * 分页查询，第二版关联xml中生成的sql
     *
     * @param page
     * @return
     * @throws Exception
     */
    public List<T> queryDataTablePage(DataTablePage<T> page) throws Exception;


}
