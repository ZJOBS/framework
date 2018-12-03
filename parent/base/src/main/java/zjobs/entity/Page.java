package zjobs.entity;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
    private int pageSize = 10;//每页显示条数
    //private int totalRecord;
    private int records;// 总记录数
    private int page = 1;// 当前页
    //private int totalPage;
    private int total;// 总页数
    private Map<String, Object> params = new HashMap<String, Object>();
    //private List<T> results;//返回记录
    private List<T> rows;//  返回记录

    private String filters;

    public Page() {

    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
        int total = records % pageSize == 0 ? records / pageSize
                : records / pageSize + 1;
        this.setTotal(total);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }
}
