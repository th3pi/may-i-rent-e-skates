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
<c:if test="${pageContext.request.userPrincipal.name == cart.customer.username}">
<body>
<div class="container" style="padding-top: 100px">
    <section>
        <div class="jumbotron fade-in">
            <div class="container">
                <h1 style="text-shadow: 0 0 60px 5px #ffffff;">Cart</h1>
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
                <div class="fade-in" ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
                    <table class="table table-hover">
                        <tr>
                            <th>Image</th>
                            <th>Product</th>
                            <th>One Day Price</th>
                            <th>Days</th>
                            <th>Total Price</th>
                                <%--<th>Action</th>--%>
                        </tr>
                        <tr ng-repeat="item in cart.cartItems">
                            <td><img src="/resources/img/{{item.product.productID}}.png" alt="image" style="width: 85px; height: 85px;"/></td>
                            <td>{{item.product.productName}}</td>
                            <td>&#36;{{item.product.productPrice}}</td>
                            <td>{{item.quantity}}</td>
                            <td>&#36;{{item.totalPrice}}</td>
                                <%--<td><a class="btn btn-danger" ng-click="removeFromCart(item.product.productId)">remove</a> </td>--%>
                        </tr>
                        <tr>
                            <th></th>
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
</c:if>
<c:if test="${pageContext.request.userPrincipal.name != cart.customer.username}">
    <style>
        @mixin vertical-align($position: relative) {
            position: $position;
            top: 50%;
            -webkit-transform: translateY(-50%);
            -ms-transform: translateY(-50%);
            transform: translateY(-50%);
        }
        body, html {
            background: #343a40;
        }
        #wrapper {
            width: 600px;
            margin: 0 auto;
            margin-top: 15%;
        }
        h1 {
            color: #EEE;
            text-shadow: -1px -2px 3px rgba(17, 17, 17, 0.3);
            text-align: center;
            font-family: "Monsterrat", sans-serif;
            font-weight: 900;
            text-transform: uppercase;
            font-size: 80px;
            margin-bottom: -5px;
        }
        h1 underline {
            border-top: 5px solid #6c757d;
            border-bottom: 5px solid #6c757d;
        }
        h3 {
            width: 570px;
            margin-left: 16px;
            font-family: "Lato", sans-serif;
            font-weight: 600;
            color: #EEE;
        }

    </style>
    <div id="wrapper" class="animated zoomIn text-center">
        <!-- We make a wrap around all of the content so that we can simply animate all of the content at the same time. I wanted a zoomIn effect and instead of placing the same class on all tags, I wrapped them into one div! -->
        <a class="btn btn-dark" href="<c:url value="/customer/cart/${cartId}"/> "><h1 class="text-flicker-in-glow">
            <!-- The <h1> tag is the reason why the text is big! -->
            <underline>OOPS!</underline>
            <!-- The underline makes a border on the top and on the bottom of the text -->
        </h1></a>
        <br>
        <br>
        <h3>
            This is not your cart.
            <hr>
            <underline>Click on "OOPS!" to check out your own profile.</underline>
            <!-- The <h3> take is the description text which appear under the <h1> tag. It's there so you can display some nice message to your visitors! -->
        </h3>
    </div>
    <script>
        $( document ).ready(function() {
            // perform some jQuery when page is loaded

            $("h1").hover(function() {
                // when user is hovering the h1
                $( this ).addClass("animated infinite pulse");
                // we add pulse animation and to infinite
            }, function() {
                // when user no longer hover on the h1
                $( this ).removeClass("animated infinite pulse");
                // we remove the pulse
            });
        });
    </script>
</c:if>
<script src="<c:url value="/resources/js/controller.js"/> ">

</script>
<%@include file="template/footer.jsp" %>