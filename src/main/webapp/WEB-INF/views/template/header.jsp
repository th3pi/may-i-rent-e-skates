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

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- Custom styles for this template -->
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">Rent eSkates</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/" />">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/productList" />">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <ul class="navbar-nav right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a>Hello,${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout"/> ">Logout</a> </li>
                    <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                        <li><a href="<c:url value="/customer/cart/"/> ">Cart</a> </li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <li><a href="<c:url value="/admin" />">Admin</a> </li>
                    </c:if>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a class="nav-link" href="<c:url value="/login" />">Login</a></li>
                    <li><a class="nav-link" href="<c:url value="/register"/> ">Register</a> </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>