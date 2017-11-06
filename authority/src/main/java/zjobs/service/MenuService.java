package zjobs.service;

import com.alibaba.fastjson.JSONArray;
import zjobs.entity.db.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by ZJOBS on 2015/3/10.
 */
public interface MenuService extends BaseService<Menu, Exception> {

    public List<Menu> getList(Map<String, Object> map);

    public JSONArray getTreeMenu();

    public void updateRedisMenu() throws Exception;

}
