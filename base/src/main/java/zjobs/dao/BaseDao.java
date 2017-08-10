package zjobs.dao;

import org.apache.ibatis.annotations.InsertProvider;
import zjobs.entity.Page;
import java.util.List;
import java.util.Map;

public interface BaseDao<T, E extends Exception>  {

    public int insertEntity(Map<String, Object> parameter) throws E;

    public int deleteEntity(Map<String, Object> parameter) throws E;

    public int updateEntity(Map<String, Object> parameter) throws E;

    public T selectEntity(Map<String, Object> parameter) throws E;

    public List<T> queryPage(Page<T> page) throws E;
}
