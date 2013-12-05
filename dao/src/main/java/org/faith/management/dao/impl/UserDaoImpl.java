package org.faith.management.dao.impl;

import com.mongodb.DBCollection;
import org.faith.management.core.entity.domain.User;
import org.faith.management.dao.UserDao;

import java.util.List;

/**
 * userDao实现
 *
 * @author faith
 * @since 0.0.1
 */
public class UserDaoImpl implements UserDao {
    private DBCollection conn = null;

    public UserDaoImpl(DBCollection conn) {
        this.conn = conn;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User readById(String id) {
        return null;
    }

    @Override
    public List<User> readAll() {
        return null;
    }
}
