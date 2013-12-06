package org.faith.management.dao.helper;

import org.faith.management.core.util.PropertiesHelper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis连接
 *
 * @author faith
 * @since 0.0.1
 */
public class RedisHelper {
    private static JedisPool jedisPool = null;
    private static void init() {
        PropertiesHelper ph = new PropertiesHelper("appConfig");
        String auth = ph.getString("redis.auth");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive( ph.getInt("redis.max.active"));
        config.setMaxIdle( ph.getInt("redis.max.idle"));
        config.setMaxIdle( ph.getInt("redis.max.wait"));
        config.setTestOnBorrow(ph.getBoolean("redis.timeout"));

        if (auth != null){
            jedisPool =  new JedisPool(config, ph.getString("redis.host"),
                    ph.getInt("redis.port"),
                    ph.getInt("redis.timeout"),
                    ph.getString("redis.auth"));
        }else{
            jedisPool =  new JedisPool(config, ph.getString("redis.host"),
                    ph.getInt("redis.port"),
                    ph.getInt("redis.timeout"));
        }

    }

    public synchronized static Jedis getJedis() {
        if (jedisPool == null ){
            init();
        }
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}
