package org.faith.management.core.exception.database;

import org.faith.management.core.exception.BaseException;

/**
 * 数据库查询无结果异常
 *
 * @author faith
 * @since 0.0.1
 */
public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
