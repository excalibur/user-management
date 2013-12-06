package org.faith.management.service.factory;

import org.faith.management.dao.UserDao;
import org.faith.management.dao.proxy.UserDaoProxy;
import org.faith.management.service.UserService;
import org.faith.management.service.impl.UserServiceImpl;

/**
 * 业务逻辑层工厂
 *
 *
 * @author faith
 * @since 0.0.1
 */
public class ServiceFactory {
    private static UserService userService = null;

    public static UserService getUserService(){
        if (userService == null ){
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
