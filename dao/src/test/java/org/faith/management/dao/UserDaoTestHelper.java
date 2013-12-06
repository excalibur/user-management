package org.faith.management.dao;

import org.faith.management.core.entity.domain.User;

/**
 * 用户信息
 *
 * 辅助数据  方便测试
 * @author faith
 * @since 0.0.1
 */
public class UserDaoTestHelper {
    private static User user;
    public static User getUser(){
        if (user == null ){
            user = new User();
            user.setUsername("faith");
            user.setPassword("123456");
            user.setName("刘真源");
        }
        return user;
    }
}
