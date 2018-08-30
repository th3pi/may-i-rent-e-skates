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
<%@include file="/WEB-INF/views/template/header.jsp"%>
<style>
    th {
        color: #fff;
    }

</style>
<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<%--TODO FIX THIS--%>
<div class="container-fluid" style="padding-top: 80px">
    <div class="jumbotron">
            <h1>All Products</h1>
            <p class="lead">Add, customise or delete product details.</p>
    </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-dark">
                <th>Image</th>
                <th>Product Name</th>
                <th>Type</th>
                <th>Manufacturer</th>
                <th>SKU</th>
                <th>Price</th>
                <th>Speed</th>
                <th>Recharge Time</th>
                <th>Rent Limit</th>
                <th>Action</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><%@include file="template/productImgAttrProductInventory.jsp"%></td>
                    <td>${product.productName}</td>
                    <td>${product.productType}</td>
                    <td>${product.productManufacturer}</td>
                    <td>${product.productSku}</td>
                    <td>$${product.productPrice}</td>
                    <td>${product.productSpeed}mph</td>
                    <td>${product.productRechargeTime}mins</td>
                    <td>${product.productRentLimit} days</td>
                    <td><a href="<spring:url value="/viewProduct/${product.productID}" />"><i class="material-icons" data-toggle="tooltip" title="View">pageview</i></a>
                        <a href="<spring:url value="/admin/product/deleteProduct/${product.productID}" />"><i class="material-icons" data-toggle="tooltip" title="Delete">clear</i></a>
                        <a href="<spring:url value="/admin/product/editProduct/${product.productID}" />"><i class="material-icons" data-toggle="tooltip" title="Edit">edit</i></a></td>

                </tr>
            </c:forEach>
        </table>

    <a href="<spring:url value="/admin/product/addProduct"/>" style="color: #fff; text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block">Add Product</button></a>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>

