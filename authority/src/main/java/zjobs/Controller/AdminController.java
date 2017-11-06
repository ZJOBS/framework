package zjobs.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import zjobs.Constant.Oper;
import zjobs.entity.DataTablePage;
import zjobs.entity.Page;
import zjobs.entity.UAI;
import zjobs.entity.db.Admin;
import zjobs.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户控制
 * Created by ZJOBS on 2015/3/10.
 */
@SuppressWarnings("rawtypes")
@Controller
public class AdminController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "index")
    public String index(HttpSession session) {
        //这个index界面必须放到web-inf中
        return "index";
    }


    @RequestMapping(value = "home")
    public String backend() {
        return "home";
    }

    @RequestMapping(value = "admin")
    public String admin() {
        return "admin/index";
    }

    @RequestMapping(value = "logoutAction")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }


    @RequestMapping(value = "loginAction")
    public ModelAndView loginAction(HttpSession session, Admin admin) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");
        try {
            admin = adminService.login(admin);
            if (admin == null) {
                //有问题
                modelAndView.setViewName("redirect:/index.do");
            } else {
                UAI uai = new UAI();
                uai.setAdmin(admin);
                session.setAttribute("UAI", uai);
                modelAndView.setViewName("redirect:/home.do");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "adminIndex")
    public ModelAndView adminIndex(Admin admin, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Page<Admin> page = null;
            page = adminService.queryPage(admin.toMap(), createPage());
            modelAndView.addObject("page", page);
            modelAndView.setViewName("forward:/admin.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "queryAdmin")
    @ResponseBody
    public DataTablePage<Admin> pageQueryAdmin(Admin admin, HttpServletRequest request) {
        DataTablePage<Admin> page = null;
        try {
            page = adminService.queryPage(admin.toMap(), createDataTablePage(admin));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    @RequestMapping(value = "addAdmin")
    @ResponseBody
    public int addAdmin(Admin admin, MultipartFile file) {
        int flag = 0;
        try {
            if (file != null) {
                long imgId = qiNiuService.uploadFile(file);
                admin.setAvatar(String.valueOf(imgId));
            }
            flag = adminService.createEntity(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteAdmin")
    @ResponseBody
    public int deleteAdmin(Admin admin) {
        int flag = 0;
        try {
            flag = adminService.removeEntity(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateAdmin")
    @ResponseBody
    public int updateAdmin(Admin admin, MultipartFile avatar) {
        int flag = 0;
        try {
            if (avatar != null) {
                long imgId = qiNiuService.uploadFile(avatar);
                admin.setAvatar(String.valueOf(imgId));
            }
            flag = adminService.modifyEntity(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
