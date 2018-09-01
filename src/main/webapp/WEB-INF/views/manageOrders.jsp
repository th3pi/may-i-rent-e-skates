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
    <div class="jumbotron" style="height: 250px;">
        <div class="row">
            <div class="col-lg-10">
                <h1>All Orders</h1>
                <p class="lead">View, fulfill or delete orders.</p>
            </div>
        </div>
    </div>
    <input class="form-control" id="myInput" type="text" placeholder="Search by anything...">
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-dark">
            <th>Order ID</th>
            <th>Customer Name</th>
            <th>Phone</th>
            <th>Order Date</th>
            <th>Order Status</th>
            <th>Order Total</th>
            <th></th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach items="${orders}" var="order">

            <tr>
                <td>${order.customerOrderId}</td>
                <td>${order.customer.customerEmail}</td>
                <td>${order.customer.customerPhone}</td>
                <td>${order.orderDate}</td>
                <c:choose>
                    <c:when test="${order.orderStatus eq null}">
                        <td>${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Order Awaiting Confirmation'}">
                        <td style="color: #fd7e14">${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Order Picked Up'}">
                        <td style="color: #ff084e">${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Order Completed'}">
                        <td style="color: #1e7e34">${order.orderStatus}</td>
                    </c:when>
                </c:choose>
                <td>${order.cart.grandTotal}</td>
                <td>
                    <a class="btn btn-primary" href="<spring:url value="/admin/manageUsers/user/editUser/${order.customer.customerId}" />"><i class="material-icons" data-toggle="tooltip" title="Edit">edit</i></a></td>
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

