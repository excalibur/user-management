package org.faith.management.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * url过滤
 *
 * 为了产生Restful 效果对uri进行了过滤判断
 *
 * @author faith
 * @since 0.0.1
 */
@WebFilter(filterName = "UserFiler", urlPatterns = "/*")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        String uri = request.getRequestURI();
        Pattern pattern = Pattern.compile("^/[^/]*$");
        Matcher matcher = pattern.matcher(uri);
        // 匹配静态资源
        if(uri.indexOf("/assets/") == 0){
            chain.doFilter(req, resp);
            return;
        }else if(matcher.find()){
            String path = matcher.group().substring(1);
            if (path.equals("login") || path.equals("register") || path.equals("favicon.ico") || path.equals("") ){
                chain.doFilter(req, resp);
            }else{
                req.setAttribute("username",path);
                req.getRequestDispatcher("/user").forward(req, resp);
            }
            return;
        }
        // 其他情况返回404
        req.getRequestDispatcher("404.html").forward(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
