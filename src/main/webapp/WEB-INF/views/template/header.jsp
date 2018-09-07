<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <%--<title>What do you want to rent?</title>--%>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/rentskates.css"/>" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- Custom styles for this template -->
</head>
<body>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%--Navbar template--%>


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
                                <a class="nav-link btn btn-warning lead" href="<c:url value="/admin" />" style="color: #000">
                                    <i class="btn btn-warning material-icons">work_outline</i>Control Center</a>
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
                    <li><a class="nav-link btn-dark lead" href="<c:url value="/register"/> ">Register</a> </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>