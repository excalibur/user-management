package org.faith.management.core.entity.domain;

import org.faith.management.core.entity.AbstractEntity;

/**
 * 用户信息
 *
 * @author faith
 * @since 0.0.1
 */
public class User extends AbstractEntity {
    private String username;
    private String password;
    private String name;
    private String birthday;
    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
