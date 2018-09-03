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
<<main role="main">

<section class="jumbotron text-center" style="padding-top: 120px;">
    <div class="container">
        <h1 class="jumbotron-heading">${orders.get(0).customer.customerName}</h1>
        <p class="lead text-muted">${orders.get(0).customer.billingAddress.streetAddress}, ${orders.get(0).customer.billingAddress.aptNumber}, ${orders.get(0).customer.billingAddress.city}, ${orders.get(0).customer.billingAddress.state}, ${orders.get(0).customer.billingAddress.zipcode}</p>
        <p>
            <a href="#" class="btn btn-success my-lg-3 disabled">Customer since: ${orders.get(0).customer.joinDate}</a>
            <a href="<c:url value="/shop" />" class="btn btn-primary my-2">Go to Shop</a>
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
                        <p class="card-text">${order.customerOrderId}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
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
