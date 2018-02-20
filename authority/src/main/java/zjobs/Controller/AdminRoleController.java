package zjobs.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Admin;
import zjobs.entity.db.AdminRole;
import zjobs.entity.db.Menu;
import zjobs.entity.db.Role;
import zjobs.service.AdminRoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用户角色控制
 *
 * @author ZhangJie
 * @date 2018/02/08
 */
@SuppressWarnings("rawtypes")
@Controller
public class AdminRoleController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(AdminRoleController.class);
    @Autowired
    private AdminRoleService adminRoleService;

    @RequestMapping(value = "queryAdminBindRole")
    @ResponseBody
    public DataTablePage<Role> queryBindDataTablePage(Admin admin, HttpServletRequest request) {
        DataTablePage<Role> page = null;
        try {
            page = adminRoleService.queryBindDataTablePage(admin.toMap(), createDataTablePage(admin));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "queryAdminNotBindRole")
    @ResponseBody
    public DataTablePage<Role> queryNotBindDataTablePage(Admin admin, HttpServletRequest request) {
        DataTablePage<Role> page = null;
        try {
            page = adminRoleService.queryNotBindDataTablePage(admin.toMap(), createDataTablePage(admin));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "bindAdminRole", method = RequestMethod.POST)
    @ResponseBody
    public int bindAdminRole(String adminId, String roleIds, HttpServletRequest request) {
        int flag = 0;
        try {
            List<AdminRole> adminRoleList = new ArrayList<AdminRole>();
            String[] ids = roleIds.split(",");
            AdminRole adminRole = new AdminRole();
            for (String id : ids) {
                adminRole.setRoleId(id);
                adminRole.setAdminId(adminId);
                adminRoleList.add(adminRole);
            }
            flag = adminRoleService.bind(adminRoleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "unbindAdminRole")
    @ResponseBody
    public int unbindAdminRole(String adminId, String roleIds, HttpServletRequest request) {
        int flag = 0;
        try {
            Map<String, Object> pmp = new HashMap<String, Object>();
            pmp.put("adminId", adminId);
            List<String> list = Arrays.asList(roleIds.split(","));
            pmp.put("list", list);
            flag = adminRoleService.unbind(pmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


}
