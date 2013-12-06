<%--
  模板 页脚
  User: excalibur
  Date: 13-12-4
  Time: 下午11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
<footer>
    <p class="text-center">&copy; 2013 faith. </p>
</footer>
<c:if test="${pageContext.request.requestURI == '/WEB-INF/views/register.jsp'}">
    <script type="text/javascript" src="${cfx}/assets/scripts/main.min.js"></script>
</c:if>
<jsp:include page="bottom.jsp"/>