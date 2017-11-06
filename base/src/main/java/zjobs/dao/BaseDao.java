package zjobs.dao;

import org.apache.ibatis.annotations.InsertProvider;
import zjobs.entity.DataTablePage;
import zjobs.entity.Page;

import java.util.List;
import java.util.Map;

public interface BaseDao<T, E extends Exception> {

    public int insertEntity(Map<String, Object> parameter) throws E;

    public int deleteEntity(Map<String, Object> parameter) throws E;

    public int updateEntity(Map<String, Object> parameter) throws E;

    public T selectEntity(Map<String, Object> parameter) throws E;


    /*第一版，mybatis中可拦截生成sql，现已无法使用*/
    public List<T> queryPage(Page<T> page) throws E;

    /*第二版关联xml中生成的sql*/
    public List<T> queryDataTablePage(DataTablePage<T> page) throws Exception;


}
