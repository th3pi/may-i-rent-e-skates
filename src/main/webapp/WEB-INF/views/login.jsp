<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: th3pi
  Date: 8/18/2018
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>
<title>Login | Rent eSkates</title>
<body class="text-center" style="padding-top: 350px; background-color: #f5f5f5">
    <c:if test="${not empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>
    <div class="container" style="width: 25%;">
    <form class="form-signin fade-in" name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
        <img class="mb-4" src="../resources/img/rentskateslogo.png" alt="" width="250" height="250">
        <br>

        <%--Username validation error--%>
        <c:if test="${not empty error}">
            <div class="error" style="color: #ff084e">${error}</div>
        </c:if>
        <label for="username">Email </label>
        <input type="text" id="username" name="username" placeholder="email@gmail.com" class="form-control" required autofocus/>
        <br>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="password1234" class="form-control" />
        <br>
        <input type="submit" value="Log me in!" class="btn btn-lg btn-outline-primary"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <a class="btn btn-lg btn-primary" href="/register">Sign up</a>
    </form>
    </div>
</body>
<%@include file="template/footer.jsp"%>
