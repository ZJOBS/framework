package zjobs.web.tag;

import zjobs.base.AbstractWebUiTag;
import zjobs.base.FormTag;

import java.util.Map;

/**
 * 日期选择器
 *
 * @author jiezhang
 */
public class DatePicker extends FormTag {
    /**
     * 默认选中时间
     */
    private String initialDate;

    /**
     * 不可选中时间
     */
    private String datesDisabled;
    /**
     * 最早可选择时间
     */
    private String startDate;
    /**
     * 最晚可选择时间
     */
    private String endDate;

    /**
     * 时间格式
     */
    private String format;

    /**
     * 是否展现今日按钮
     */
    private String todayBtn;

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getDatesDisabled() {
        return datesDisabled;
    }

    public void setDatesDisabled(String datesDisabled) {
        this.datesDisabled = datesDisabled;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTodayBtn() {
        return todayBtn;
    }

    public void setTodayBtn(String todayBtn) {
        this.todayBtn = todayBtn;
    }

    @Override
    public String getStartTemplate() {
        return "datepicker.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("format", format);
        return data;
    }

}
