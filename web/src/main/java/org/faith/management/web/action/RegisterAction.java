package org.faith.management.web.action;

import org.faith.management.core.entity.domain.User;
import org.faith.management.core.exception.auth.RegisterException;
import org.faith.management.service.UserService;
import org.faith.management.service.factory.ServiceFactory;
import org.faith.management.web.common.Router;
import org.faith.management.web.common.View;
import org.faith.management.web.helper.MessageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述信息
 *
 * @author faith
 * @since 0.0.1
 */
@WebServlet(name = "RegisterServlet",urlPatterns = Router.register)
public class RegisterAction extends HttpServlet {

    private UserService userService = null;

    @Override
    public void init() throws ServletException {
        userService = ServiceFactory.getUserService();
    }

    /**
     * 直接返回注册页面
     * @param req
     * @param resp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(View.register).forward(req,resp);
    }

    /**
     * 注册处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取值
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        String name = req.getParameter("name").trim();
        String confirmPassword = req.getParameter("confirm_password").trim();
        // 验证数据  简单验证一下
        if (username.length()<5 || username.length()> 8){
            MessageHelper.addErrorField("username","账号错误！限制5-8位。",req);
        }
        if (password.length()<5 || username.length()> 16){
            MessageHelper.addErrorField("password","密码错误！限制5-16位。",req);
        }
        if (!confirmPassword.equals(password)){
            MessageHelper.addErrorField("confirm_password","密码不一致。",req);
        }
        if (name.length() > 7 ){
            MessageHelper.addErrorField("name","用户名错误！限制小于7位。",req);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        // 记录数据
        req.setAttribute("user",user);
        if (MessageHelper.hasError(req)){
            doGet(req, resp);
            return;
        }

        try {
            userService.register(user);
            resp.sendRedirect(Router.login);
        } catch (RegisterException e) {
            MessageHelper.addError("注册错误！", req);
            doGet(req, resp);
        }
    }
}
