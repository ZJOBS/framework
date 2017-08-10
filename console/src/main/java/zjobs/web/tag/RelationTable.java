package zjobs.web.tag;

import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * Created by jiezhang on 2017/7/12.
 */
public class RelationTable extends WebUiTag {
    protected String caption;
    protected String queryurl;
    protected String columntitle;
    protected String columnname;
    protected String relation;
    protected String height;
    protected String rowList;//一页显示几行

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

    public String getColumntitle() {
        return columntitle;
    }

    public void setColumntitle(String columntitle) {
        this.columntitle = columntitle;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }


    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRowList() {
        return rowList;
    }

    public void setRowList(String rowList) {
        this.rowList = rowList;
    }

    @Override
    public String getStartTemplate() {
        if (template != null && !template.equals("")) {
            return template;
        }
        return "irelationtable.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("id", id);
        data.put("css", css);
        data.put("props", props);
        data.put("queryurl", queryurl);
        data.put("caption", caption);
        data.put("columntitle", columntitle);
        data.put("columnname", columnname);
        data.put("relation", relation);
        data.put("height", height);
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
