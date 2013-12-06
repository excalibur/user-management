<%--
  模板 导航
  User: faith
  Date: 13-12-4
  Time: 下午11:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="top.jsp"/>
<header class="navbar">
    <div class="container">
        <div class="navbar-header">
            <a href="/" class="brand">logo</a>
        </div>
        <nav class="navbar-nav pull-right">
            <ul>

                 <c:choose>
                     <c:when test="${CURRENT_USER == null }">
                         <li><a href="/register">注册</a></li>
                         <li><a href="/login">登录</a></li>
                     </c:when>
                     <c:otherwise>
                         <li><a href="/home">用户信息显示</a></li>
                         <li><a href="/update">用户信息修改</a></li>
                         <li><a href="/logout">注销</a></li>
                     </c:otherwise>
                 </c:choose>
            </ul>
        </nav>
    </div>
</header>

<div class="main">
