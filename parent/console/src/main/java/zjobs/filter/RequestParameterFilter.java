package zjobs.filter;


import zjobs.utils.ContextHolderUtils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * Created by ZJOBS on 2015/2/22.
 */
//@WebFilter(filterName = "requestParameterFilter", urlPatterns = "/*")
public class RequestParameterFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        // HttpServletRequest httpRequest = (HttpServletRequest) request;
        // HttpSession session = httpRequest.getSession();
        // User user = (User) session.getAttribute("user");
        // if (user == null) {
        // user.setName("�ο�");
        // }
        // httpRequest.getAttribute("");

        ContextHolderUtils.setRequest((HttpServletRequest) request);
        ContextHolderUtils.setResponse((HttpServletResponse) response);
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
