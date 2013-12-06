package org.faith.management.service.impl;

import org.faith.management.core.entity.domain.User;
import org.faith.management.core.exception.auth.LoginException;
import org.faith.management.core.exception.auth.RegisterException;
import org.faith.management.core.exception.database.NotFoundException;
import org.faith.management.core.util.MD5Helper;
import org.faith.management.dao.UserDao;
import org.faith.management.dao.factory.DaoFactory;
import org.faith.management.service.UserService;

import java.util.Date;

/**
 * 用户业务逻辑实现类
 *
 * @author faith
 * @since 0.0.1
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDao();

    @Override
    public User login(String username, String password) throws LoginException {

        if (username == null || username.equals("")){
            throw new LoginException("username mustn't empty.", username);
        }else if(password == null || password.equals("")){
            throw new LoginException("passowrd mustn't empty.", password);
        }
        User u = userDao.readByUsername(username);

        if (u == null){
            throw new LoginException("none user info.");
        }
        // md5加密对比
        if (!u.getPassword().equals(MD5Helper.getMD5ByString(password))){
            throw new LoginException("password don't equals.", password);
        }
        // 更新登录信息

        // 返回获得的用户信息
        return u;
    }

    @Override
    public User register(User user) throws RegisterException {
        if (user == null ){
            throw new RegisterException("user mustn't empty.",user);
        }
        if (user.getUsername() == null || user.getUsername().trim().equals("")){
              throw new RegisterException("username must empty.",user);
        }

        if (user.getPassword() == null || user.getPassword().trim().equals("")){
            throw new RegisterException("password must empty.",user);
        }
        user.setPassword(MD5Helper.getMD5ByString(user.getPassword()));
        return userDao.create(user);
    }

    @Override
    public User readByUsername(String username) throws NotFoundException {
        if (username == null && username.trim().equals("")){
            throw new NotFoundException("username mustn't empty.",username);
        }
        User user = userDao.readByUsername(username);
        if (user == null ){
            throw new NotFoundException("not found user info .",username);
        }
        return user;
    }

    @Override
    public User update(User user) {
        user.setUpdateDate(new Date());
        return userDao.create(user);
    }


}
