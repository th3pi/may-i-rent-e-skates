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
<title>Billing Info | Rent eSkates</title>
<div class="container fade-in" style="padding-top: 100px">
    <div class="jumbotron">
        <div class="container">
            <h1>Billing Information</h1>
            <p>Fill in your billing information below </p>
        </div>
    </div>
    <div class="progress">
        <div class="progress-bar w-25" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
    </div>
    <br>
    <hr>
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
                            <small class="text-muted">For: ${item.quantity} Day</small>
                        </div>
                        <span class="text-muted">$${item.totalPrice}</span>
                    </li>
                    </c:forEach>
                    <li class="list-group-item d-flex justify-content-between">
                        <span>Total (USD)</span>
                        <strong>$${order.cart.grandTotal}</strong>
                    </li>
                </ul>
            </div>
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Billing address</h4>
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
                        <form:input path="cart.customer.billingAddress.streetAddress" id="bstreet" class="form-control"/>
                    </div>

                    <div class="mb-3">
                        <label for="bapt">Address 2 <span class="text-muted">(Optional)</span></label>
                        <form:input path="cart.customer.billingAddress.aptNumber" id="bapt" class="form-control"/>
                    </div>

                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="phone">Phone</label>
                            <form:input path="cart.customer.customerPhone" id="phone" class="form-control"/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="bcity">City</label>
                            <form:input path="cart.customer.billingAddress.city" id="bcity" class="form-control"/>
                        </div>
                        <div class="col-md-2 mb-2">
                            <label for="bstate">State</label>
                            <form:input path="cart.customer.billingAddress.state" id="bstate" class="form-control"/>
                        </div>
                        <div class="col-md-2 mb-2">
                            <label for="bzipcode">Zip</label>
                            <form:input path="cart.customer.billingAddress.zipcode" id="bzipcode" class="form-control"/>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <h4 class="mb-3">Payment</h4>
                    <div class="d-block my-3">
                        <div class="custom-control custom-radio">
                            <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                            <label class="custom-control-label" for="credit">Credit card</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                            <label class="custom-control-label" for="debit">Debit card</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required>
                            <label class="custom-control-label" for="paypal">PayPal</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="cc-name">Name on card</label>
                            <input type="text" class="form-control" id="cc-name" placeholder="" >
                            <small class="text-muted">Full name as displayed on card</small>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="cc-number">Credit card number</label>
                            <input type="text" class="form-control" id="cc-number" placeholder="" >

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <label for="cc-expiration">Expiration</label>
                            <input type="text" class="form-control" id="cc-expiration" placeholder="" >

                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="cc-cvv">CVV</label>
                            <input type="text" class="form-control" id="cc-cvv" placeholder="" >
                        </div>
                    </div>
                    <hr class="mb-4">
                        <div class="row">
                            <div class="col-lg-8">
                            <input type="hidden" name="_flowExecutionKey">
                                <input type="submit" value="Go to shipping details" name="_eventId_customerInfoCollected" class="btn btn-primary btn-lg btn-block"/>
                            </div>
                            <div class="col-lg-4">
                                <input type="button" name="_eventId_cancel" class="btn btn-danger btn-lg btn-block" value="Cancel"/>
                            </div>
                        </div>
                    </form:form>
            </div>
        </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>