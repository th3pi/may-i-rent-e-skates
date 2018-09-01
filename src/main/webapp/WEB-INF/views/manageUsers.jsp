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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<title>Manage Users | Admin Panel</title>
<div class="container-fluid" style="padding-top: 100px">
    <div class="jumbotron">
        <h1>All Users</h1>
        <p class="lead">Add, customize or view user details.</p>
    </div>
    <input class="form-control" id="myInput" type="text" placeholder="Search by anything...">
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-dark">
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Cart ID</th>
            <th>User Since</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach items="${users}" var="user">

            <tr>
                <td>${user.customerName}</td>
                <td>${user.customerEmail}</td>
                <td>${user.customerPhone}</td>
                <td>${user.cart.cartId}</td>
                <td>${user.joinDate}</td>
                <td>
                    <a class="btn btn-primary" href="<spring:url value="/admin/manageUsers/user/editUser/${user.customerId}" />"><i class="material-icons" data-toggle="tooltip" title="Edit">edit</i></a></td>

            </tr>

        </c:forEach>
        </tbody>
    </table>

    <a href="<spring:url value="/admin/manageUsers/user/addUser"/>" style="color: #fff; text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block">Add User</button></a>
    <script>
        $(document).ready(function(){
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
    <%@include file="/WEB-INF/views/template/footer.jsp" %>

