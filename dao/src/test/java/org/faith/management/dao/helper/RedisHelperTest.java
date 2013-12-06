package org.faith.management.dao.helper;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/** 
* RedisHelper Tester. 
* 
* @author faith
* @since 0.0.1
*/ 
public class RedisHelperTest {
    private Jedis jedis;

    @Before
    public void before() throws Exception {
        jedis =  RedisHelper.getJedis();
    }

    @Test
    public void testInit(){
        jedis.set("aaa", "bbb");
        Assert.assertEquals(jedis.get("aaa"),"bbb");
    }



} 
