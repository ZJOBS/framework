package zjobs.web.tag;

import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import zjobs.context.SpringContext;
import zjobs.service.MenuService;
import zjobs.service.RedisService;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * 手风琴菜单
 * Created by jiezhang on 2017/6/13.
 */
@Component
public class Accordion extends AbstractWebUiTag {
    protected String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getStartTemplate() {
        if (template != null && !template.equals("")) {
            return template;
        }
        return "iaccordion.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        try {
            Map<String, Object> data = super.getData();
            MenuService menuService = SpringContext.getBean("menuServiceImpl");
            JSONArray jsonArray = menuService.getTreeMenu();
            data.put("treeMenu", jsonArray);
            data.put("id", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
