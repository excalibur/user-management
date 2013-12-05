package org.faith.management.dao.proxy;

import com.mongodb.DBCollection;
import org.faith.management.core.entity.domain.User;
import org.faith.management.dao.UserDao;
import org.faith.management.dao.helper.DBConnectionHelper;
import org.faith.management.dao.impl.UserDaoImpl;

import java.util.List;

/**
 * UserDao的代理实现
 *
 * 主要是打开与关闭数据库连接
 *
 * @author faith
 * @since 0.0.1
 */
public class UserDaoProxy implements UserDao{
    private UserDao userDao = null;
    private DBCollection conn = null;
    public UserDaoProxy() {
        conn = DBConnectionHelper.getConnection("users");
        userDao = new UserDaoImpl(conn);
    }

    @Override
    public User create(User user) {
        try {
            userDao.create(user);
        } finally {
            DBConnectionHelper.close();
        }
        return null;
    }

    @Override
    public void update(User user) {
        try {
            userDao.update(user);
        } finally {
            DBConnectionHelper.close();
        }
    }

    @Override
    public void delete(String id) {
        try {
            userDao.delete(id);
        } finally {
            DBConnectionHelper.close();
        }
    }

    @Override
    public User readById(String id) {
        try {
            userDao.readById(id);
        } finally {
            DBConnectionHelper.close();
        }
        return null;
    }

    @Override
    public List<User> readAll() {
        try {
            userDao.readAll();
        } finally {
            DBConnectionHelper.close();
        }
        return null;
    }
}
