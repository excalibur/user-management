package org.faith.management.dao;

import org.faith.management.core.entity.domain.User;

import java.util.List;

/**
 * 用户管理DAO接口
 *
 * 提供了基本的增删改查
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserDao {
    User create(User user);
    void update(User user);
    void delete(String id);
    User readById(String id);
    List<User> readAll();
}
