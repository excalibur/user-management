package org.faith.management.web.helper;

import org.faith.management.core.entity.domain.User;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * session管理工具类
 *
 * 主要是维护登录信息
 *
 * @author faith
 * @since 0.0.1
 */
public class SessionContextHelper {
    public static final String CURRENT_USER = "CURRENT_USER";

    public static void addUser(User user,ServletRequest request){
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        httpServletRequest.getSession().setAttribute(CURRENT_USER,user);
    }

    public static User getUser(ServletRequest request){
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        Object o = httpServletRequest.getSession().getAttribute(CURRENT_USER);
        User user = null;
        if (o instanceof User){
            user = (User) o;
        }
        return user;
    }

    public static void clearUser(ServletRequest request){
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        httpServletRequest.getSession().removeAttribute(CURRENT_USER);
    }
}
