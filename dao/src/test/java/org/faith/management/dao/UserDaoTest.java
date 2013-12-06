package org.faith.management.dao;

import junit.framework.Assert;
import org.faith.management.core.entity.domain.User;
import org.faith.management.dao.factory.DaoFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Userdao test.
 *
 * @author faith
 * @since 0.0.1
 */
public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void setUp(){
       userDao = DaoFactory.getUserDao();
    }
    @Test
    public void testCreate(){
        User user = userDao.create(UserDaoTestHelper.getUser());
    }

    @Test
    public void testUpdate(){
        testCreate();
        User user = UserDaoTestHelper.getUser();
        user.setName("faith11");
        userDao.update(user);
    }

    @Test
    public void testDelete(){
        testCreate();
        User user = UserDaoTestHelper.getUser();
        userDao.delete(user.getUsername());
    }

    @Test
    public void testReadByUsername(){
        testCreate();
        User user = UserDaoTestHelper.getUser();
        User u = userDao.readByUsername(user.getUsername());
        Assert.assertEquals(u,user);
    }
}
