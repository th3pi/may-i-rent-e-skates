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

<%--This form is the same as addProduct view but filled with pre-existing information--%>

<div class="container" style="padding-top: 100px">
    <div class="row">
        <div class="col-md">
            <h1>Edit Product</h1>
        </div>
        <div class="col-md">
            <h3>Fill the below information to edit products</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">

            <%--Form to add product details--%>
            <form:form action="${pageContext.request.contextPath}/admin/product/editProduct" method="post" commandName="product" enctype="multipart/form-data">
                <form:hidden path="productID" value="${product.productID}"/>
                <div class="form-group">
                    <label class="control-box" for="img">Upload Image</label>
                        <%--<input type="file" name="img" multiple="multiple"/>--%>
                    <form:input id="img" path="productImage" type="file" class="form:input" />
                </div>
                <div class="form-group">
                    <label for="name">Name</label><form:errors path="productName" cssStyle="color: #b21f2d"/>
                    <form:input path="productName" id="name" class="form-control" value="${product.productName}"/>
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
                    <form:input path="productSku" id="sku" class="form-control" value="${product.productSku}"/>
                </div>
                <div class="form-group">
                    <label for="price">Price</label><form:errors path="productPrice" cssStyle="color: #b21f2d"/>
                    <form:input path="productPrice" id="price" class="form-control" value="${product.productPrice}"/>
                </div>
                <div class="form-group">
                    <label for="desc">Description</label>
                    <form:textarea path="productDescription" id="desc" class="form-control" value="${product.productDescription}"/>
                </div>

                <div class="form-group">
                    <label for="qty">Quantity</label><form:errors path="productQuantity" cssStyle="color: #b21f2d"/>
                    <form:input path="productQuantity" id="qty" class="form-control" value="${product.productQuantity}"/>
                </div>
                <div class="form-group">
                    <label for="rnt">Max Rent Period</label>
                    <form:input path="productRentLimit" id="rnt" class="form-control" value="${product.productRentLimit}"/>
                </div>


                <%--Technical details section--%>
                <h3>Product Technical Details</h3>
                <div class="form-group">
                    <label for="mfg">Manufacturer</label>
                    <form:input path="productManufacturer" id="mfg" class="form-control" value="${product.productManufacturer}"/>
                </div>
                <div class="form-group">
                    <label for="rng">Range</label>
                    <form:input path="productRange" id="rng" class="form-control" value="${product.productRange}"/>
                </div>
                <div class="form-group">
                    <label for="rcg">Recharge Time</label>
                    <form:input path="productRechargeTime" id="rcg" class="form-control" value="${product.productRechargeTime}"/>
                </div>
                <div class="form-group">
                    <label for="spd">Speed</label>
                    <form:input path="productSpeed" id="spd" class="form-control" value="${product.productSpeed}"/>
                </div>
                <div class="form-group">
                    <label for="wet">Weight</label>
                    <form:input path="productWeight" id="wet" class="form-control" value="${product.productWeight}"/>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary"/>
                <a href="<c:url value="/admin/productInventory"/> " role="button" class="btn btn-danger">Cancel</a>
            </form:form>
        </div>
    </div>
</div>

<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>