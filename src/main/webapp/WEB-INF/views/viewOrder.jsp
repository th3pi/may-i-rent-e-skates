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
<title>Order#${order.customerOrderId} | Rent eSkates</title>
<div class="container" style="padding-top: 100px;">
    <div class="container-fluid jumbotron">
        <h1>Ordet details</h1>

        <p class="lead">Order#${order.customerOrderId}</p>
    </div>
    <div class="container">
            <form:form commandName="order" class="form-horizaontal">
                    <div class="row">
                        <div class="col-lg-6">
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
                        <div class="col-lg-6 text-right">
                            <p>Order Date: ${order.orderDate}</p>
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
                                <th>Name</th>
                                <th>#</th>
                                <th class="text-center">Price</th>
                                <th class="text-center">Total</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="cartItem" items="${od}" >
                                <tr>
                                    <td class="col-md-5"><em>${cartItem.product.productName}</em></td>
                                    <td class="col-md-3" style="text-align: center">${cartItem.quantity}</td>
                                    <td class="col-md-3" style="text-align: center">$${cartItem.product.productPrice}</td>
                                    <td class="col-md-1" style="text-align: center">$${cartItem.quantity * cartItem.product.productPrice}</td>
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
                <div class="container btn btn-success">
                    <h1>Order Status: ${order.orderStatus}</h1>
                </div>
            </form:form>

        </div>
    </div>


    <%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>