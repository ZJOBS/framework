package zjobs.web.tag;

import zjobs.base.AbstractWebUiTag;
import zjobs.base.FormTag;

import java.util.Map;

/**
 * switch，0，1  选择
 *
 * @author jiezhang
 */
public class Switch extends FormTag {


    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        return data;
    }

    @Override
    public String getStartTemplate() {
        return "switch.ftl";
    }
}
