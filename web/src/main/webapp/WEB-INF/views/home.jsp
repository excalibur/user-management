<%--
  用户管理主页面
  User: faith
  Date: 13-12-4
  Time: 下午11:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="layout/header.jsp"/>
<div class="main">
    <div class="hero-unit">
        <h1>Hi！${CURRENT_USER.name}这个是一个简单的个人主页</h1>
        <p>可以进行个人信息修改。</p>
        <p><a class="btn btn-success" href="/update?username=${CURRENT_USER.username}">个人信息修改</a></p>
    </div>
</div>
<jsp:include page="layout/footer.jsp"/>