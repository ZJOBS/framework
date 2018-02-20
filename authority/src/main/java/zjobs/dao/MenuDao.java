package zjobs.dao;

import zjobs.entity.db.Menu;

import java.util.List;
import java.util.Map;

/**
 * 菜单数据处理接口
 *
 * @author jiezhang
 * @date 2017/3/14
 */
public interface MenuDao extends BaseDao<Menu, Exception> {

    public List<Menu> getList(Map<String, Object> map);
}
