<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<%@include file="template/header.jsp"%>
<title>${product.productName} | Rent eSkates</title>
<div class="container-fluid" style="">
    <div class="row bg-dark" style="padding-top: 8%; padding-left: 10%; padding-right: 10%; padding-bottom: 5%;">
        <div class="col-md-6">
            <h3 style="color: #fff; font-size: 500%;">${product.productName}</h3>
            <p class="lead" style="color: #fff">Manufacturer: ${product.productManufacturer}</p>
        </div>
        <div class="col-md-6" style="text-align: right">

        </div>
    </div>
    <div class="row" style="padding-left: 5%; padding-top: 2%; padding-bottom: 5%">
        <div class="col-lg-6" style="padding-left: 10%; padding-top: 2%;">
            <%@include file="template/productImageAttrProductPage.jsp"%>
        </div>
        <div class="col-lg-6" style="text-align: left;">
            <h1 class="display-3">${product.productType} Range</h1>
            <h1 class="display-4" style="color: #b21f2d">${product.productRange} miles</h1>
            <p style="width: 500px">${product.productDescription}</p>
            <c:choose>
                <c:when test="${product.productSpeed ge 20}">
                    <h4 style="color: #b21f2d">Blazing fast speed of ${product.productSpeed}mph</h4>
                </c:when>
                <c:when test="${product.productSpeed le 19}">
                    <h4 style="color: #1c7430"> Safe pace speed of ${product.productSpeed}mph</h4>
                </c:when>
            </c:choose>
            <h4>${product.productType} recharge time: ${product.productRechargeTime} minutes</h4>
            <h4>${product.productType} weight: ${product.productWeight}lbs</h4>
            <h4 class="lead" style="color: #1e7e34; font-size: 300%;">RENT: $${product.productPrice}<span class="badge badge-secondary" > NEW!</span></h4>
            <div class="alert alert-primary" style="width: 50%;">Rent limit is <span style="color: #b21f2d">${product.productRentLimit}</span> days!</div>
        </div>
    </div>
</div>

<%--Footer--%>
<%@include file="template/footer.jsp"%>
