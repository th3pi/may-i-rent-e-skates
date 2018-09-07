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
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%--This form is the same as registerCustomer view but filled with pre-existing information only accessible by customers.--%>


<%--header--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<title>Edit User | Admin Panel</title>
<c:if test="${pageContext.request.userPrincipal.name == user.username}">
<div class="container" style="padding-top: 100px">
    <div class="jumbotron">
        <div class="container">
            <h1>Edit AccountID: ${user.customerId}</h1>
            <p>Customize information below</p>
        </div>
    </div>
    <div class="container">
        <%--Form to add product details--%>
        <form:form action="${pageContext.request.contextPath}/user/editProfile" method="post" commandName="user" enctype="multipart/form-data">
            <form:hidden path="customerId" value="${user.customerId}"/>
            <h3>Personal Info</h3>
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="customerName" id="name" class="form-control" value="${user.customerName}"/>
            </div>
            <div class="form-group">
                <label for="email">Email &nbsp;</label>
                <form:input path="customerEmail" id="email" class="form-control" value="${user.customerEmail}" readonly="true"/>
            </div>
            <div class="form-group">
                <label for="username">Username&nbsp;<small class="text-muted">(leave blank to use email as username)</small></label>
                <form:input path="username" id="username" class="form-control" value="${user.customerEmail}" readonly="true"/>
            </div>
            <div class="form-group">
                <label for="password">Password &nbsp;</label>
                <form:password path="password" id="password" class="form-control" value="${user.password}"/>
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="customerPhone" id="phone" class="form-control" value="${user.customerPhone}"/>
            </div>

            <br>
            <hr>

            <h3>Billing Address</h3>
            <div class="form-group">
                <label for="bstreet">Street Address</label>
                <form:input path="billingAddress.streetAddress" id="bstreet" class="form-control" value="${user.billingAddress.streetAddress}"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bapt">Apartment/Floor #:</label>
                <form:input path="billingAddress.aptNumber" id="bapt" class="form-control" value="${user.billingAddress.aptNumber}"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bcity">City</label>
                <form:input path="billingAddress.city" id="bcity" class="form-control" value="${user.billingAddress.city}"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bstate">State</label>
                <form:input path="billingAddress.state" id="bstate" class="form-control" value="${user.billingAddress.state}"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bzipcode">Zipcode</label>
                <form:input path="billingAddress.zipcode" id="bzipcode" class="form-control" value="${user.billingAddress.zipcode}"/>
            </div>
            <br>
            <hr>


            <h3>Shipping Address</h3>
            <br>
            <div class="form-group">
                <label for="sstreet">Street Address</label>
                <form:input path="shippingAddress.streetAddress" id="sstreet" class="form-control" value="${user.shippingAddress.streetAddress}"/>
            </div>
            <br>
            <div class="form-group">
                <label for="sapt">Apartment/Floor #:</label>
                <form:input path="shippingAddress.aptNumber" id="sapt" class="form-control" value="${user.shippingAddress.aptNumber}"/>
            </div>
            <br>
            <div class="form-group">
                <label for="scity">City</label>
                <form:input path="shippingAddress.city" id="scity" class="form-control" value="${user.shippingAddress.city}"/>
            </div>
            <br>
            <div class="form-group">
                <label for="sstate">State</label>
                <form:input path="shippingAddress.state" id="sstate" class="form-control" value="${user.shippingAddress.state}"/>
            </div><br>
            <div class="form-group">
                <label for="szipcode">Zipcode</label>
                <form:input path="shippingAddress.zipcode" id="szipcode" class="form-control" value="${user.shippingAddress.zipcode}"/>
            </div>
            <div style="display: none;">
                <h3>Manager-Only details</h3>
                <br>
                <div class="form-group">
                    <label for="cid">Cart ID: </label>
                    <form:input path="cart.cartId" id="cid" class="form-control" value="${user.cart.cartId}"/>
                </div>
                <br>
                <div class="form-group">
                    <label for="jd">Join date: </label>
                    <form:input path="joinDate" id="jd" class="form-control" value="${user.joinDate}" readonly="true"/>
                </div>
                <br>
                <div class="form-group">
                    <label for="jd">Enabled: </label>
                    <form:input path="enabled" id="jd" class="form-control" value="${user.enabled}" readonly="true"/>
                </div>
            </div>
            <input type="submit" value="Submit" class="btn btn-primary"/>
            <a href="<c:url value="/admin/manageUsers"/> " role="button" class="btn btn-danger">Cancel</a>
        </form:form>
    </div>
</div>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != user.username}">
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
            This profile does not belong to you.
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