<%--
  修改用户信息页面
  User: faith
  Date: 13-12-4
  Time: 下午10:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="layout/header.jsp"/>
<form id="registerform" class="form-vertical<c:if test="${error}"> error</c:if>" method="post">
    <div class="control-group normal-text"><h3>用户信息修改</h3></div>
    <div class="control-group">
        <div class="controls">
            <div class="add-input text-right">
                                        <span class="add-on bg-username">
                                            <label for="username">账号</label>
                                        </span>
                <input type="text" disabled placeholder="账号" name="username" id="username" value="${user.username}">
                <c:if test="${username != null }">
                    <p>${username.message}</p>
                </c:if>
            </div>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <div class="add-input text-right">
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
    <div class="control-group">
        <div class="controls">
            <div class="add-input text-right">
                                        <span class="add-on bg-password">
                                            <label for="confirm_password">确认密码</label>
                                        </span>
                <input type="password" placeholder="确认密码" name="confirm_password" id="confirm_password">
            </div>
            <c:if test="${confirm_password != null }">
                <p>${confirm_password.message}</p>
            </c:if>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <div class="add-input text-right">
                                        <span class="add-on bg-password">
                                            <label for="name">姓名</label>
                                        </span>
                <input type="text" placeholder="姓名" name="name" id="name" value="${user.name}">
                <c:if test="${name != null }">
                    <p>${name.message}</p>
                </c:if>
            </div>
        </div>
    </div>
    <div class="form-actions">
        <span class="pull-left"><button type="reset" class="btn btn-primary">重置</button></span>
        <span class="pull-right"><button type="submit" class="btn btn-success">提交</button></span>
    </div>
</form>
<jsp:include page="layout/footer.jsp"/>