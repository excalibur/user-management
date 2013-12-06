package org.faith.management.web.filter;

import org.faith.management.core.entity.domain.User;
import org.faith.management.web.common.Router;
import org.faith.management.web.helper.SessionContextHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * url过滤
 *
 * 为了产生Restful 效果对uri进行了过滤判断
 * 为了实现登录  进行了session 用户信息判断
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
        HttpServletResponse response = (HttpServletResponse)resp;
        String uri = request.getRequestURI();
//        Pattern pattern = Pattern.compile("^/[^/]*$");
//        Matcher matcher = pattern.matcher(uri);
        // 匹配静态资源
        if(uri.indexOf("/assets/") == 0){
            chain.doFilter(req, resp);
            return;
        }else{
            String path = uri;
            if (path.indexOf(Router.login) == 0 ||
                    path.indexOf(Router.register) == 0 ||
                    path.indexOf("/favicon.ico") == 0 ||
                    (path.length() == 1 && path.indexOf(Router.index) == 0) ||
                    path.indexOf(Router.logout) == 0 ||
                    path.indexOf(Router.user) == 0 ){
                chain.doFilter(req, resp);
            }else{
                // 登录过滤
                User user = SessionContextHelper.getUser(req);
                if (user == null ){
                    response.sendRedirect(Router.login);
                }else{
                    chain.doFilter(req, resp);
                }

            }
            return;
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
