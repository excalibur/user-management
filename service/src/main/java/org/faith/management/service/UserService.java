package org.faith.management.service;

import org.faith.management.core.entity.domain.User;
import org.faith.management.core.exception.auth.LoginException;
import org.faith.management.core.exception.auth.RegisterException;
import org.faith.management.core.exception.database.NotFoundException;

/**
 * 用户业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserService {
    /**
     * 登录业务逻辑
     * @param username
     * @param password
     * @throws LoginException  登录产生的异常
     */
    User login(String username, String password) throws LoginException;

    /**
     * 注册业务逻辑
     * @param user  包装的用户信息
     * @return    存储后的用户信息
     * @throws RegisterException    注册产生的异常
     */
    User register(User user) throws RegisterException;

    /**
     * 根据账号获得用户信息  异步验证等等可以使用
     * @param username
     * @return
     * @throws NotFoundException
     */
    User readByUsername(String username) throws NotFoundException;

    /**
     * 更新用户
     * @param user
     * @return
     */
    User update(User user);
}
