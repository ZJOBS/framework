package zjobs.web.tag;

import zjobs.base.AbstractWebUiTag;

import java.util.Map;

/**
 * switch，0，1  选择
 *
 * @author jiezhang
 */
public class Switch extends AbstractWebUiTag {

    private String name;

    private String text;

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

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getBaseData();
        data.put("name", name);
        data.put("text", text);
        return data;
    }

    @Override
    public String getStartTemplate() {
        return "switch.ftl";
    }
}
