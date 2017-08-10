package zjobs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import zjobs.common.utils.JsonUtil;
import zjobs.entity.Page;
import zjobs.entity.UserAccount;
import zjobs.service.SequenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by ZhangJie on 2016/2/14.
 */
@Controller
public class BaseController<T, E extends Exception> {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Autowired
    @Qualifier("snowflakeSequenceImpl")
    protected SequenceService sequenceService;

    @ModelAttribute
    protected void setReqAndResAndSes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }

    protected Map<String, Object> getParametersMap(String parameters) {
        return JsonUtil.jsonToMap(parameters);
    }

    protected Page<T> createPage() {
        Page<T> page = new Page<T>();
        int currentPage = Integer.valueOf(getParameterInt("page", 1));
        int pageSize = Integer.valueOf(getParameterInt("rows", page.getPageSize()));
        String filters = getParameterString("filters");
        page.setFilters(filters);
        page.setPageSize(pageSize);
        page.setPage(currentPage);
        return page;
    }

    protected int getParameterInt(String name) {
        return getParameterInt(name, 0);
    }

    protected int getParameterInt(String name, int defaultValue) {
        String parameter = getRequest().getParameter(name);
        return parameter == null || parameter.equals("") ? defaultValue
                : Integer.valueOf(parameter);
    }

    protected String getParameterString(String name) {
        return getParameterString(name, "");
    }

    protected String getParameterString(String name, String defaultValue) {
        String parameter = getRequest().getParameter(name);
        return parameter == null ? defaultValue : parameter;
    }

    protected UserAccount getUser() {
        return (UserAccount) getSession().getAttribute("user");
    }

//    protected Long getUserId() {
//        UserAccount u = getUser();
//        return u == null ? 0 : u.getId();
//    }

//    protected String getUserName() {
//        UserAccount u = getUser();
//        return u == null ? "" : u.getName();
//    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    protected void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    protected void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    protected HttpSession getSession() {
        return session;
    }

    protected void setSession(HttpSession session) {
        this.session = session;
    }
}
