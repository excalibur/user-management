package org.faith.management.web.action;

import org.faith.management.web.common.Router;
import org.faith.management.web.helper.SessionContextHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销
 *
 * @author faith
 * @since 0.0.1
 */
@WebServlet(name = "LogoutServlet",urlPatterns = Router.logout)
public class LogoutAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionContextHelper.clearUser(req);
        resp.sendRedirect(Router.index);
    }
}
