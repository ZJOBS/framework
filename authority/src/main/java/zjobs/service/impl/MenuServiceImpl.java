package zjobs.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjobs.dao.MenuDao;
import zjobs.entity.db.Menu;
import zjobs.service.AbstractService;
import zjobs.service.MenuService;
import zjobs.service.RedisService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员方法
 * Created by ZJOBS on 2015/3/10.
 */
@Service
public class MenuServiceImpl extends AbstractService<Menu, MenuDao> implements MenuService {
    @Autowired
    private RedisService redisService;

    @Override
    public void updateRedisMenu() throws Exception {
        JSONArray jsonArray = getTreeMenu();
        redisService.put("menu", "menu", jsonArray.toString());
    }

    @Override
    public List<Menu> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    @Override
    public JSONArray getTreeMenu() {
        return treeMenuList(getList(new HashMap<String, Object>()), "00");
    }

    // 菜单树形结构
    private JSONArray treeMenuList(List<Menu> menuList, String parentId) {
        JSONArray childMenu = new JSONArray();
        for (Menu menu : menuList) {
            if (parentId.equals(menu.getParentId())) {
                JSONObject jo = (JSONObject) JSONObject.toJSON(menu);
                JSONArray childNode = treeMenuList(menuList, menu.getMenuId());
                jo.put("children", childNode);
                childMenu.add(jo);
            }
        }
        return childMenu;
    }
}
