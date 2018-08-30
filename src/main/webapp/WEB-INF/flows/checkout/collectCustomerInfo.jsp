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
<div class="container" style="padding-top: 5%">
    <div class="jumbotron">
        <div class="container">
            <h1>Personal Information</h1>
            <p>Fill in your personal information below </p>
        </div>
    </div>
    <div class="container">
        <%--Form to add product details--%>
        <form:form commandName="order" class="form-horizontal">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="cart.customer.customerName" id="name" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="cart.customer.customerEmail" id="email" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="cart.customer.customerPhone" id="phone" class="form-control"/>
            </div

            <br>
            <br>

            <h3>Billing Address</h3>
            <div class="form-group">
                <label for="bstreet">Street Address</label>
                <form:input path="cart.customer.billingAddress.streetAddress" id="bstreet" class="form-control"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bapt">Apartment/Floor #:</label>
                <form:input path="cart.customer.billingAddress.aptNumber" id="bapt" class="form-control"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bcity">City</label>
                <form:input path="cart.customer.billingAddress.city" id="bcity" class="form-control"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bstate">State</label>
                <form:input path="cart.customer.billingAddress.state" id="bstate" class="form-control"/>
            </div>
            <br>
            <div class="form-group">
                <label for="bzipcode">Zipcode</label>
                <form:input path="cart.customer.billingAddress.zipcode" id="bzipcode" class="form-control"/>
            </div>
            <br>
            <br>

            <input type="hidden" name="_flowExecutionKey">

            <input type="submit" value="Go to shipping details" name="_eventId_customerInfoCollected" class="btn btn-primary"/>
            <input type="button" name="_eventId_cancel" class="btn btn-danger" value="Cancel"/>
        </form:form>
    </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>