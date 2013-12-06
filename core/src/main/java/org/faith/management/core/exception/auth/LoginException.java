package org.faith.management.core.exception.auth;

import org.faith.management.core.exception.BaseException;

/**
 * 登录异常
 *
 * @author faith
 * @since 0.0.1
 */
public class LoginException extends BaseException {
    private static final long serialVersionUID = 1L;

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
