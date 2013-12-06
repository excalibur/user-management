<%--
  登录页面.
  User: faith
  Date: 13-12-4
  Time: 下午11:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="layout/header.jsp"/>
<form id="loginform" class="form-vertical<c:if test="${error}"> error</c:if>" method="post">
    <div class="control-group normal-text"><h3>登录</h3></div>
    <c:if test="${error}">
        <div class="control-group normal-text">
            <p>${errorMessage}</p>
        </div>
    </c:if>
    <div class="control-group">
        <div class="controls">
            <div class="add-input">
                            <span class="add-on bg-username">
                                <label for="username">账号</label>
                            </span>
                <input type="text" placeholder="账号" name="username" id="username">
                <c:if test="${username != null }">
                    <p>${username.message}</p>
                </c:if>
            </div>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <div class="add-input">
                            <span class="add-on bg-password">
                                <label for="password">密码</label>
                            </span>
                <input type="password" placeholder="密码" name="password" id="password">
                <c:if test="${password != null }">
                    <p>${password.message}</p>
                </c:if>
            </div>
        </div>
    </div>
    <div class="form-actions">
        <span class="pull-left"><a href="${cfx}/register" class="btn btn-primary">注册</a></span>
        <span class="pull-right"><button type="submit" class="btn btn-success">登录</button></span>
    </div>
</form>
<jsp:include page="layout/footer.jsp"/>