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
<title>Control Center | Rent eSkates</title>
<div class="container-fluid" style="padding-top: 100px">
        <div class="jumbotron">
            <h2>Control Center</h2>
            <p class="lead">Manage products, users and orders.</p>
        </div>
    <div class="row">
        <div class="col-md">
            <h3>
            <a href="<c:url value="/admin/productInventory/" /> " style="text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block" style="padding: 50px 0 50px 0;">Manage Products</button></a>
                <br>
                <a href="<c:url value="/admin/manageUsers"/> " style="text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block" style="padding: 50px 0 50px 0;">${orderStatsYearly.sales}</button></a>
                <br>
                <a href="<c:url value="/admin/manageOrders"/>" style="text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block" style="padding: 50px 0 50px 0;">Manage Orders</button></a>
            </h3>
        </div>
    </div>
</div>


<%@include file="template/footer.jsp"%>