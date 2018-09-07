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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp" %>
<title>Cart | Rent eSkates</title>
<body>
<div class="container" style="padding-top: 100px">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Cart</h1>
                <p>Checkout or clear your cart.</p>
            </div>
        </div>
    </section>


    <c:choose>

        <%--This will be displayed if user has nothing in their cart--%>

        <c:when test="${cartItems.size() eq 0}">
            <h2 class="lead text-center tracking-in-expand">You don't have anything in your cart yet.</h2>
            <hr>
            <h2 class="text-center"><a class="btn btn-outline-success btn-lg heartbeat" href="<c:url value="/shop" />">Click
                here to get started</a></h2>
        </c:when>

        <%--Proper cart will be shown if cart is not empty--%>

        <c:when test="${cartItems.size() ne 0}">
            <section ng-app="cartApp">
                <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
                    <table class="table table-hover">
                        <tr>
                            <th>Product</th>
                            <th>One Day Price</th>
                            <th>Days</th>
                            <th>Total Price</th>
                                <%--<th>Action</th>--%>
                        </tr>
                        <tr ng-repeat="item in cart.cartItems">
                            <td>{{item.product.productName}}</td>
                            <td>&#36;{{item.product.productPrice}}</td>
                            <td>{{item.quantity}}</td>
                            <td>&#36;{{item.totalPrice}}</td>
                                <%--<td><a class="btn btn-danger" ng-click="removeFromCart(item.product.productId)">remove</a> </td>--%>
                        </tr>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Grand Total</th>
                            <th>&#36;{{calGrandTotal()}}</th>
                                <%--<th></th>--%>
                        </tr>
                    </table>
                    <div class="row">
                        <div class="col-md-2">
                            <a class="btn btn-danger btn-lg d-block" ng-click="clearCart()"><span>Clear cart</span> </a>
                        </div>
                        <div class="col-md-7">
                            <a href="<c:url value="/order/${cartId}"/> "class="btn btn-success btn-lg d-block">Checkout</a>

                        </div>

                        <div class="col-md-3">
                            <a class="btn btn-outline-primary btn-lg d-block" href="<c:url value="/shop"/> ">Continue
                                Shopping</a>
                        </div>
                    </div>
                </div>
            </section>
        </c:when>
    </c:choose>
</div>
</body>
<script src="<c:url value="/resources/js/controller.js"/> ">

</script>
<%@include file="template/footer.jsp" %>