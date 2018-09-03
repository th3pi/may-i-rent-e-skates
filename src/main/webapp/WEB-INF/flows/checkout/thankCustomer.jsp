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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>

<%--header--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
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
<div id="wrapper" class="animated zoomIn">
    <!-- We make a wrap around all of the content so that we can simply animate all of the content at the same time. I wanted a zoomIn effect and instead of placing the same class on all tags, I wrapped them into one div! -->
    <a class="btn btn-dark" href="<c:url value="/"/> "><h1>
        <!-- The <h1> tag is the reason why the text is big! -->
        <underline>Thank you!</underline>
        <!-- The underline makes a border on the top and on the bottom of the text -->
    </h1></a>
    <br>
    <br>
    <h3>
        Keep an eye out for an email from us. We are hustling to get your order READY ASAP.
        <hr>
        <underline>Meanwhile you can click on "THANK YOU" to go back to the store.</underline>
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