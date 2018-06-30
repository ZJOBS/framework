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
 * 单选
 *
 * @author jiezhang
 */
public class Radio extends AbstractWebUiTag {

    private String text;

    private String code;

    private String name;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getStartTemplate() {
        return "radio.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        try {
            //form表单名称
            data.put("text", text);
            data.put("name", name);
            JSONObject selectJson = JSONObject.parseObject(redisService.get(RedisConstants.DICT, code).toString());
            //整个checkbox的名称
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
