package zjobs.Controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zjobs.Constant.Oper;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Menu;
import zjobs.entity.Page;
import zjobs.service.MenuService;
import zjobs.service.RedisService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制
 * Created by ZJOBS on 2015/3/10.
 */
@SuppressWarnings("rawtypes")
@Controller
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "menuIndex")
    public String menu() {
        return "menu/index";
    }

    @RequestMapping(value = "queryMenu")
    @ResponseBody
    public DataTablePage<Menu> pageQueryMenu(Menu menu, HttpServletRequest request) {
        DataTablePage<Menu> page = null;
        try {
            page = menuService.queryPage(menu.toMap(), createDataTablePage(menu));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    @RequestMapping(value = "addMenu")
    @ResponseBody
    public int addMenu(Menu menu) {
        int flag = 0;
        try {
            flag = menuService.createEntity(menu);
            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteMenu")
    @ResponseBody
    public int deleteMenu(Menu menu) {
        int flag = 0;
        try {
            flag = menuService.removeEntity(menu);
            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateMenu")
    @ResponseBody
    public int updateMenu(Menu menu) {
        int flag = 0;
        try {
            flag = menuService.modifyEntity(menu);
            //重新设置redis中的数据
            menuService.updateRedisMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
