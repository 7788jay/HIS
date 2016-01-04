<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>个人中心</title>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.css"/>
    <link href="css/lrtk.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="js/manager.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="plugin/layer.js"></script>
    <script type="text/javascript" src="js/doctor.js"></script>
    <script type="text/javascript" src="plugin/avalon/avalon.js"></script>
    <!--样式区-->
    <style>
        .ms-controller, .ms-important, [ms-controller], [ms-important] {
            visibility: hidden;
        }
    </style>
</head>

<body ms-controller="person">
<div class="container">
    <div class="row">
        <div class="navbar navbar-default navbar-static-top col-md-12" role="navigation">
            <div class="navbar-header">
                　 <a href="##" class="navbar-brand">HIS</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="##">首页</a></li>
                <li><a href="foreground/list_schedule.jsp">预约挂号</a></li>
                <li class="active"><a href="?#">个人中心</a></li>
            </ul>
            <c:if test="${patient!=null}">
                <p class="navbar-text navbar-right"><a href="foreground/login.jsp" class="navbar-link">注销 </a> </p>
                <p class="navbar-text navbar-right">欢迎：${patient.name }</p>
            </c:if>
            <c:if test="${patient==null}">
                <div>
                    <p class="navbar-text navbar-right"><a href="foreground/login.jsp" class="navbar-link">登录 </a> </p>
                </div>
            </c:if>
        </div>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><h3 class="text-center">个人中心</h3></div>
            <!-- Table -->
            <table class="table table_border">
                <tr>
                    <td width="25%">姓名: <u>{{patient.name}}</u></td>
                    <td width="15%">性别: <u>{{patient.sex}}</u></td>
                    <td>年龄: <u>{{patient.age}}</u></td>
                </tr>
            </table>

        </div>
        <table class="table table_border">
            <tr>
                <td>医生姓名</td>
                <td>预约时间</td>
                <td>上午/下午</td>
                <td>排号</td>
                <td>状态</td>
            </tr>
            <tr ms-repeat="data">
                <td>{{el.name}}</td>
                <td>{{el.appoint_time | date}}</td>
                <td>{{el.time|time}}</td>
                <td>{{el.priority}}</td>
                <td>
                    <a class="btn btn-warning" ms-click="cancel(el.appoint_id)" ms-if="el.status==0">取消预约</a>
                    <a class="btn btn-danger" disabled="disabled" ms-if="el.status==-1">已取消预约</a>
                    <a class="btn btn-info" disabled="disabled" ms-if="el.status==1">已经就诊</a>
                </td>
            </tr>
        </table>
    </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">

    avalon.ready(function () {
        var vm = avalon.define({
            $id: "person",
            data: [],
            patient_id: '${patient.id }',  //病人id
            patient: {},    //病人信息
            //初始化
            init: function(){
                //病人信息
                $.ajax({
                    url: "/HIS/servlet/PatientServlet/queryOne?patient_id="+vm.patient_id,
                    type: "GET",
                    dataType: "json",
                    success: function (data) {
                        console.log(data);
                        vm.patient = data;
                    }
                });
                //挂号信息
                $.ajax({
                    url: "/HIS/servlet/PatientServlet/queryAppointment?patient_id="+vm.patient_id,
                    type: "GET",
                    dataType: "json",
                    success: function (data) {
                        vm.data = data;
                    }
                });
            },
            //取消预约
            cancel: function (appoint_id) {
                $.ajax({
                    url: "/HIS/fore/schedule/cancelAppointment",
                    type: "POST",
                    dataType: "json",
                    data: {
                        appointment_id:appoint_id,
                        status: -1
                    },
                    success: function (data) {
                        layer.alert(data.message);
                        vm.init();
                    }
                });
            }
        });
        avalon.filters.time=function (i){
            return i==0?"上午":"下午";
        };
        avalon.scan();
        vm.init();
    });

</script>

