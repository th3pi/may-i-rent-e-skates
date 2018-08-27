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
<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Cart</h1>
            </div>
        </div>
    </section>
    <a href="<c:url value="/productList"/> ">Continue Shopping</a>


</div>

<script src="<c:url value="/resources/js/controller.js"/> ">

</script>
<%@include file="template/footer.jsp"%>