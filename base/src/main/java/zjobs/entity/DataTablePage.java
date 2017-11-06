package zjobs.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTablePage<T> {
    private int sEcho;//页面发来的参数，同步返回就行
    //请求参数
    int iDisplayStart;//开始
    int iDisplayLength;//长度
    private Map<String, Object> params = new HashMap<String, Object>();//请求参数

    //返回参数
    private int iTotalRecords;//记录总数
    private int iTotalDisplayRecords;//显示记录数

    int recordsFiltered = 0;
    //表的总记录数 必要
    int recordsTotal = 0;

    private List<T> aaData;//  返回记录

    public DataTablePage() {

    }

    public int getsEcho() {
        return sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    public int getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public int getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }


    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }

    @Override
    public String toString() {
        return "DataTablePage{" +
                "sEcho=" + sEcho +
                ", iDisplayStart=" + iDisplayStart +
                ", iDisplayLength=" + iDisplayLength +
                ", params=" + params +
                ", iTotalRecords=" + iTotalRecords +
                ", iTotalDisplayRecords=" + iTotalDisplayRecords +
                ", aaData=" + aaData +
                '}';
    }
}
