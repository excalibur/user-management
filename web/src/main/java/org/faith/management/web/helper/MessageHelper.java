package org.faith.management.web.helper;

import org.faith.management.web.request.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * 信息反馈工具类
 *
 * @author faith
 * @since 0.0.1
 */
public class MessageHelper {
    // Helper methods
    public static void setup(HttpServletRequest request) {
        request.setAttribute("error", false);
        request.setAttribute("success", false);
        request.setAttribute("alert", false);
        request.setAttribute("info", false);
        request.setAttribute("loggedIn", false);
    }

    public static void addError(String message, HttpServletRequest request) {
        request.setAttribute("error", true);
        request.setAttribute("errorMessage", message);
    }

    public static void addSuccess(String message, HttpServletRequest request) {
        request.setAttribute("success", true);
        request.setAttribute("successMessage", message);
    }

    public static void addAlert(String message, HttpServletRequest request) {
        request.setAttribute("alert", true);
        request.setAttribute("alertMessage", message);
    }

    public static void addInfo(String message, HttpServletRequest request) {
        request.setAttribute("info", true);
        request.setAttribute("infoMessage", message);
    }

    // field message
    public static void addSuccessField(String field,String message, HttpServletRequest request) {
        Message msg = new Message(message,"success");
        request.setAttribute(field, msg);
        request.setAttribute("success", true);
    }

    public static void addAlertField(String field,String message,HttpServletRequest request) {
        Message msg = new Message(message,"alert");
        request.setAttribute(field, msg);
        request.setAttribute("alert", true);
    }

    public static void addInfoField(String field,String message,HttpServletRequest request) {
        Message msg = new Message(message,"info");
        request.setAttribute(field, msg);
        request.setAttribute("info", true);
    }

    public static void addErrorField(String field,String message,HttpServletRequest request) {
        Message msg = new Message(message,"error");
        request.setAttribute(field, msg);
        request.setAttribute("error", true);
    }

    public static boolean hasError(HttpServletRequest request){
        boolean flag = false;
        try {
            flag = (Boolean)request.getAttribute("error");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
