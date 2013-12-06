package org.faith.management.web.listener;

import org.faith.management.core.entity.domain.User;
import org.faith.management.core.util.MD5Helper;
import org.faith.management.core.util.PropertiesHelper;
import org.faith.management.dao.UserDao;
import org.faith.management.dao.factory.DaoFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 项目环境监听
 *
 * 为了完成初始化
 *
 * @author faith
 * @since 0.0.1
 */
@WebListener
public class AppContextListener implements ServletContextListener {
    private PropertiesHelper propertiesHelper = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        propertiesHelper = new PropertiesHelper("appConfig");
        // 初始化数据
        UserDao userDao = DaoFactory.getUserDao();
        User user = new User();
        user.setUsername(propertiesHelper.getString("username"));
        String password = propertiesHelper.getString("password");
        password = MD5Helper.getMD5ByString(password);
        user.setPassword(password);
        user.setName("管理员");
        userDao.create(user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destroy");
    }
}
