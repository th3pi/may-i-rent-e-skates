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
<title>Registration | Rent eSkates</title>
<div class="container" style="padding-top: 100px">
        <div class="jumbotron">
            <div class="container">
                <h1>Registration</h1>
                <p>Fill in your information below </p>
            </div>
        </div>
            <div class="container">
            <%--Form to add product details--%>
            <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="customerName" id="name" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="email">Email &nbsp;</label><span style="color:#ff084e">${emailMsg}</span><form:errors path="customerEmail" cssStyle="color: #ff084e"/>
                    <form:input path="customerEmail" id="email" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:hidden path="username" id="username" class="form-control" value="${customer.customerEmail}"/>
                </div>
                <div class="form-group">
                    <label for="password">Password &nbsp;</label><span style="color:#ff084e">${pwMsg}</span><form:errors path="password" cssStyle="color: #ff084e"/>
                    <form:password path="password" id="password" class="form-control" onkeyup="check()"/>
                </div>
                <div class="form-group">
                    <label for="cpassword">Confirm Password &nbsp;</label><span style="color:#ff084e">${pwMsg}</span><form:errors path="password" cssStyle="color: #ff084e"/>
                    <input type="password" id="cpassword" class="form-control" onkeyup="check()"/>
                    <span class="lead" id='message'></span>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <form:input path="customerPhone" id="phone" class="form-control"/>
                </div

                <br>
                <br>

                <h3>Billing Address</h3>
                <div class="form-group">
                    <label for="bstreet">Street Address</label>
                    <form:input path="billingAddress.streetAddress" id="bstreet" class="form-control"/>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label for="bapt">Apartment/Floor #:</label>
                            <form:input path="billingAddress.aptNumber" id="bapt" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label for="bcity">City</label>
                            <form:input path="billingAddress.city" id="bcity" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label for="bstate">State</label>
                            <form:input path="billingAddress.state" id="bstate" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label for="bzipcode">Zipcode</label>
                            <form:input path="billingAddress.zipcode" id="bzipcode" class="form-control"/>
                        </div>
                    </div>
                </div>
                <br>


                <input type="checkbox" onclick="autoFillShipping(this.form)" name="autoFillShip">
                <em>Shipping address same as Billing address?</em>

                <hr>
                <h3>Shipping Address</h3>
                <br>
                <div class="form-group">
                    <label for="sstreet">Street Address</label>
                    <form:input path="shippingAddress.streetAddress" id="sstreet" class="form-control"/>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label for="sapt">Apartment/Floor #:</label>
                            <form:input path="shippingAddress.aptNumber" id="sapt" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label for="scity">City</label>
                            <form:input path="shippingAddress.city" id="scity" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label for="sstate">State</label>
                            <form:input path="shippingAddress.state" id="sstate" class="form-control"/>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label for="szipcode">Zipcode</label>
                            <form:input path="shippingAddress.zipcode" id="szipcode" class="form-control"/>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-8">
                        <input type="submit" value="Sign up" class="btn btn-primary btn-lg btn-block" id="submitButton"/>
                    </div>
                    <div class="col-lg-4">
                        <a href="<c:url value="/"/> " role="button" class="btn btn-danger btn-lg btn-block">Cancel</a>
                    </div>
                </div>

            </form:form>
            </div>
        </div>

    <%--Script too auto fill shipping address with billing address information--%>

<script>
    function autoFillShipping(a) {
        if(a.autoFillShip.checked == true){
            a.sstreet.value = a.bstreet.value;
            a.sapt.value = a.bapt.value;
            a.scity.value = a.bcity.value;
            a.sstate.value = a.bstate.value;
            a.szipcode.value = a.bzipcode.value;
        }
        if(a.autoFillShip.checked == false){
            a.sstreet.value = '';
            a.sapt.value = '';
            a.scity.value = '';
            a.sstate.value = '';
            a.szipcode.value = '';
        }
    }
</script>

    <%--Script to check password and disable the submit button if password isn't correct.--%>

<script>
    var check = function() {
        if (document.getElementById('password').value ==
            document.getElementById('cpassword').value) {
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'Password matches';
            document.getElementById('submitButton').disabled = false;
        } else {
            document.getElementById('message').style.color = 'red';
            document.getElementById('message').innerHTML = 'Password does not match';
            document.getElementById('submitButton').disabled = true;
        }
    }
</script>
<%--footer--%>
<%@include file="/WEB-INF/views/template/footer.jsp" %>