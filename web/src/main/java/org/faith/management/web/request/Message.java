package org.faith.management.web.request;

/**
 * 简单信息对象封装
 *
 * @author faith
 * @since 0.0.1
 */
public class Message {
    private String message;
    //0 error 1 success 2 alert 3 info 4 loggedIn 5 other
    private int status;

    public Message(String message, String status) {
        this.message = message;
        if (status.equals("error")){
           this.status = 0;
        }else if (status.equals("success")){
           this.status = 1;
        }else if (status.equals("alert")){
            this.status = 2;
        }else if (status.equals("info")){
            this.status = 3;
        }else if (status.equals("loggedIn")){
            this.status = 4;
        }else{
            this.status = 5;
        }
    }

    public Message(String message, int status) {
        this.message = message;
        this.status = status;

    }
    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
