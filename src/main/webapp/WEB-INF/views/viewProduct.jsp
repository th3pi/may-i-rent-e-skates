<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<style>
    .alert{
        display: none;
    }

    .myAlert-top{
        position: fixed;
        top: 5px;
        left:2%;
        width: 96%;
    }
</style>
<%@include file="template/header.jsp"%>
<title>${product.productName} | Rent eSkates</title>
<div class="container-fluid" style="">
    <div class="row bg-dark" style="padding: 8% 10% 5%;">
        <div class="col-md-6">
            <h3 class="welcomeText" style="color: #fff; font-size: 500%; text-shadow: 0 0 5px #fff; text-align: left">${product.productName}</h3>
            <p class="lead glow" style="color: #fff">Manufacturer: ${product.productManufacturer}</p>
        </div>
        <div class="col-md-6" style="text-align: right">
            <h3 style="color: #fff; font-size: 200%;">${product.productType} Range</h3>
            <h4 style="color: #fff; font-size: 200%;">${product.productRange} miles</h4>
            <c:choose>
                <c:when test="${product.productSpeed ge 20}">
                    <h4 style="color: #fff; font-size: 200%;">Blazing fast max speed of ${product.productSpeed}mph</h4>
                </c:when>
                <c:when test="${product.productSpeed le 19}">
                    <h4 class="lead" style="color: #fff; font-size: 200%;"> Safe max speed of ${product.productSpeed}mph</h4>
                </c:when>
            </c:choose>
            <hr>
            <h4 style="color: #fff; font-size: 150%;">Recharge time: ${product.productRechargeTime} minutes</h4>
            <h4 style="color: #fff; font-size: 150%;">${product.productType} weight: ${product.productWeight}lbs</h4>
        </div>
    </div>
    <div class="row alert alert-light" ng-app="cartApp" style="padding-left: 5%; padding-top: 2%; padding-bottom: 5%">
        <div class="myAlert-top alert alert-success fade-in">
            <strong>Success! </strong>
            Product have been successfully added to your cart.
        </div>
        <div class="col-lg-6" style="padding-left: 10%; padding-top: 2%;">
            <%@include file="template/productImageAttrProductPage.jsp"%>
        </div>
        <div class="col-lg-6" style="text-align: left;">
            <h1 class="display-3">Description</h1>
            <hr>
            <p style="width: 500px">${product.productDescription}</p>
            <hr>
            <h4 style="color: #b21f2d">Maximum rent limit: <span class="badge badge-danger">${product.productRentLimit} days</span></h4>
            <hr>
            <h4>Only <span class="badge badge-secondary">1</span> ${product.productType} per customer.</h4>
            <hr>
            <h4 class="lead" style="color: #1e7e34; font-size: 300%;">RENT: $${product.productPrice}<span class="badge badge-secondary" > NEW!</span></h4>
            <br>

            <c:set var="role" scope="page" value="${param.role}" />
            <c:set var="url" scope="page" value="/productList" />
            <c:if test="${role='admin'}">
                <c:set var="url" scope="page" value="/admin/productInventory" />
            </c:if>

            <p ng-controller="cartCtrl">
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <a href="<c:url value="/login"/> " class="btn btn-lg btn-light shadow-sm">Log in to Rent!</a>
                </c:if>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <c:if test="${product.productStatus eq 'Active'}">
                        <a href="#" onclick="myAlertTop()" class="btn btn-success btn-lg" ng-click="addToCart('${product.productID}')">Add to cart: +1 day</a>
                    </c:if>
                    <c:if test="${product.productStatus eq 'Inactive'}">
                        <a href="#" onclick="myAlertTop()" class="btn btn-success btn-lg disabled" ng-click="addToCart('${product.productID}')">Currently Unavailable</a>
                    </c:if>
                    <a href="<spring:url value="/customer/cart"/> " class="btn btn-primary btn-lg">View Cart</a></sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="<spring:url value="/admin/product/editProduct/${product.productID}"/> " class="btn btn-lg btn-primary">Edit Product</a></sec:authorize>
            </p>
        </div>
    </div>
    <h4 class="display-4" style="font-size: 180%;">Other products you may like</h4>
    <hr>
    <div class="row" id="products" ng-app="cartApp">
        <c:forEach items="${contextualProducts}" var="ctProduct" end="5">
            <c:if test="${ctProduct.productID ne product.productID}">
            <div class="col-lg-2">
                <div class="card h-20 slide-in-bck-center">
                    <a href="#"><img src="<c:url value="/resources/img/${ctProduct.productID}.png" /> " alt="image" style="width: 250px; height: 250px;"/>
                    </a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="<spring:url value="/viewProduct/${ctProduct.productID}"/>">${ctProduct.productName}</a>
                        </h4>
                        <a href="<spring:url value="/viewProduct/${ctProduct.productID}"/>" style="text-decoration: none">
                            <div class="btn-light text-left" style="padding: 20px; border-radius: 5px;" role="alert" href="<spring:url value="/viewProduct/${ctProduct.productID}"/>">
                                <h5 style="color: #1c7430">$${ctProduct.productPrice} per day</h5>
                                <p class="card-text">Range: ${ctProduct.productRange} miles</p>
                                <p class="card-text">Recharge time: ${ctProduct.productRechargeTime} minutes</p>
                            </div>
                        </a>
                    </div>
                    <div class="card-footer" ng-controller="cartCtrl">
                        <div class="btn-group">
                            <sec:authorize access="isAnonymous()">
                                <a class="btn btn-sm btn-success" href="<c:url value="/login"/>">Login to rent!</a>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a class="btn btn-sm btn-success" href="<c:url value="/admin/product/editProduct/${ctProduct.productID}"/> ">Edit</a>
                            </sec:authorize>
                            <a class="btn btn-outline-secondary btn-sm" href="<c:url value="/viewProduct/${ctProduct.productID}"/> ">View</a>
                        </div>
                        <span class="badge badge-secondary float-right">NEW</span>
                    </div>
                </div>
            </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<%--Footer--%>
<script src="<c:url value="/resources/js/controller.js"/> ">

</script>

<script>
    function myAlertTop(){
        $(".myAlert-top").show();
        setTimeout(function(){
            $(".myAlert-top").hide();
        }, 2000);
    }
</script>
<%@include file="template/footer.jsp"%>
