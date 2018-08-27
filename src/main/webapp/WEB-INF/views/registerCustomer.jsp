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

<div class="container" style="padding-top: 5%">
    <div class="row">
        <div class="col-md">
            <h1>Registration</h1>
        </div>
        <div class="col-md">
            <h3>Please fill in your information below: </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">

            <%--Form to add product details--%>
            <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="customerName" id="name" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="username">Name</label>
                    <form:input path="username" id="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <form:input path="customerEmail" id="email" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <form:input path="customerPhone" id="phone" class="form-control"/>
                </div
                <div class="form-group">
                    <label for="password">Phone</label>
                    <form:password path="password" id="password" class="form-control"/>
                </div>


                <h3>Billing Address</h3>
                <div class="form-group">
                    <label for="bstreet">Street Address</label>
                    <form:input path="billingAddress.streetAddress" id="bstreet" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="bapt">Address#2</label>
                    <form:input path="billingAddress.aptNumber" id="bapt" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="bcity">City</label>
                    <form:input path="billingAddress.city" id="bcity" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="bstate">State</label>
                    <form:input path="billingAddress.state" id="bstate" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="bzipcode">Zipcode</label>
                    <form:input path="billingAddress.zipcode" id="bzipcode" class="form-control"/>
                </div>

                <h3>Shipping Address</h3>
                <div class="form-group">
                    <label for="sstreet">Street Address</label>
                    <form:input path="shippingAddress.streetAddress" id="sstreet" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="sapt">Address#2</label>
                    <form:input path="shippingAddress.aptNumber" id="sapt" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="scity">City</label>
                    <form:input path="shippingAddress.city" id="scity" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="sstate">State</label>
                    <form:input path="shippingAddress.state" id="sstate" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="szipcode">Zipcode</label>
                    <form:input path="shippingAddress.zipcode" id="szipcode" class="form-control"/>
                </div>

                <input type="submit" value="Submit" class="btn btn-primary"/>
                <a href="<c:url value="/"/> " role="button" class="btn btn-danger">Cancel</a>
            </form:form>
        </div>
    </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>