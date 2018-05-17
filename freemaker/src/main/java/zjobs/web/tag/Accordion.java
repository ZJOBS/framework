package zjobs.web.tag;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Component;
import zjobs.constant.BaseConstants;
import zjobs.constant.RedisConstants;
import zjobs.entity.UAI;

import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * 手风琴菜单
 *
 * @author jiezhang
 * @date 2017/6/13
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
            UAI uai = (UAI) getRequest().getSession().getAttribute(BaseConstants.UAI);
            Object obj = redisService.get(RedisConstants.MENU, RedisConstants.ADMIN + uai.getAdminId());
            JSONArray jsonArray = JSONArray.parseArray(obj.toString());
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
