package zjobs.web.tag;

import zjobs.base.AbstractWebUiTag;

import java.util.Map;

/**
 * 输入框
 *
 * @author jiezhang
 */
public class Input extends AbstractWebUiTag {
    private String name;

    private String text;

    private String hide;

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

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("name", name);
        data.put("text", text);
        data.put("hide", hide);
        return data;
    }

    @Override
    public String getStartTemplate() {
        return "input.ftl";
    }
}
