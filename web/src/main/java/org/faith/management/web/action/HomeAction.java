package org.faith.management.web.action;

import org.faith.management.web.common.Router;
import org.faith.management.web.common.View;

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
@WebServlet(name = "HomeServlet", urlPatterns = Router.home)
public class HomeAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(View.home).forward(req, resp);
    }


}
