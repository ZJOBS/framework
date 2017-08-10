package zjobs.web.tag;

import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * Created by ZhangJie on 2016/11/10.
 */
public class TableColumn extends WebUiTag {
    protected String caption;
    protected String queryurl;
    protected String editurl;
    protected String columntitle;
    protected String columnname;
    protected String columnformat;
    protected String height;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getQueryurl() {
        return queryurl;
    }

    public void setQueryurl(String queryurl) {
        this.queryurl = queryurl;
    }

    public String getEditurl() {
        return editurl;
    }

    public void setEditurl(String editurl) {
        this.editurl = editurl;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getColumntitle() {
        return columntitle;
    }

    public void setColumntitle(String columntitle) {
        this.columntitle = columntitle;
    }

    public String getColumnformat() {
        return columnformat;
    }

    public void setColumnformat(String columnformat) {
        this.columnformat = columnformat;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String getStartTemplate() {
        if (template != null && !template.equals("")) {
            return template;
        }
        return "itablecolumn.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("id", id);
        data.put("css", css);
        data.put("props", props);

        data.put("queryurl", queryurl);
        data.put("editurl", editurl);
        data.put("caption", caption);
        data.put("columntitle", columntitle);
        data.put("columnname", columnname);
        data.put("columnformat", columnformat);
        data.put("height", height);
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
