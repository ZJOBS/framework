package zjobs.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjobs.constant.RedisConstants;
import zjobs.dao.MenuDao;
import zjobs.entity.db.Admin;
import zjobs.entity.db.Menu;
import zjobs.service.AbstractService;
import zjobs.service.AdminService;
import zjobs.service.MenuService;
import zjobs.service.RedisService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 菜单服务实现类
 *
 * @author jiezhang
 * @date 2015/3/10
 */
@Service
public class MenuServiceImpl extends AbstractService<Menu, MenuDao> implements MenuService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisService redisService;

    @Override
    public void updateRedisMenu() throws Exception {
        List<Admin> adminList = adminService.findAll();
        List<Menu> menuList;
        JSONArray array;
        for (Admin admin : adminList) {
            menuList = findMenuByAdminId(admin.getAdminId());
            array = treeMenuList(menuList, "00");
            redisService.put(RedisConstants.MENU, RedisConstants.ADMIN + admin.getAdminId(), array.toString());
        }
    }

    @Override
    public List<Menu> getList(Map<String, Object> map) {
        return dao.getList(map);
    }

    @Override
    public JSONArray getTreeMenu() {
        return treeMenuList(getList(new HashMap<String, Object>()), "00");
    }

    /**
     * 菜单树形结构
     */
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

    /**
     * 查询用户支持的菜单
     *
     * @param adminId
     * @return
     */
    private List<Menu> findMenuByAdminId(String adminId) {
        Map<String, Object> pmp = new HashMap<String, Object>();
        pmp.put("adminId", adminId);
        return dao.selectMenuByAdminId(pmp);
    }
}
