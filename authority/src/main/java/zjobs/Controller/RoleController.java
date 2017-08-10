package zjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zjobs.Constant.Oper;
import zjobs.entity.db.Role;
import zjobs.entity.Page;
import zjobs.service.RoleService;

import javax.servlet.http.HttpServletRequest;

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
    public Page<Role> pageQueryRole(Role role, HttpServletRequest request) {
        Page<Role> page = null;
        try {
            page = roleService.queryPage(role.toMap(), createPage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    @RequestMapping(value = "updateOrDeleteRole")
    @ResponseBody
    public int updateOrDeleteRole(@RequestParam("oper") Oper oper, Role role) {
        int flag = 0;
        try {
            switch (oper) {
                case add:
                    role.setId(String.valueOf(sequenceService.getSequence()));//各个对象ID的名称不一样
                    flag = roleService.createEntity(role);
                    break;
                case del:
                    flag = roleService.removeEntity(role);
                    break;
                case edit:
                    flag = roleService.modifyEntity(role);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;


    }
}
