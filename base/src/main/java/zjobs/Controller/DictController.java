package zjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zjobs.Constant.Oper;
import zjobs.entity.db.Dict;
import zjobs.entity.Page;
import zjobs.service.DictService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangJie on 2016/3/17.
 */
@SuppressWarnings("rawtypes")
@Controller
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    @RequestMapping(value = "dictIndex")
    public String dict() {
        return "dict/index";
    }

    @RequestMapping(value = "queryDict")
    @ResponseBody
    public Page<Dict> pageQueryDict(Dict dict, HttpServletRequest request) {
        Page<Dict> page = null;
        try {
            page = dictService.queryPage(dict.toMap(), createPage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    @RequestMapping(value = "updateOrDeleteDict")
    @ResponseBody
    public int updateOrDeleteDict(@RequestParam("oper") Oper oper, Dict dict) {
        int flag = 0;
        try {
            switch (oper) {
                case add:
                    flag = dictService.createEntity(dict);
                    break;
                case del:
                    flag = dictService.removeEntity(dict);
                    break;
                case edit:
                    flag = dictService.modifyEntity(dict);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;


    }
}
