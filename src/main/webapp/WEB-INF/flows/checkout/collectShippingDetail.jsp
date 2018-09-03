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
<title>Registration | Rent eSkates</title>
<div class="container" style="padding-top: 100px">
    <div class="jumbotron">
        <div class="container">
            <h1>Shipping Information</h1>
            <p>Fill in your shipping information below</p>
        </div>
    </div>
    <div class="progress">
        <div class="progress-bar w-50" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
    </div>
    <br>
    <hr>
    <%--<div class="container">--%>
        <%--&lt;%&ndash;Form to add product details&ndash;%&gt;--%>
        <%--<form:form commandName="order" enctype="multipart/form-data">--%>
            <%--<h3>Shipping Address</h3>--%>
            <%--<br>--%>
            <%--<div class="form-group">--%>
                <%--<label for="sstreet">Street Address</label>--%>
                <%--<form:input path="cart.customer.shippingAddress.streetAddress" id="sstreet" class="form-control"/>--%>
            <%--</div>--%>
            <%--<br>--%>
            <%--<div class="form-group">--%>
                <%--<label for="sapt">Apartment/Floor #:</label>--%>
                <%--<form:input path="cart.customer.shippingAddress.aptNumber" id="sapt" class="form-control"/>--%>
            <%--</div>--%>
            <%--<br>--%>
            <%--<div class="form-group">--%>
                <%--<label for="scity">City</label>--%>
                <%--<form:input path="cart.customer.shippingAddress.city" id="scity" class="form-control"/>--%>
            <%--</div>--%>
            <%--<br>--%>
            <%--<div class="form-group">--%>
                <%--<label for="sstate">State</label>--%>
                <%--<form:input path="cart.customer.shippingAddress.state" id="sstate" class="form-control"/>--%>
            <%--</div><br>--%>
            <%--<div class="form-group">--%>
                <%--<label for="szipcode">Zipcode</label>--%>
                <%--<form:input path="cart.customer.shippingAddress.zipcode" id="szipcode" class="form-control"/>--%>
            <%--</div>--%>
            <%--<br>--%>
            <%--<input type="hidden" name="_flowExecutionKey">--%>

            <%--<button name="_eventId_backToCollectCustomerInfo" class="btn btn-danger">Back</button>--%>
            <%--<input type="submit" name="_eventId_shippingDetailCollected" value="Go to Payment"  class="btn btn-primary"/>--%>
            <%--<button name="_eventId_cancel" class="btn btn-danger">Cancel</button>--%>
        <%--</form:form>--%>
    <%--</div>--%>
    <div class="container">
        <div class="row">
            <div class="col-md-4 order-md-2 mb-4">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">Your cart</span>
                    <span class="badge badge-secondary badge-pill">${order.cart.cartItems.size()}</span>
                </h4>
                <ul class="list-group mb-3">
                    <c:forEach items="${order.cart.cartItems}" var="item">
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div>
                                <h6 class="my-0">${item.product.productName}</h6>
                                <small class="text-muted">${item.quantity}</small>
                            </div>
                            <span class="text-muted">$${item.product.productPrice}</span>
                        </li>
                    </c:forEach>
                    <li class="list-group-item d-flex justify-content-between">
                        <span>Total (USD)</span>
                        <strong>$${order.cart.grandTotal}</strong>
                    </li>
                </ul>
            </div>
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Shipping Address</h4>
                <form:form commandName="order" class="form-horizontal">
                    <div class="row">
                        <div class="col-md-12 mb-3">
                            <label for="name">Full name</label>
                            <form:input path="cart.customer.customerName" id="name" class="form-control"/>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="email">Email</label>
                        <form:input path="cart.customer.customerEmail" id="email" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <label for="username">Username <span class="text-muted">(Optional)</span></label>
                        <form:input path="cart.customer.username" id="username" class="form-control"/>
                    </div>

                    <div class="mb-3">
                        <label for="bstreet">Address</label>
                        <form:input path="cart.customer.shippingAddress.streetAddress" id="bstreet" class="form-control"/>
                    </div>

                    <div class="mb-3">
                        <label for="bapt">Address 2 <span class="text-muted">(Optional)</span></label>
                        <form:input path="cart.customer.shippingAddress.aptNumber" id="bapt" class="form-control"/>
                    </div>

                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="phone">Phone</label>
                            <form:input path="cart.customer.customerPhone" id="phone" class="form-control"/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="bcity">City</label>
                            <form:input path="cart.customer.shippingAddress.city" id="bcity" class="form-control"/>
                        </div>
                        <div class="col-md-2 mb-2">
                            <label for="bstate">State</label>
                            <form:input path="cart.customer.shippingAddress.state" id="bstate" class="form-control"/>
                        </div>
                        <div class="col-md-2 mb-2">
                            <label for="bzipcode">Zip</label>
                            <form:input path="cart.customer.shippingAddress.zipcode" id="bzipcode" class="form-control"/>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <input type="hidden" name="_flowExecutionKey">
                    <div class="row">
                        <div class="col-lg-2">
                            <input type="button" value="Back" name="_eventId_backToCollectCustomerInfo" class="btn btn-outline-danger btn-lg btn-block"/>
                        </div>
                        <div class="col-lg-8">
                            <input type="submit" value="Go to Order Confirmation" name="_eventId_shippingDetailCollected" class="btn btn-primary btn-lg btn-block"/>
                        </div>
                        <div class="col-lg-2">
                            <input type="button" name="_eventId_cancel" class="btn btn-danger btn-lg btn-block" value="Cancel"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>