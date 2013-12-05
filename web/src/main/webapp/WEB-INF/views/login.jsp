<%--
  登录页面.
  User: faith
  Date: 13-12-4
  Time: 下午11:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="layout/header.jsp"/>
<form id="loginform" class="form-vertical">
    <div class="control-group normal-text"><h3>登录</h3></div>
    <div class="control-group">
        <div class="controls">
            <div class="add-input">
                            <span class="add-on bg-username">
                                <label for="username">账号</label>
                            </span>
                <input type="text" placeholder="账号" name="username" id="username">
            </div>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <div class="add-input">
                            <span class="add-on bg-password">
                                <label for="password">密码</label>
                            </span>
                <input type="password" placeholder="账号" name="password" id="password">
            </div>
        </div>
    </div>
    <div class="form-actions">
        <span class="pull-left"><a href="${cfx}/register" class="btn btn-primary">注册</a></span>
        <span class="pull-right"><button type="submit" class="btn btn-success">登录</button></span>
    </div>
</form>
<jsp:include page="layout/bottom.jsp"/>