package org.faith.management.dao.proxy;

import org.faith.management.core.entity.domain.User;
import org.faith.management.dao.UserDao;
import org.faith.management.dao.helper.RedisHelper;
import org.faith.management.dao.impl.UserDaoImpl;
import redis.clients.jedis.Jedis;

/**
 * UserDao的代理实现
 *
 * 主要是控制链接的连接与释放
 *
 *
 * @author faith
 * @since 0.0.1
 */
public class UserDaoProxy implements UserDao{
    private UserDao userDao = null;
    private Jedis jedis;
    public UserDaoProxy() {
        jedis =  RedisHelper.getJedis();
        userDao = new UserDaoImpl(jedis);
    }

    @Override
    public User create(User user) {
        try {
            user = userDao.create(user);
        } finally {
            RedisHelper.returnResource(jedis);
        }
        return user;
    }

    @Override
    public void update(User user) {
        try {
            userDao.update(user);
        } finally {
            RedisHelper.returnResource(jedis);
        }
    }

    @Override
    public void delete(String username) {
        try {
            userDao.delete(username);
        } finally {
            RedisHelper.returnResource(jedis);
        }
    }

    @Override
    public User readByUsername(String username) {
        User user = null;
        try {
            user = userDao.readByUsername(username);
        } finally {
            RedisHelper.returnResource(jedis);
        }
        return user;
    }
}
