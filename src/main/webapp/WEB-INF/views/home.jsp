<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: th3pi
  Date: 8/18/2018
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Welcome to Rent eSkates | May I, Inc.</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/rentskates.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
</head>
<body>

<%--Navbar--%>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" style="padding: 20px 10px 20px 10px;">
        <a class="navbar-brand lead" href="#">&nbsp;Rent eSkates</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link btn-dark lead" href="<c:url value="/" />">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <div class="btn-group">
                        <a class="nav-link btn-dark lead" href="<c:url value="/shop" />">
                            Shop
                        </a>
                        <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>

                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="<c:url value="/shop/skateboards" />">Skateboards</a>
                            <a class="dropdown-item" href="<c:url value="/shop/scooters" />">Scooters</a>
                            <a class="dropdown-item" href="<c:url value="/shop/cycles"/>">Cycles</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <ul class="navbar-nav right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item">
                            <div class="btn-group">
                                <a class="btn btn-warning" href="<c:url value="/admin" />">
                                    Control Center
                                </a>
                                <button type="button" class="btn btn-warning dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>

                                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                    <a class="dropdown-item" href="<c:url value="/admin/productInventory" />">Products</a>
                                    <a class="dropdown-item" href="<c:url value="/admin/manageUsers" />">Users</a>
                                    <a class="dropdown-item" href="<c:url value="/admin/manageOrders"/>">Orders</a>
                                </div>
                            </div>
                        </li>
                    </sec:authorize>
                    <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                        <li><a class="nav-link btn-dark lead" href="<c:url value="/customer/cart/"/> "><i class="btn btn-dark material-icons">shopping_cart</i>Cart</a> </li>
                        <li><a class="nav-link btn-dark lead" href="<c:url value="/user/profile/"/> "><i class="btn btn-dark material-icons">person</i>Profile</a></li>

                    </c:if>
                    <li><a class="nav-link btn-dark lead" href="<c:url value="/j_spring_security_logout"/> "><i class="btn btn-dark material-icons">clear</i>Logout</a> </li>

                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a class="nav-link btn-dark lead" href="<c:url value="/login" />">Login</a></li>
                    <li><a class="nav-link btn-dark lead" href="<c:url value="/register"/> ">Sign up</a> </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>

<main role="main">

    <%--Introduction banner--%>

    <div class="container-fluid">
        <div class="row bg-dark" style="padding: 450px 0 450px 0">
            <div class="col-lg-12">
                <h2 class="welcomeText fade-in" style="color: #fff; text-align: center; font-size: 650%; text-shadow: 0 0 60px 5px #ffffff;">Rent <span class="text-flicker-in-glow ">e</span>Skates</h2>
                <p class="lead text-flicker-in-glow-infinite " style="color: #fff; text-align: center; font-size: 250%;">New York's new Mass Transit</p>
            </div>
        </div>
    </div>

        <%--Slides--%>

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-auto"  style="height: 600px" src="<c:url value="../resources/img/bbbanner1.png"/>" alt="First slide">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>FEED YOUR ADRENALINE</h1>
                        <p>Only sky is the limit with the ultimate form of portable transportation - BE ANYWHERE.</p>
                        <p><a class="btn btn-lg btn-primary" href="<c:url value="/register"/> " role="button">Sign up today</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="second-slide" src="<c:url value="../resources/img/owbanner1.png"/>" alt="Second slide">
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1>Some say the float life is the best life</h1>
                        <p>Why don't you put that to test? Start riding the all new OneWheel+ XR starting at $14.99 a day</p>
                        <p><a class="btn btn-lg btn-primary" href="<c:url value="/viewProduct/23"/> " role="button">Learn more</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="third-slide" src="<c:url value="../resources/img/evbanner1.png"/>" alt="Third slide">
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>Have you ever felt this much raw power?</h1>
                        <p>Rent the all the new EVOLVE BAMBOO GTX - the most powerful skateboard ever.</p>
                        <p><a class="btn btn-lg btn-primary" href="#" role="button">GET!</a></p>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

        <%--New arrival highlight section--%>

    <div class="jumbotron">
        <h2 class="display-3">NEW ARRIVALS</h2>
    </div>
    <div class="container">
        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-lg-12 text-center">
                <img class="img-thumbnail" src="../resources/img/bbs-profile-home-header.png" alt="Generic placeholder image" width="1500" height="140">
                <h2 style="padding-top: 1%">Boosted Stealth  <span class="badge badge-secondary"> NEW ARRIVAL</span> </h2>
                <p>Stealth is the high-performance electric longboard you’ve been dreaming of, built from the ground up with attention to detail at every turn, including a new ride mode, exclusive to Stealth, with higher top speed and lightning-fast acceleration.</p>
                <p><a class="btn btn-secondary" href="<c:url value="/viewProduct/21"/> " role="button">View details &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->

    </div><!-- /.container -->

        <%--A simple parallax banner highlighting one of the products--%>

    <div class="container-fluid parallax text-center" style="height: 500px">
        <div class="text-center">
            <h2 class="display-4" style="vertical-align: center; text-align: center; line-height: 500px; color: #fff;">
                The most loved. <small class="text-muted">And the most rented.</small>
            </h2>
        </div>
    </div>
    <div class="jumbotron">
        <h2 class="display-4">OUR TOP THREE</h2>
    </div>
    <div class="container">
        <div class="row" ng-app="cartApp">
            <c:forEach items="${products}" var="product" end="2">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-20">
                        <a href="#"><%@include file="template/productImgAttrProductList.jsp"%></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="<spring:url value="/viewProduct/${product.productID}"/>">${product.productName}</a>
                            </h4>
                            <div class="alert alert-dark" role="alert">
                                <h5 style="color: #1c7430">$${product.productPrice}</h5>
                                <p class="card-text">Range: ${product.productRange} miles</p>
                                <p class="card-text">Recharge time: ${product.productRechargeTime} minutes</p>
                            </div>
                        </div>
                        <div class="card-footer" ng-controller="cartCtrl">
                            <div class="btn-group">
                                <a class="btn btn-outline-secondary btn-sm" href="<c:url value="/viewProduct/${product.productID}"/> ">View</a>
                            </div>
                            <small class="text-muted float-right">${product.productManufacturer}</small>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

        <%--A simple parallax banner highlighting one of the products--%>

        <div class="container-fluid parallaxTwo" style="height: 500px;">
        <div class="text-center">
            <h2 class="display-4" style="vertical-align: center; text-align: center; line-height: 500px; color: #fff;">
                Why walk? <small class="text-muted alert alert-light" style="padding: 0 10px 0 10px;"> When you can float. </small>
            </h2>
        </div>
    </div>
    <!-- FOOTER -->
    <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p>&copy; 2018 May I, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
</main>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/resources/js/controller.js"/> ">
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-slim.min.js"/>"><\/script>')</script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
