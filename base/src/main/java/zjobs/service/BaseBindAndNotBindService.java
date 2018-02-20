package zjobs.service;

import zjobs.dao.BaseBindAndNotBindDao;
import zjobs.dao.BaseDao;
import zjobs.entity.BaseEntity;
import zjobs.entity.DataTablePage;
import zjobs.entity.Page;

import java.util.List;

/**
 * 抽象服务接口
 *
 * @param <P>
 * @param <F>
 * @param <T>
 * @param <D>
 * @param <E>
 * @author jiezhang
 * @date 2018/02/09
 */
public interface BaseBindAndNotBindService<P extends BaseEntity, F extends BaseEntity, T extends BaseEntity, D extends BaseBindAndNotBindDao<P, F, T, E>, E extends Exception> {


    /**
     * 查询绑定信息
     *
     * @param page
     * @return
     * @throws Exception
     */
    public List<P> queryBindDataTablePage(DataTablePage<F> page) throws Exception;


    /**
     * 查询绑定信息
     *
     * @param page
     * @return
     * @throws Exception
     */
    public List<P> queryNotBindDataTablePage(DataTablePage<F> page) throws Exception;

}
