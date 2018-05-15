package zjobs.web.tag;

import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * @author ZhangJie
 */
public class TableColumn extends AbstractWebUiTag {
    protected String caption;
    protected String search;
    protected String addUrl;
    protected String queryUrl;
    protected String editUrl;
    protected String deleteUrl;
    protected String columnTitle;
    protected String columnName;
    protected String columnFormat;
    protected String defaultOperation;
    protected String customOperation;
    protected String key;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public String getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
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

    public String getDefaultOperation() {
        return defaultOperation;
    }

    public void setDefaultOperation(String defaultOperation) {
        this.defaultOperation = defaultOperation;
    }

    public String getCustomOperation() {
        return customOperation;
    }

    public void setCustomOperation(String customOperation) {
        this.customOperation = customOperation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

//        try {
//            Object obj = redisService.get("", "");
//        } catch (Exception e) {
//            //redis获取失败
//            e.printStackTrace();
//        }

        data.put("key", key);
        data.put("search", search);
        data.put("addUrl", addUrl);
        data.put("queryUrl", queryUrl);
        data.put("editUrl", editUrl);
        data.put("deleteUrl", deleteUrl);
        data.put("caption", caption);
        String[] columnTitles = columnTitle.split(",");
        data.put("columnTitle", columnTitles);
        data.put("columnLength", columnTitles.length - 1);
        data.put("columnName", columnName);
        data.put("columnFormat", columnFormat);
        data.put("defaultOperation", defaultOperation);
        data.put("customOperation", customOperation);
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}