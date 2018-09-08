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
<title>Control Center | Rent eSkates</title>

<%--This is the control center--%>

<div class="container-fluid" style="padding-top: 100px">
        <div class="jumbotron">
            <h2>Control Center</h2>
            <p class="lead">Manage products, users and orders.</p>
        </div>
    <div id="chart"></div>

    <h4 class="display-4">Order Stats</h4>
    <hr>

    <%--This row is for the order stats--%>

    <div class="row" style="padding-bottom: 30px;">
            <div class="col-md" >
                <div class="text-center border border-danger" style="padding: 80px 0 80px 0">
                    <h4 class="display-3 text-left align-middle" style="font-size: 180%; color: #ff084e"> &nbsp; Pending Orders <span class="float-right" style="font-size: larger">${pending.size()} &nbsp;</span></h4>
                </div>
            </div>
            <div class="col-md" >
                <div class="text-center border border-info" style="padding: 80px 0 80px 0">
                    <h4 class="display-3 text-left align-middle" style="font-size: 180%; color: #17a2b8"> &nbsp; Picked Up Orders <span class="float-right" style="font-size: larger">${pickedup.size()} &nbsp;</span></h4>
                </div>
            </div>
            <div class="col-md" >
                <div class="text-center border border-warning" style="padding: 80px 0 80px 0">
                    <h4 class="display-3 text-left align-middle" style="font-size: 180%; color: #ffc107;"> &nbsp; Awaiting Return <span class="float-right" style="font-size: larger">${areturn.size()} &nbsp;</span></h4>
                </div>
            </div>
            <div class="col-md" >
                <div class="text-center border border-success" style="padding: 80px 0 80px 0">
                    <h4 class="display-3 text-left align-middle" style="font-size: 180%; color: #1e7e34"> &nbsp; Completed <span class="float-right" style="font-size: larger">${completed.size()} &nbsp;</span></h4>
                </div>
            </div>
    </div>

    <%--This row is for the financial stats--%>

    <h4 class="display-4">Financial Stats</h4>
    <hr>
    <div class="row" style="padding-bottom: 30px;">
        <div class="col-md" >
            <div class="text-center border border-success" style="padding: 80px 0 80px 0">
                <h4 class="display-3 text-left align-middle" style="font-size: 180%; color: #1e7e34"> &nbsp; Today's Sales <span class="float-right" style="font-size: larger"><fmt:formatNumber value="${orderStatsDaily.sales}" type="currency" currencySymbol="$"/> &nbsp;</span></h4>
            </div>
        </div>
        <div class="col-md" >
            <div class="text-center border border-success" style="padding: 80px 0 80px 0">
                <h4 class="display-3 text-left align-middle" style="font-size: 180%; color: #1e7e34"> &nbsp; This Month's Sales <span class="float-right" style="font-size: larger"><fmt:formatNumber value="${orderStatsMonthly.sales}" type="currency" currencySymbol="$"/> &nbsp;</span></h4>
            </div>
        </div>
        <div class="col-md" >
            <div class="text-center border border-success" style="padding: 80px 0 80px 0">
                <h4 class="display-3 text-left align-middle" style="font-size: 180%; color: #1e7e34;"> &nbsp; This Year's Sales <span class="float-right" style="font-size: larger"><fmt:formatNumber value="${orderStatsYearly.sales}" type="currency" currencySymbol="$"/> &nbsp;</span></h4>
            </div>
        </div>
    </div>

    <%--Buttons to redirect to admin pages--%>
    <h4 class="display-4">Control Center</h4>
    <hr>
    <div class="row">
        <div class="col-md">
            <a href="<c:url value="/admin/productInventory/" /> " style="text-decoration: none;"><button type="button" class="btn btn-success btn-lg btn-block" style="padding: 50px 0 50px 0;">Manage Products</button></a>
        </div>
        <div class="col-md">
            <a href="<c:url value="/admin/manageUsers"/> " style="text-decoration: none;"><button type="button" class="btn btn-warning btn-lg btn-block" style="padding: 50px 0 50px 0;">Manage Users</button></a>
        </div>
        <div class="col-md">
            <a href="<c:url value="/admin/manageOrders"/>" style="text-decoration: none;"><button type="button" class="btn btn-primary btn-lg btn-block" style="padding: 50px 0 50px 0;">Manage Orders</button></a>
        </div>
    </div>
</div>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script>
    Highcharts.chart('chart', {

        title: {
            text: 'Monthly Sales, 2018'
        },
        yAxis: {
            title: {
                text: 'Sales amount'
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },

        xAxis: {
            categories: [
                'Jan',
                'Feb',
                'Mar',
                'Apr',
                'May',
                'Jun',
                'Jul',
                'Aug',
                'Sep',
                'Oct',
                'Nov',
                'Dec'
            ]
        },
        series: [{
            name: 'Sales per month',
            data: [<c:forEach items="${perMonthSales}" var="m">
                ${m} ,
                </c:forEach> ]
        }],

        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }

    });
</script>
<%@include file="template/footer.jsp"%>