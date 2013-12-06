package org.faith.management.core.exception.database;

import org.faith.management.core.exception.BaseException;

/**
 * 数据库查询结果结果为0异常
 *
 * @author faith
 * @since 0.0.1
 */
public class ZeroResultsException extends BaseException {
    public ZeroResultsException(String message) {
        super(message);
    }

    public ZeroResultsException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
