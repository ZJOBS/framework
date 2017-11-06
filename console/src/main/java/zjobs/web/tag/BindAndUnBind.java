package zjobs.web.tag;


import org.springframework.stereotype.Component;

import javax.servlet.jsp.JspException;

/**
 * 一堆多，绑定与解绑模板
 *
 * @author jiezhang
 * Created by  on 2017/6/13.
 */
@Component
public class BindAndUnBind extends AbstractWebUiTag {
    private String leftId;
    private String leftQueryUrl;
    private String deleteUrl;

    private String rightId;
    private String rightQueryUrl;
    private String addUrl;

    protected String columnTitle;
    protected String columnName;
    protected String columnFormat;


    public String getLeftId() {
        return leftId;
    }

    public void setLeftId(String leftId) {
        this.leftId = leftId;
    }

    public String getLeftQueryUrl() {
        return leftQueryUrl;
    }

    public void setLeftQueryUrl(String leftQueryUrl) {
        this.leftQueryUrl = leftQueryUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    public String getRightQueryUrl() {
        return rightQueryUrl;
    }

    public void setRightQueryUrl(String rightQueryUrl) {
        this.rightQueryUrl = rightQueryUrl;
    }

    public String getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl;
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnFormat() {
        return columnFormat;
    }

    public void setColumnFormat(String columnFormat) {
        this.columnFormat = columnFormat;
    }


    @Override
    public String getStartTemplate() {
        if (template != null && !template.equals("")) {
            return template;
        }
        return "iBindAndUnbind.ftl";
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
