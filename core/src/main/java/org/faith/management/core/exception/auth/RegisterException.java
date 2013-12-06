package org.faith.management.core.exception.auth;

import org.faith.management.core.exception.BaseException;

/**
 * 描述信息
 *
 * @author faith
 * @since 0.0.1
 */
public class RegisterException extends BaseException {

    public RegisterException(String message) {
        super(message);
    }

    public RegisterException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
