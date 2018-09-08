<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: th3pi
  Date: 8/18/2018
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    .alert{
        display: none;
    }

    .myAlert-bottom{
        position: fixed;
        bottom: 5px;
        left:2%;
        width: 96%;
    }
</style>
<title>Shop | Rent eSkates</title>
<!-- Page Content -->
<div class="container" style="padding-top: 80px">

    <div class="row">

        <div class="col-lg-3 slide-in-left">

            <h1 class="my-4">All Products</h1>
            <div class="list-group">
                <a href="<c:url value="/shop/skateboards"/> " class="list-group-item">Skateboards</a>
                <a href="<c:url value="/shop/scooters"/>" class="list-group-item">Scooters</a>
                <a href="<c:url value="/shop/cycles"/>" class="list-group-item">Cycles</a>
                <input class="form-control" id="myInput" type="text" placeholder="Search..">
            </div>
        <br>
            <br>
            <img src="../resources/img/bbv2-side-banner.png" href="<c:url value="/viewProduct/13"/> ">

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div id="carouselExampleIndicators" class="carousel slide my-4 slide-in-right" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item ">
                        <img class="d-block img-fluid" src="<c:url value="../resources/img/bbv2-banner.png"/> " alt="First slide">
                    </div>
                    <div class="carousel-item active">
                        <img class="d-block img-fluid" src="<c:url value="../resources/img/bbs-banner.png"/>" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="<c:url value="../resources/img/owxr-banner.png"/>" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <div class="row" id="products" ng-app="cartApp">
                <c:forEach items="${products}" var="ctProduct">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-20 slide-in-bck-center">
                        <a href="#"><img src="<c:url value="/resources/img/${ctProduct.productID}.png" /> " alt="image" style="width: 250px; height: 250px"/>
                        </a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="<spring:url value="/viewProduct/${ctProduct.productID}"/>">${ctProduct.productName}</a>
                            </h4>
                            <a href="<spring:url value="/viewProduct/${ctProduct.productID}"/>" style="text-decoration: none">
                            <div class="btn btn-light text-left" role="alert" href="<spring:url value="/viewProduct/${ctProduct.productID}"/>">
                            <h5 style="color: #1c7430">$${ctProduct.productPrice} per day</h5>
                                <p class="card-text">Range: ${ctProduct.productRange} miles</p>
                                <p class="card-text">Recharge time: ${ctProduct.productRechargeTime} minutes</p>
                            </div>
                            </a>
                        </div>
                        <div class="card-footer" ng-controller="cartCtrl">
                            <div class="btn-group">
                                <sec:authorize access="isAnonymous()">
                                    <a class="btn btn-sm btn-success" href="<c:url value="/login"/>">Login to rent!</a>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_USER')">
                                    <a class="btn btn-sm btn-success" onclick="myAlertBottom()" ng-click="addToCart('${ctProduct.productID}')"><i class="material-icons">add_shopping_cart</i></a>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <a class="btn btn-sm btn-success" href="<c:url value="/admin/product/editProduct/${ctProduct.productID}"/> ">Edit</a>
                                </sec:authorize>
                                <a class="btn btn-outline-secondary btn-sm" href="<c:url value="/viewProduct/${ctProduct.productID}"/> ">View</a>
                            </div>
                            <span class="badge badge-secondary float-right">NEW</span>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
            <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->
    <div class="myAlert-bottom alert alert-success fade-in">
        <strong>Success! </strong>
        Product have been successfully added to your cart.
    </div>
</div>
<!-- /.container -->
<script>
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#products *").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>
<script>
    function myAlertBottom(){
        $(".myAlert-bottom").show();
        setTimeout(function(){
            $(".myAlert-bottom").hide();
        }, 2000);
    }
</script>
<script src="<c:url value="/resources/js/controller.js"/> ">
<%@include file="template/footer.jsp"%>
