package zjobs.web.tag;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import zjobs.base.AbstractWebUiTag;
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
     * 字典名称
     */
    private String name;
    /**
     * 默认选中字段
     */
    private String defaultValue;

    /**
     * 文本
     */
    private String text;


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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getStartTemplate() {
        return "iselect.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getBaseData();
        try {
            //form表单名称
            data.put("name", name);
            data.put("defaultValue", defaultValue);
            data.put("text", text);
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
