package org.faith.management.core.exception;

/**
 * 基本异常类
 *
 * @author faith
 * @since 0.0.1
 */
public class BaseException extends Exception {
    private static final long serialVersionUID = 1L;

    // 记录抛出异常的类
    protected Object errorCode;


    public BaseException(String message) {
        super(message);
    }


    public BaseException(String message, Object errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


    public Object getErrorCode() {
        return errorCode;
    }


}
