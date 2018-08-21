<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header--%>
<%@include file="template/header.jsp"%>

<div class="container" style="padding-top: 5%">
    <div class="row">
        <div class="col-md-6">
            <h3>${product.productName}</h3>
        </div>
        <div class="col-md-6" style="text-align: right">
            <h3>${product.productManufacturer}</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <%@include file="template/productImageAttrProductPage.jsp"%>
        </div>
        <div class="col-lg-6">
            <h4>${product.productSku}</h4>
            <p>${product.productType}</p>
            <p>${product.productDescription}</p>
            <p>${product.productPrice}</p>
        </div>
    </div>
</div>

<%--Footer--%>
<%@include file="template/footer.jsp"%>
