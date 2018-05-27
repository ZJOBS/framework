package zjobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Role;
import zjobs.entity.db.SystemLog;
import zjobs.service.RoleService;

/**
 * Created by ZhangJie on 2016/3/17.
 */
@SuppressWarnings("rawtypes")
@Controller
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "roleIndex")
    public String role() {
        return "role/index";
    }

    @RequestMapping(value = "queryRole")
    @ResponseBody
    public DataTablePage<Role> pageQueryRole(Role role) {
        DataTablePage<Role> page = null;
        try {
            page = roleService.queryPage(role.toMap(), createDataTablePage(role));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }


    @RequestMapping(value = "addRole")
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "添加角色")
    public int addRole(Role role) {
        int flag = 0;
        try {
            flag = roleService.createEntity(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteRole")
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "删除角色")
    public int deleteRole(Role role) {
        int flag = 0;
        try {
            flag = roleService.removeEntity(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateRole")
    @ResponseBody
    @SystemLog(module = "角色模块", methods = "添加角色")
    public int updateRole(Role role) {
        int flag = 0;
        try {
            flag = roleService.modifyEntity(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
