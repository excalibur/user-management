package org.faith.management.web.action;

import org.faith.management.core.entity.domain.User;
import org.faith.management.core.exception.database.NotFoundException;
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
 * 更新
 *
 * @author faith
 * @since 0.0.1
 */
@WebServlet(name = "UpdateServlet", urlPatterns = Router.update)
public class UpdateAction extends HttpServlet {
    private UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = null;
        try {
            user = userService.readByUsername(username);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("user",user);
        req.getRequestDispatcher(View.update).forward(req,resp);
    }

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

        if (MessageHelper.hasError(req)){
            doGet(req, resp);
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);

        userService.update(user);
        MessageHelper.addSuccess("更新成功！",req);
        req.getRequestDispatcher(View.update).forward(req,resp);
    }
}
