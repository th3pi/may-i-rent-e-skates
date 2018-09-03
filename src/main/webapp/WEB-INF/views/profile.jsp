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

<%--header--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<title>${orders.get(0).customer.customerName} | Rent eSkates</title>
<<main role="main">

<section class="jumbotron text-center" style="padding-top: 120px;">
    <div class="container">
        <h1 class="jumbotron-heading">${orders.get(0).customer.customerName}</h1>
        <p class="lead text-muted">${orders.get(0).customer.billingAddress.streetAddress}, ${orders.get(0).customer.billingAddress.aptNumber}, ${orders.get(0).customer.billingAddress.city}, ${orders.get(0).customer.billingAddress.state}, ${orders.get(0).customer.billingAddress.zipcode}</p>
        <p>
            <a href="#" class="btn btn-success my-lg-3 disabled">Customer since: ${orders.get(0).customer.joinDate}</a>
            <a href="<c:url value="/shop" />" class="btn btn-primary my-2">Edit profile</a>
        </p>
    </div>
</section>

<div class="album py-5 bg-light">
    <div class="container">
        <div class="row">
            <c:forEach var="order" items="${orders}">
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title">Order#${order.customerOrderId}</h5>
                        <h6 class="card-subtitle">Place on: ${order.orderDate} </h6>
                        <hr>
                        <c:choose>
                            <c:when test="${order.orderStatus eq null}">
                                <h6 class="btn btn btn-outline-danger">Something went wrong.</h6>
                            </c:when>
                            <c:when test="${order.orderStatus eq 'Order Awaiting Confirmation'}">
                                <h6 class="btn btn-outline-danger text-center">${order.orderStatus}</h6>
                            </c:when>
                            <c:when test="${order.orderStatus eq 'Payment Received'}">
                                <h6 class="btn btn-outline-success text-center">${order.orderStatus}</h6>
                            </c:when>
                            <c:when test="${order.orderStatus eq 'Order Picked Up'}">
                                <h6 class="btn btn-info text-center">${order.orderStatus}</h6>
                            </c:when>
                            <c:when test="${order.orderStatus eq 'Awaiting Return'}">
                                <h6 class="btn btn-warning text-center">${order.orderStatus}</h6>
                            </c:when>
                            <c:when test="${order.orderStatus eq 'Completed'}">
                                <h6 class="btn btn-success text-center">${order.orderStatus}</h6>
                            </c:when>
                            <c:when test="${order.orderStatus eq 'Cancelled'}">
                                <h6 class="btn btn-danger text-center">${order.orderStatus}</h6>
                            </c:when>
                        </c:choose>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <a class="btn btn-sm btn-outline-secondary" href="<c:url value="/user/viewOrder/${order.customerOrderId}"/> ">View</a>
                                    <c:if test="${order.orderStatus ne 'Cancelled'}">
                                        <a class="btn btn-outline-danger btn-sm" href="<c:url value="/user/markOrderAsCancelled/${order.customerOrderId}"/> ">Cancel</a>
                                    </c:if>
                                <c:if test="${order.orderStatus eq 'Cancelled'}">
                                    <a class="btn btn-outline-danger disabled btn-sm" href="<c:url value="/user/markOrderAsCancelled/${order.customerOrderId}"/> ">Cancel</a>
                                </c:if>
                            </div>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

</main>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
