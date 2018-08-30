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
            <h1>Shipping Information</h1>
            <p>Fill in your shipping information below</p>
        </div>
    </div>
    <div class="container">
        <%--Form to add product details--%>
        <form:form commandName="order" enctype="multipart/form-data">
            <h3>Shipping Address</h3>
            <br>
            <div class="form-group">
                <label for="sstreet">Street Address</label>
                <form:input path="cart.customer.shippingAddress.streetAddress" id="sstreet" class="form-control"/>
            </div>
            <br>
            <div class="form-group">
                <label for="sapt">Apartment/Floor #:</label>
                <form:input path="cart.customer.shippingAddress.aptNumber" id="sapt" class="form-control"/>
            </div>
            <br>
            <div class="form-group">
                <label for="scity">City</label>
                <form:input path="cart.customer.shippingAddress.city" id="scity" class="form-control"/>
            </div>
            <br>
            <div class="form-group">
                <label for="sstate">State</label>
                <form:input path="cart.customer.shippingAddress.state" id="sstate" class="form-control"/>
            </div><br>
            <div class="form-group">
                <label for="szipcode">Zipcode</label>
                <form:input path="cart.customer.shippingAddress.zipcode" id="szipcode" class="form-control"/>
            </div>
            <br>
            <input type="hidden" name="_flowExecutionKey">

            <button name="_eventId_backToCollectCustomerInfo" class="btn btn-danger">Back</button>
            <input type="submit" name="_eventId_shippingDetailCollected" value="Go to Payment"  class="btn btn-primary"/>
            <button name="_eventId_cancel" class="btn btn-danger">Cancel</button>
        </form:form>
    </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>