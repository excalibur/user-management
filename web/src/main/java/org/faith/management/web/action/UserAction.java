package org.faith.management.web.action;

import org.faith.management.core.entity.domain.User;
import org.faith.management.core.exception.database.NotFoundException;
import org.faith.management.service.UserService;
import org.faith.management.service.factory.ServiceFactory;
import org.faith.management.web.common.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户
 *
 * @author faith
 * @since 0.0.1
 */
@WebServlet(name = "UserServlet", urlPatterns = Router.user)
public class UserAction extends HttpServlet {
    private UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = null;
        // 组合json数据
        StringBuffer buffer = new StringBuffer("{");
        buffer.append("\"message\":\"");
        try {
            user = userService.readByUsername(username);
            buffer.append("对不起！该账号不可用。\"");
            buffer.append(",");
            buffer.append("\"enable\":false}");
        } catch (NotFoundException e) {
            buffer.append("恭喜！该账号可用。\"");
            buffer.append(",");
            buffer.append("\"enable\":true}");
        }
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print(buffer);
        out.flush();
        out.close();
    }


}
