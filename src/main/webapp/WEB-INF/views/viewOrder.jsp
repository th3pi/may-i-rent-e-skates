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
<c:if test="${pageContext.request.userPrincipal.name == order.customer.username or pageContext.request.isUserInRole('ROLE_ADMIN')}">
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
                                    <td class="col-md-3" style="text-align: center">$${cartItem.lockedPrice}</td>
                                    <td class="col-md-1" style="text-align: center">$${cartItem.quantity * cartItem.product.productPrice}</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td><h4>Grand Total:</h4></td>
                                <td></td>
                                <td>
                                </td>
                                <td class="text-center text-success">
                                    <h4>$${order.orderTotal}</h4>
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
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != order.customer.username and pageContext.request.isUserInRole('ROLE_ADMIN') != true}">
    <style>
        @mixin vertical-align($position: relative) {
            position: $position;
            top: 50%;
            -webkit-transform: translateY(-50%);
            -ms-transform: translateY(-50%);
            transform: translateY(-50%);
        }
        body, html {
            background: #343a40;
        }
        #wrapper {
            width: 600px;
            margin: 0 auto;
            margin-top: 15%;
        }
        h1 {
            color: #EEE;
            text-shadow: -1px -2px 3px rgba(17, 17, 17, 0.3);
            text-align: center;
            font-family: "Monsterrat", sans-serif;
            font-weight: 900;
            text-transform: uppercase;
            font-size: 80px;
            margin-bottom: -5px;
        }
        h1 underline {
            border-top: 5px solid #6c757d;
            border-bottom: 5px solid #6c757d;
        }
        h3 {
            width: 570px;
            margin-left: 16px;
            font-family: "Lato", sans-serif;
            font-weight: 600;
            color: #EEE;
        }

    </style>
    <div id="wrapper" class="animated zoomIn text-center">
        <!-- We make a wrap around all of the content so that we can simply animate all of the content at the same time. I wanted a zoomIn effect and instead of placing the same class on all tags, I wrapped them into one div! -->
        <a class="btn btn-dark" href="<c:url value="/user/profile"/> "><h1 class="text-flicker-in-glow">
            <!-- The <h1> tag is the reason why the text is big! -->
            <underline>OOPS!</underline>
            <!-- The underline makes a border on the top and on the bottom of the text -->
        </h1></a>
        <br>
        <br>
        <h3>
            This order does not belong to you.
            <hr>
            <underline>Click on "OOPS!" to check out your own profile.</underline>
            <!-- The <h3> take is the description text which appear under the <h1> tag. It's there so you can display some nice message to your visitors! -->
        </h3>
    </div>
    <script>
        $( document ).ready(function() {
            // perform some jQuery when page is loaded

            $("h1").hover(function() {
                // when user is hovering the h1
                $( this ).addClass("animated infinite pulse");
                // we add pulse animation and to infinite
            }, function() {
                // when user no longer hover on the h1
                $( this ).removeClass("animated infinite pulse");
                // we remove the pulse
            });
        });
    </script>
</c:if>

    <%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>