package zjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zjobs.Constant.Oper;
import zjobs.entity.db.Menu;
import zjobs.entity.Page;
import zjobs.service.MenuService;
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

    @RequestMapping(value = "menuIndex")
    public String menu() {
        return "menu/index";
    }

    @RequestMapping(value = "queryMenu")
    @ResponseBody
    public Page<Menu> pageQueryMenu(Menu menu, HttpServletRequest request) {
        Page<Menu> page = null;
        try {
            page = menuService.queryPage(menu.toMap(), createPage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    @RequestMapping(value = "updateOrDeleteMenu")
    @ResponseBody
    public int updateOrDelete(@RequestParam("oper") Oper oper, Menu menu) {
        int flag = 0;
        try {
            switch (oper) {
                case add:
                    menu.setId(String.valueOf(sequenceService.getSequence()));//各个对象ID的名称不一样
                    flag = menuService.createEntity(menu);
                    break;
                case del:
                    flag = menuService.removeEntity(menu);
                    break;
                case edit:
                    flag = menuService.modifyEntity(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
