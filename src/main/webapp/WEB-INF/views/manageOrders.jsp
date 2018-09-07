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
                <p class="lead">View, fulfill or cancel orders.</p>
            </div>
        </div>
    </div>

    <%--Table starts here.  @id myTable is necessary for the search to work--%>

    <input class="form-control" id="myInput" type="text" placeholder="Search by anything...">
    <table class="table table-striped table-hover">
        <thead>
        <tr class="bg-dark">
            <th>Order ID</th>
            <th>Customer Name</th>
            <th>Phone</th>
            <th>Order Date</th>
            <th class="text-center">Order Status</th>
            <th class="text-center">Order Total</th>
            <th class="text-center">Status Panel</th>
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
                        <td class="btn-outline-danger text-center">${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Payment Received'}">
                        <td class="btn-outline-success text-center">${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Order Picked Up'}">
                        <td class="btn-info text-center">${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Awaiting Return'}">
                        <td class="btn-warning text-center">${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Completed'}">
                        <td class="btn-success text-center">${order.orderStatus}</td>
                    </c:when>
                    <c:when test="${order.orderStatus eq 'Cancelled'}">
                        <td class="btn-danger text-center">${order.orderStatus}</td>
                    </c:when>
                </c:choose>
                <td class="text-center"><fmt:formatNumber value="${order.orderTotal}" type="currency" currencySymbol="$"/></td>

                <%--Buttons to update order status. They are color coded the same way throughout the entire website.--%>

                <td class="text-center">
                    <a class="btn btn-outline-success" href="<spring:url value="/admin/manageOrders/order/markOrderAsPaymentReceived/${order.customerOrderId}" />"><i class="material-icons" data-toggle="tooltip" title="Payment Received">edit</i></a>
                    <a class="btn btn-info" href="<spring:url value="/admin/manageOrders/order/markOrderAsPicked/${order.customerOrderId}" />"><i class="material-icons" data-toggle="tooltip" title="Order Picked Up">edit</i></a>
                    <a class="btn btn-warning" href="<spring:url value="/admin/manageOrders/order/markOrderAsAwaitingReturn/${order.customerOrderId}" />"><i class="material-icons" data-toggle="tooltip" title="Awaiting Return">edit</i></a>
                    <a class="btn btn-success" href="<spring:url value="/admin/manageOrders/order/markOrderAsCompleted/${order.customerOrderId}" />"><i class="material-icons" data-toggle="tooltip" title="Completed">edit</i></a>
                    <a class="btn btn-danger" href="<spring:url value="/admin/manageOrders/order/markOrderAsCancelled/${order.customerOrderId}" />"><i class="material-icons" data-toggle="tooltip" title="Cancelled">edit</i></a>
                    <a class="btn btn-danger" href="<spring:url value="/admin/manageOrders/order/viewOrder/${order.customerOrderId}" />"><i class="material-icons" data-toggle="tooltip" title="View Order Details">pageview</i></a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <script>
        $(document).ready(function(){
            $("#myInput").on("keyup", function() {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });

        $(document).scroll(function(){
            localStorage['page'] = document.URL;
            localStorage['scrollTop'] = $(document).scrollTop();
        });

        $(document).ready(function(){
            if (localStorage['page'] == document.URL) {
                $(document).scrollTop(localStorage['scrollTop']);
            }
        });
    </script>
    <%@include file="/WEB-INF/views/template/footer.jsp" %>

