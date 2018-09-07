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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>

<%--header--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<title>Confirmation | Rent eSkates</title>
    <div class="container slide-in-right" style="padding-top: 100px;">
        <div class="container-fluid jumbotron">
            <h1>Receipt</h1>
            <p class="lead">Here is your order confirmation</p>
        </div>
        <div class="progress">
            <div class="progress-bar w-75" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
        <br>
        <hr>
        <div class="container">
            <div class="row">
                <form:form commandName="order" class="form-horizaontal">
                    <div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Shipping Address</strong><br>
                                        ${order.cart.customer.shippingAddress.streetAddress}
                                    <br>
                                        ${order.cart.customer.shippingAddress.aptNumber}
                                    <br>
                                        ${order.cart.customer.shippingAddress.city}, ${order.cart.customer.shippingAddress.state}, ${order.cart.customer.shippingAddress.zipcode}
                                    <br>
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>Order Date: <fmt:formatDate type="date" value="${now}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Billing Address</strong><br>
                                        ${order.cart.customer.billingAddress.streetAddress}
                                    <br>
                                        ${order.cart.customer.billingAddress.aptNumber}
                                    <br>
                                        ${order.cart.customer.billingAddress.city}, ${order.cart.customer.billingAddress.state}, ${order.cart.customer.billingAddress.zipcode}
                                    <br>
                                </address>
                            </div>
                        </div>
                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>#</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}" >
                                    <tr>
                                        <td class="col-md-5"><em>${cartItem.product.productName}</em></td>
                                        <td class="col-md-3" style="text-align: center">${cartItem.quantity}</td>
                                        <td class="col-md-3" style="text-align: center">$${cartItem.product.productPrice}</td>
                                        <td class="col-md-1" style="text-align: center">$${cartItem.totalPrice}</td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td><h4>Grand Total:</h4></td>
                                    <td></td>
                                    <td>
                                    </td>
                                    <td class="text-center text-success">
                                        <h4>$${order.cart.grandTotal}</h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                        <input type="hidden" name="_flowExecutionKey" />

                        <div class="row">
                            <div class="col-lg-2">
                                <input type="button" value="Back" name="_eventId_backToCollectShippingDetail" class="btn btn-outline-danger btn-lg btn-block"/>
                            </div>
                            <div class="col-lg-8">
                                <input type="submit" value="Place Order" name="_eventId_orderConfirmed" class="btn btn-success btn-lg btn-block"/>
                            </div>
                            <div class="col-lg-2">
                                <input type="button" name="_eventId_cancel" class="btn btn-danger btn-lg btn-block" value="Cancel"/>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="container-fluid jumbotron">
            <h1>Important Information</h1>
            <p class="lead">Placing order does not confirm your order. We will verify payment, our stock and availability. Once the order status turns green and says "Payment Received" we will email you need to pick it up.</p>
        </div>
<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>