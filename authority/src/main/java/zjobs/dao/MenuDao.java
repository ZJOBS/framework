package zjobs.dao;

import zjobs.entity.db.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by ZhangJie on 2016/3/14.
 */
public interface MenuDao extends BaseDao<Menu, Exception> {

    public List<Menu> getList(Map<String, Object> map);
}
