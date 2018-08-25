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
<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Cart</h1>
                <p>Products you are going to rent</p>
            </div>
        </div>
    </section>
    <section ng-app="cartApp">
        <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
        <div>
            <a class="btn btn-danger" ng-click="clearCart()"><span>Clear cart</span> </a>
        </div>
        <table class="table table-hover">
            <tr>
                <th>Product</th>
                <th>One Day Price</th>
                <th>Days</th>
                <th>Total Price</th>
                <th>Action</th>
            </tr>
            <tr ng-repeat = "item in cart.cartItems">
                <td>{{item.product.productName}}</td>
                <td>{{item.product.productPrice}}</td>
                <td>{{item.quantity}}</td>
                <td>{{item.totalPrice}}</td>
                <td><a href="#" class="btn btn-danger" ng-click="removeFromCart(item.product.productId)">remove</a> </td>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th>Grand Total</th>
                <th>{{cart.grandTotal}}</th>
                <th></th>
            </tr>
        </table>
        <a href="<c:url value="/productList"/> ">Continue Shopping</a>
        </div>
    </section>

</div>

<script src="<c:url value="/resources/js/controller.js"/> ">

</script>
<%@include file="template/footer.jsp"%>