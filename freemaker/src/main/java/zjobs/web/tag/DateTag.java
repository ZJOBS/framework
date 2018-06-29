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
 * 使用另一个
 *
 * @author jiezhang
 */
public class DateTag extends AbstractWebUiTag {


    private String name;
    /**
     * 文本
     */
    private String text;

    private String format;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getStartTemplate() {
        return "date.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getBaseData();
        data.put("name", name);
        data.put("text", text);
        data.put("format", format);
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
