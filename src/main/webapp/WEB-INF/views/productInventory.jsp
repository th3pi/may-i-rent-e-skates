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
<title>Product Control | Rent eSkates</title>
<%--TODO FIX THIS--%>
<div class="container-fluid" style="padding-top: 100px">
    <div class="jumbotron">
            <h1>All Products</h1>
            <p class="lead">Add, customise or delete product details.</p>
    </div>
    <a href="<spring:url value="/admin/product/addProduct"/>" style="color: #fff; text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block">Add Product</button></a>
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
            <c:forEach items="${products}" var="ctProduct">
                <tr>
                    <td><img src="/resources/img/${ctProduct.productID}.png" alt="image" style="width: 85px; height: 85px;"/></td>
                    <c:if test="${ctProduct.productStatus eq 'Inactive'}">
                        <td class="btn-danger">${ctProduct.productName}</td>
                    </c:if>
                    <c:if test="${ctProduct.productStatus eq 'Active'}">
                        <td>${ctProduct.productName}</td>
                    </c:if>
                    <td>${ctProduct.productType}</td>
                    <td>${ctProduct.productManufacturer}</td>
                    <td>${ctProduct.productSku}</td>
                    <td>$${ctProduct.productPrice}</td>
                    <td>${ctProduct.productSpeed}mph</td>
                    <td>${ctProduct.productRechargeTime}mins</td>
                    <td>${ctProduct.productRentLimit} days</td>
                    <td><a class="btn btn-primary" href="<spring:url value="/viewProduct/${ctProduct.productID}" />"><i class="material-icons" data-toggle="tooltip" title="View">pageview</i></a>
                        <a class="btn btn-success" href="<spring:url value="/admin/product/editProduct/${ctProduct.productID}" />"><i class="material-icons" data-toggle="tooltip" title="Edit">edit</i></a>
                        <a class="btn btn-outline-success" href="<spring:url value="/admin/product/markAsActive/${ctProduct.productID}" />"><i class="material-icons" data-toggle="tooltip" title="Enable">done</i></a>
                        <a class="btn btn-outline-danger" href="<spring:url value="/admin/product/markAsInactive/${ctProduct.productID}" />"><i class="material-icons" data-toggle="tooltip" title="Disable">block</i></a>
                        <a class="btn btn-danger" href="<spring:url value="/admin/product/deleteProduct/${ctProduct.productID}" />"><i class="material-icons" data-toggle="tooltip" title="Delete">clear</i></a>
                        </td>

                </tr>
            </c:forEach>
        </table>

    <a href="<spring:url value="/admin/product/addProduct"/>" style="color: #fff; text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block">Add Product</button></a>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>

