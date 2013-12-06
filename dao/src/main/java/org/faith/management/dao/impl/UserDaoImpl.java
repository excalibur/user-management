package org.faith.management.dao.impl;

import org.faith.management.core.entity.domain.User;
import org.faith.management.core.util.SerializableHelper;
import org.faith.management.dao.UserDao;
import redis.clients.jedis.Jedis;

/**
 * userDao实现
 *
 * @author faith
 * @since 0.0.1
 */
public class UserDaoImpl implements UserDao {
    private Jedis jedis = null;
    private SerializableHelper<User> helper;
    public UserDaoImpl(Jedis jedis) {
        this.jedis = jedis;
        helper = new SerializableHelper<User>();
    }

    @Override
    public User create(User user) {

        jedis.set(("users:"+user.getUsername()).getBytes(),helper.serialize(user));
        return user;
    }

    @Override
    public void update(User user) {
        jedis.set(("users:"+user.getUsername()).getBytes(),helper.serialize(user));
    }

    @Override
    public void delete(String username) {
        jedis.del(("users:"+username).getBytes());
    }

    @Override
    public User readByUsername(String username) {
        byte[] bytes = jedis.get(("users:"+username).getBytes());
        if (bytes == null || bytes.length == 0){
            return null;
        }
        return helper.deserialization(bytes);
    }
}
