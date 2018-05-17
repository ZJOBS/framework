package zjobs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Menu;
import zjobs.entity.db.Role;
import zjobs.entity.db.RoleMenu;
import zjobs.service.RoleMenuService;

import java.util.*;

/**
 * 角色菜单控制层
 *
 * @author jiezhang
 */
@SuppressWarnings("rawtypes")
@Controller
public class RoleMenuController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(RoleMenuController.class);

    @Autowired
    private RoleMenuService roleMenuService;


    @RequestMapping(value = "queryRoleBindMenu")
    @ResponseBody
    public DataTablePage<Menu> queryBindDataTablePage(Role role) {
        DataTablePage<Menu> page = null;
        try {
            page = roleMenuService.queryBindDataTablePage(role.toMap(), createDataTablePage(role));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "queryRoleNotBindMenu")
    @ResponseBody
    public DataTablePage<Menu> queryNotBindDataTablePage(Role role) {
        DataTablePage<Menu> page = null;
        try {
            page = roleMenuService.queryNotBindDataTablePage(role.toMap(), createDataTablePage(role));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }


    @RequestMapping(value = "bindRoleMenu", method = RequestMethod.POST)
    @ResponseBody
    public int bindRoleMenu(String roleId, String menuIds) {
        int flag = 0;
        try {
            List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
            String[] ids = menuIds.split(",");
            RoleMenu roleMenu;
            for (String id : ids) {
                roleMenu = new RoleMenu();
                roleMenu.setMenuId(id);
                roleMenu.setRoleId(roleId);
                roleMenuList.add(roleMenu);
            }
            flag = roleMenuService.bind(roleMenuList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "unbindRoleMenu")
    @ResponseBody
    public int unbindRoleMenu(String roleId, String menuIds) {
        int flag = 0;
        try {
            Map<String, Object> pmp = new HashMap<String, Object>();
            pmp.put("roleId", roleId);
            List<String> list = Arrays.asList(menuIds.split(","));
            pmp.put("list", list);
            flag = roleMenuService.unbind(pmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
