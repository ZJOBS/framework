package zjobs.web.tag;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import zjobs.context.SpringContext;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangJie on 2016/11/10.
 */
public abstract class WebUiTag extends BaseTag {
    protected Map<String, Object> data;
    protected String id;
    protected String props;
    protected String template;
    protected String name;
    protected String value;
    protected String css;
    protected String tips;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        data = new HashMap<String, Object>();
        data.put("contextPath", getRequest().getContextPath());
        return data;
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            String templateName = getStartTemplate();
            if (templateName != null) {
                String result = process(templateName, getData());
                output(result);
                getOut().flush();
            } else {
                output("<" + getTagName() + ">");
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }

    protected Template getTemplate(String templateName) {
        FreeMarkerConfigurer freeMarkerConfigurer = SpringContext.getBean("freemarkerConfig");
        Configuration cfg = freeMarkerConfigurer.getConfiguration();
        Template temp = null;
        try {
            temp = cfg.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    protected String process(Template temp, Object data) throws TemplateException, IOException {
        StringWriter writer = new StringWriter();
        try {
            temp.process(data, writer);
        } finally {
            writer.close();
        }
        return writer.getBuffer().toString();
    }

    protected String process(String templateName, Object data) throws TemplateException, IOException {
        StringWriter writer = new StringWriter();
        try {
            getTemplate(templateName).process(data, writer);
        } finally {
            writer.close();
        }
        return writer.getBuffer().toString();
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            String templateName = getEndTemplate();

            if (templateName != null) {
                String result = process(templateName, getData());
                output(result);
                getOut().flush();
            } else {
                output("</" + getTagName() + ">");

            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public String getStartTemplate() {
        return null;
    }

    public String getEndTemplate() {
        return null;
    }

    public String getTagName() {
        return getClass().getSimpleName().toLowerCase();
    }

}
