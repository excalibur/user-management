package org.faith.management.dao.factory;

import org.faith.management.dao.UserDao;
import org.faith.management.dao.proxy.UserDaoProxy;

/**
 * dao工厂负责实例化dao对象
 *
 * 采用单例
 *
 * @author faith
 * @since 0.0.1
 */
public class DaoFactory {
    private static DaoFactory daoFactory = new DaoFactory();
    private static UserDao userDao = null;
    public static DaoFactory getInstance() {
        return daoFactory;
    }

    private DaoFactory() {
    }

    public static UserDao getUserDao(){
        if (userDao == null ){
            userDao = new UserDaoProxy();
        }
        return userDao;
    }
}
