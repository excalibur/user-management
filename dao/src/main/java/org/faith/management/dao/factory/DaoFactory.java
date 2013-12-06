package org.faith.management.dao.factory;

import org.faith.management.dao.UserDao;
import org.faith.management.dao.proxy.UserDaoProxy;

/**
 * dao工厂负责实例化dao对象
 *
 * @author faith
 * @since 0.0.1
 */
public class DaoFactory {
    private static UserDao userDao = null;

    private DaoFactory() {
    }

    public static UserDao getUserDao(){
        if (userDao == null ){
            userDao = new UserDaoProxy();
        }
        return userDao;
    }
}
