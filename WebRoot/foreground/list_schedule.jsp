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
    <title>挂号列表</title>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.css"/>
    <link href="css/lrtk.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="js/manager.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/doctor.js"></script>
    <script type="text/javascript" src="plugin/avalon/avalon.js"></script>

</head>

<body class="container" ms-controller="schedule">
<div class="row">
    <div class="navbar navbar-default" role="navigation">
        　<div class="navbar-header">
        　    <a href="##" class="navbar-brand">HIS</a>
        　</div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="##">首页</a></li>
            <li><a href="##">预约挂号</a></li>
        </ul>
    </div>
</div>
<div class="row">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>医生信息</th>
            <th>预约时间</th>
        </tr>
        </thead>
        <tbody>
        <tr ms-repeat-el="data">
            <!--医生信息start-->
            <td>
                <table class="table table-striped .table-condensed " style="margin: 0">
                    <tr class="info">
                        <td>医生姓名</td>
                        <td>{{el.name}}</td>
                    </tr>
                    <tr>
                        <td>科室名</td>
                        <td>{{el.dept_name}}</td>
                    </tr>
                    <tr>
                        <td>医生职称</td>
                        <td>{{el.profession_name}}</td>
                    </tr>
                </table>
            </td>
            <!--医生信息end-->
            <td>
                <!--预约信息start-->
                <table class="table table-striped .table-condensed" style="margin: 0">
                    <tr class="info">
                        <td>时间</td>
                        <td ms-repeat="order">
                            {{month}}/{{day+$index}}<br/>
                            {{week[el]}}
                        </td>
                    </tr>
                    <tr>
                        <td>上午</td>
                        <td ms-repeat-order="order" ms-if-loop="(el.doctorSchedules[order])!= null">
                            <button class="btn" ms-if="(el.doctorSchedules[order]).left_sum!=0" ms-click="appoint($outer.$index,$index,order)">
                                {{(el.doctorSchedules[order]).left_sum}}
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>下午</td>
                        <td ms-repeat-order="order" ms-if-loop="(el.doctorSchedules[order+7])!= null">
                            <button class="btn" ms-if="(el.doctorSchedules[order+7]).left_sum!=0">
                                {{(el.doctorSchedules[order+7]).left_sum}}
                            </button>
                        </td>
                    </tr>
                </table>
            </td>
            <!--预约信息end-->
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
<script type="text/javascript">

    avalon.ready(function () {
        var vm = avalon.define({
            $id: "schedule",
            data: [],
            month: "",
            day: "",
            order: [],
            week: ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            query: function(){
                $.ajax({
                    url: "servlet/doctorSchedule/getAll",
                    type: "GET",
                    dataType: "json",
                    success: function(data){
                        vm.data = data;
                    }
                });
            },
            appoint :function(d_num,offset,order){
               var schedule =  ((vm.data)[d_num].doctorSchedules)[order];
                console.log(offset);
                $.ajax({
                    url: "servlet/doctorSchedule/appoint",
                    type: "GET",
                    dataType: "json",
                    data: {
                        id: schedule.id,
                        doctor_id: schedule.doctor_id,
                        week: schedule.week,
                        time: schedule.time,
                        left_sum: schedule.left_sum,
                        offset: offset
                    },
                    success: function(data){
                        vm.query();
                    }
                });
            }
        });
        avalon.scan();
        vm.query();
        var date = new Date();
        vm.month = date.getMonth();
        vm.day = date.getDate();
        var week = date.getDay();
        for(var i = 0;i<7;i++){
            vm.order[i] = (week-1+i)%7;
        }
        console.log(vm.order);
    });

</script>

