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
<%@include file="template/header.jsp"%>

<div class="container" style="padding-top: 3%">
    <div class="row">
        <div class="col-md-12">
            <h2>This is the admin page</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md">
            <h3>
            <a href="<c:url value="/admin/productInventory/" /> ">Product Inventory</a>
            </h3>
        </div>
    </div>
</div>


<%@include file="template/footer.jsp"%>