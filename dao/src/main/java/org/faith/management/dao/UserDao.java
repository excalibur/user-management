package org.faith.management.dao;

import org.faith.management.core.entity.domain.User;

/**
 * 用户管理DAO接口
 *
 * 提供了基本的增删改查
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserDao {
    /**
     * 增加用户
     * @param user
     * @return
     */
    User create(User user);

    /**
     * 更新用户
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     * @param username
     */
    void delete(String username);

    /**
     * 根据username获取用户信息
     * @param username
     * @return
     */
    User readByUsername(String username);
}
