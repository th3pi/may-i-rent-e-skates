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
<title>Cart | Rent eSkates</title>
<div class="container" style="padding-top: 5%">
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
            <%--<div class="card h-20">--%>
                <%--<a href="#"><%@include file="template/productImgAttrProductList.jsp"%></a>--%>
                <%--<div class="card-body">--%>
                    <%--<h4 class="card-title">--%>
                        <%--<a href="<spring:url value="/viewProduct/${product.productID}"/>">{{item.product.productName}}</a>--%>
                    <%--</h4>--%>
                    <%--<div class="alert alert-dark" role="alert">--%>
                        <%--<h5 style="color: #1c7430">$ {{item.product.productPrice}}</h5>--%>
                        <%--<p class="card-text">Days: {{item.quantity}}</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="card-footer">--%>
                    <%--<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>--%>
                <%--</div>--%>
            <%--</div>--%>
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
                <th>{{calcGrandTotal()}}</th>
                <th></th>
            </tr>
        </table>
        <a href="<c:url value="/shop"/> ">Continue Shopping</a>
        </div>
    </section>
</div>

<script src="<c:url value="/resources/js/controller.js"/> ">

</script>
<%@include file="template/footer.jsp"%>