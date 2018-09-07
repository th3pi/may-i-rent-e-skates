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
<title>${customer.customerName} | Rent eSkates</title>
<c:if test="${pageContext.request.userPrincipal.name == customer.username}">
<main role="main">

<section class="jumbotron text-center tracking-in-expand" style="padding-top: 120px;">
    <div class="container">
        <h1 class="jumbotron-heading">${customer.customerName}</h1>
        <p class="lead text-muted ">${customer.billingAddress.streetAddress}, ${customer.billingAddress.aptNumber}, ${customer.billingAddress.city}, ${customer.billingAddress.state}, ${customer.billingAddress.zipcode}</p>
        <p>
            <a href="#" class="btn btn-success my-lg-3 disabled">Customer since: ${customer.joinDate}</a>
            <a href="<c:url value="/user/editProfile/${customer.customerId}" />" class="btn btn-primary my-2">Edit profile</a>
        </p>
    </div>
</section>

<div class="album py-5 bg-light">
    <div class="container">
        <h2 class="display-4 text-center tracking-in-expand">Order History</h2>
        <hr>
        <c:choose>

            <%--This will be shown if user never ordered anything--%>

        <c:when test="${orders.size() eq 0}">
            <h2 class="lead text-center tracking-in-expand">You didn't order anything yet.</h2>
            <hr>
            <h2 class="text-center"><a class="btn btn-outline-success heartbeat" href="<c:url value="/shop" />">Click here to get started</a></h2>
        </c:when>
            <c:when test="${orders.size() ne null}">
        <div class="row">

            <%--User order history--%>


            <c:forEach var="order" items="${orders}">
            <div class="col-md-4">
                <div class="card mb-4 shadow-sm shadow-drop-center">
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

                                    <%--User can only cancel order if its still pending verification--%>

                                    <c:if test="${order.orderStatus eq 'Order Awaiting Confirmation'}">
                                        <a class="btn btn-outline-danger btn-sm" href="<c:url value="/user/markOrderAsCancelled/${order.customerOrderId}"/> ">Cancel</a>
                                    </c:if>

                                    <%--Cancel button gets disabled if a payment has been made--%>

                                <c:if test="${order.orderStatus ne 'Order Awaiting Confirmation'}">
                                    <a class="btn btn-outline-danger disabled btn-sm" href="<c:url value="/user/markOrderAsCancelled/${order.customerOrderId}"/> ">Cancel</a>
                                </c:if>
                            </div>
                            <small class="text-muted">Contact us</small>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
            </c:when>
        </c:choose>
    </div>
</div>

</main>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != customer.username}">
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
            This is not your profile. Click on "OOPS!" to check your profile out.
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

<%@include file="/WEB-INF/views/template/footer.jsp" %>
