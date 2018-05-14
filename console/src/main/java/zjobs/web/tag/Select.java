//package zjobs.web.tag;
//
//import com.alibaba.fastjson.JSONArray;
//import zjobs.context.SpringContext;
//import zjobs.service.MenuService;
//
//import javax.servlet.jsp.JspException;
//import java.util.Map;
//
///**
// * 封装select标签
// *
// * @author jiezhang
// */
//public class Select extends AbstractWebUiTag {
//    private String code;
//    private String defaultValue;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getDefaultValue() {
//        return defaultValue;
//    }
//
//    public void setDefaultValue(String defaultValue) {
//        this.defaultValue = defaultValue;
//    }
//
//    @Override
//    public String getStartTemplate() {
//        if (template != null && !template.equals("")) {
//            return template;
//        }
//        return "iselect.ftl";
//    }
//
//    @Override
//    public Map<String, Object> getData() {
//        try {
//            Map<String, Object> data = super.getData();
//            MenuService menuService = SpringContext.getBean("dictServiceImpl");
//
//            //获取对应的数据
////            JSONArray jsonArray = menuService.getTreeMenu();
////            data.put("treeMenu", jsonArray);
////            data.put("id", id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//
//    @Override
//    public int doEndTag() throws JspException {
//        return EVAL_PAGE;
//    }
//}
