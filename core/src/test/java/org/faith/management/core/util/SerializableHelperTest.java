package org.faith.management.core.util;

import org.faith.management.core.entity.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
* SerializableHelper Tester. 
* 
* @author faith
* @since 0.0.1
*/ 
public class SerializableHelperTest { 
    private SerializableHelper<User> serializableHelper;
    private User user;
    @Before
    public void before() throws Exception {
        serializableHelper = new SerializableHelper<User>();
        user = new User();
        user.setUsername("faith");
        user.setPassword("123456");
        user.setName("刘真源");
    }



    private byte[] testSerialize() throws Exception {
        return serializableHelper.serialize(user);
    }


    @Test
    public void testDeserialization() throws Exception {
        byte[] bytes = testSerialize();
        User u = serializableHelper.deserialization(bytes);
        Assert.assertEquals(u, user);

    }


} 
