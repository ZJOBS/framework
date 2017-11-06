package zjobs.service;

import zjobs.entity.BaseEntity;
import zjobs.entity.DataTablePage;
import zjobs.entity.Page;

import java.util.Map;

public abstract interface BaseService<T extends BaseEntity, E extends Exception> {

    public int createEntity(T entity) throws E;

    public int removeEntity(T entity) throws E;

    public int modifyEntity(T entity) throws E;

    public T findEntity(T entity) throws E;
    /*第一版已无法使用*/

    public Page<T> queryPage(Map<String, Object> parameters, Page<T> page)
            throws E;

    /*第二版 product和admin已通过*/
    public DataTablePage queryPage(Map parameters, DataTablePage page) throws Exception;

    public int disable(T entity) throws Exception;

    public int enable(T entity) throws Exception;
}
