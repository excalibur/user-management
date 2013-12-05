package org.faith.management.web.action;

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
@WebServlet(name = "UserServlet", urlPatterns = "user")
public class UserAction extends HttpServlet {

    /**
     * 根据url上用户名渲染界面
     * @param req
     * @param resp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String)req.getAttribute("username");
        System.out.println("***********************");
        System.out.println(username);
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("修改用户信息");
    }
}
