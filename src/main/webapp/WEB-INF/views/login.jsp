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
<title>Login / Register | Rent eSkates</title>
<div class="container" style="padding-top: 5%">
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form class="form-signin" name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
        <c:if test="${not empty error}">
            <div class="error" style="color: #ff084e">${error}</div>
        </c:if>
        <label for="username">User: </label>
        <input type="text" id="username" name="username" class="form-control" />
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" />
        <input type="submit" value="Submit" class="btn btn-primary"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>
<%--<form class="form-signin" name="loginForm" action="<c:url value="/j_security_check"/> " method="post">--%>
    <%--<img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
    <%--<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>--%>
    <%--<label for="inputEmail" class="sr-only">Email address</label>--%>
    <%--<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>--%>
    <%--<label for="inputPassword" class="sr-only">Password</label>--%>
    <%--<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>--%>
    <%--<div class="checkbox mb-3">--%>
        <%--<label>--%>
            <%--<input type="checkbox" value="remember-me"> Remember me--%>
        <%--</label>--%>
    <%--</div>--%>
    <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
<%--</form>--%>
<%@include file="template/footer.jsp"%>
