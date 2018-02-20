package zjobs.dao;

import zjobs.entity.BaseEntity;
import zjobs.entity.DataTablePage;

import java.util.List;
import java.util.Map;

/**
 * 绑定与未绑定Dao
 *
 * @param <P>主表
 * @param <F>辅表
 * @param <T>中间表
 * @param <E>自定义异常
 * @author ZhangJie
 * @date 2018/02/08
 */
public interface BaseBindAndNotBindDao<P extends BaseEntity, F extends BaseEntity, T extends BaseEntity, E extends Exception> {

    /**
     * 查询绑定信息
     *
     * @param page 分页信息
     * @return List
     * @throws Exception
     */
    public List<P> queryBindDataTablePage(DataTablePage<F> page) throws Exception;

    /**
     * 查询未绑定信息
     *
     * @param page 分页信息
     * @return List
     * @throws Exception
     */
    public List<P> queryNotBindDataTablePage(DataTablePage<F> page) throws Exception;

    /**
     * 批量插入
     *
     * @param parameter 参数
     * @return int 插入条数
     * @throws Exception
     */
    public int insertList(Map parameter) throws Exception;

    /**
     * 批量删除
     *
     * @param parameter 参数
     * @return int 删除条数
     * @throws Exception
     */
    public int removeList(Map parameter) throws Exception;
}
