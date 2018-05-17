package zjobs.web.tag;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import zjobs.constant.RedisConstants;

import javax.servlet.jsp.JspException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 封装select标签
 *
 * @author jiezhang
 */
public class Select extends AbstractWebUiTag {
    /**
     * 数据字典中的Code
     */
    private String code;
    /**
     * 默认选中字段
     */
    private String defaultValue;

    /**
     * select的类型包含（）
     */
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String getStartTemplate() {
        if (template != null && !template.equals("")) {
            return template;
        }
        return "iselect.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        try {
            Map<String, Object> data = super.getData();
            //form表单名称
            data.put("name", name);
            data.put("defaultValue", defaultValue);

            JSONObject selectJson = JSONObject.parseObject(redisService.get(RedisConstants.DICT, code).toString());
            //整个select的名称
            data.put("label", selectJson.get("name"));
            List<Map<String, String>> list = new LinkedList<Map<String, String>>();
            JSONArray array = selectJson.getJSONArray("value");
            data.put("options", array);
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
