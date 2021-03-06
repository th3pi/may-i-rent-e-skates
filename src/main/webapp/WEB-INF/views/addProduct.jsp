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

<%--Introduction to the page--%>

<div class="container" style="padding-top: 100px">
    <div class="jumbotron">
        <div class="container">
            <h1>Add Product</h1>
            <p>Fill in new product information below </p>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <%--Form to add product details--%>
            <form:form action="${pageContext.request.contextPath}/admin/product/addProduct" method="post" commandName="product" enctype="multipart/form-data">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="img">Upload</span>
                    </div>
                    <div class="custom-file">
                        <form:input id="img" cssClass="custom-file-input" path="productImage" type="file" class="form:input" />
                        <label class="custom-file-label" for="img"></label>
                    </div>
                    <%--<input type="file" name="img" multiple="multiple"/>--%>
                </div>
                <div class="form-group">
                <label for="name">Name</label> <form:errors path="productName" cssStyle="color: #b21f2d"/>
                <form:input path="productName" id="name" class="form-control"/>
                </div>

                <%--Radiobuttons to select product type--%>
                <div class="form-group">
                    <label for="type">Product Type</label>
                    <br>
                    <label class="check-box"> <form:radiobutton path="productType" id="type" value="Skateboard"/>Skateboard</label>
                    <br>
                    <label class="check-box"> <form:radiobutton path="productType" id="type" value="Scooter"/>Scooter</label>
                    <br>
                    <label class="check-box"> <form:radiobutton path="productType" id="type" value="Bicycle"/>Bicycle</label>
                </div>
                <div class="form-group">
                    <label for="sku">SKU</label>
                    <form:input path="productSku" id="sku" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="price">Price</label><form:errors path="productPrice" cssStyle="color: #b21f2d"/>
                    <form:input path="productPrice" id="price" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="desc">Description</label>
                    <form:textarea path="productDescription" id="desc" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="qty">Quantity</label><form:errors path="productQuantity" cssStyle="color: #b21f2d"/>
                    <form:input path="productQuantity" id="qty" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="rnt">Max Rent Period</label>
                    <form:input path="productRentLimit" id="rnt" class="form-control"/>
                </div>


                <%--Technical details section--%>
                <h3>Product Technical Details</h3>
                <div class="form-group">
                    <label for="mfg">Manufacturer</label>
                    <form:input path="productManufacturer" id="mfg" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="rng">Range</label>
                    <form:input path="productRange" id="rng" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="rcg">Recharge Time</label>
                    <form:input path="productRechargeTime" id="rcg" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="spd">Speed</label>
                    <form:input path="productSpeed" id="spd" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="wet">Weight</label>
                    <form:input path="productWeight" id="wet" class="form-control"/>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary"/>
                <a href="<c:url value="/admin/productInventory"/> " role="button" class="btn btn-danger">Cancel</a>
            </form:form>
        </div>
    </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>