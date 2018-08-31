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
<%@include file="/WEB-INF/views/template/header.jsp"%>
<style>
    th {
        color: #fff;
    }

</style>
<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<%--TODO FIX THIS--%>
<div class="container-fluid" style="padding-top: 100px">
    <div class="jumbotron">
        <h1>All Users</h1>
        <p class="lead">Add, customise or view user details.</p>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-dark">
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Join Date</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.customerName}</td>
                <td>${user.customerEmail}</td>
                <td>${user.customerPhone}</td>
                <td>${user.joinDate}</td>
                <td><a href="<spring:url value="/viewProduct/${user.customerId}" />"><i class="material-icons" data-toggle="tooltip" title="View">pageview</i></a>
                    <a href="<spring:url value="/admin/manageUsers/deleteuser/${user.customerId}" />"><i class="material-icons" data-toggle="tooltip" title="Delete">clear</i></a>
                    <a href="<spring:url value="/admin/manageUsers/user/editUser/${user.customerId}" />"><i class="material-icons" data-toggle="tooltip" title="Edit">edit</i></a></td>

            </tr>
        </c:forEach>
    </table>

    <a href="<spring:url value="/admin/product/addProduct"/>" style="color: #fff; text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block">Add Product</button></a>

    <%@include file="/WEB-INF/views/template/footer.jsp" %>

