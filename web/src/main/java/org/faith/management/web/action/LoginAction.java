package org.faith.management.web.action;

import org.faith.management.core.entity.domain.User;
import org.faith.management.service.UserService;
import org.faith.management.service.factory.ServiceFactory;
import org.faith.management.web.common.Router;
import org.faith.management.web.common.View;
import org.faith.management.web.helper.MessageHelper;
import org.faith.management.web.helper.SessionContextHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录控制
 *
 * @author faith
 * @since 0.0.1
 */
@WebServlet(name = "LoginServlet",urlPatterns = Router.login)
public class LoginAction extends HttpServlet {

    private UserService userService = ServiceFactory.getUserService();
    /**
     * 直接返回登录页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(View.login).forward(req, resp);
    }

    /**
     * 登录处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        if (username.length()<5 || username.length()> 8){
            MessageHelper.addErrorField("username","账号错误！限制5-8位。",req);
        }

        if (password.length()<5 || username.length()> 16){
            MessageHelper.addErrorField("password","密码错误！限制5-16位。",req);
        }
        if (MessageHelper.hasError(req)){
            doGet(req, resp);
            return;
        }
        try {
            User user = userService.login(username,password);
            SessionContextHelper.addUser(user,req);
            resp.sendRedirect(Router.home);
        } catch (Exception e) {
            e.printStackTrace();
            MessageHelper.addError("用户或者密码错误！",req);
            doGet(req, resp);
        }


    }

}
