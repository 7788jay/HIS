<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>

<title>医生排班管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/doctor.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>
<script type="text/javascript" src="plugin/layer.js"></script>

</head>

<body style="text-align: center;" ms-controller="schedule">
	<h1>医生信息列表</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<%@include file="/public/doctor/list_left.jsp" %>

	<div id="manager_right">
		<div style="clear: both"></div>
		<div id="role">
			<div id="role_back"><a href="${pageContext.request.contextPath}/servlet/DoctorServlet?method=getAllDoc">返回</a></div>
			<div id="role_name">排班医生：<span>${doctor.name }</span></div>
			<div id="role_name">职称：<span>${pro.profession_name }</span></div>
			<div id="role_name">所属科室：<span>${dept.name }</span></div>
		</div>
		<table width="100%" class="table01" border="0" cellspacing="0" cellpadding="0" align="center" style="text-align:center">
    		<tr>
    			<td class="td_top">时间</td>
    			<td class="td_top" ms-repeat="week">{{el}}</td>
    		</tr>
			<tr>
				<td class="td_01">上午</td>
				<td class="td_01" ms-repeat="schedule" ms-if-loop="el.time==0">
					<input style="width: 25px" name="schedule" ms-attr-value="{{el.sum}}">
				</td>
			</tr>
			<tr>
				<td class="td_01">下午</td>
				<td class="td_01" ms-repeat="schedule" ms-if-loop="el.time==1">
					<input style="width: 25px" name="schedule" ms-attr-value="{{el.sum}}">
				</td>
			</tr>
    	</table>
		<button  ms-click="save()">保存</button>
		{{name}}
	</div>
</body>
</html>
<script type="text/javascript" src="plugin/avalon/avalon.js"></script>
<script type="text/javascript">
	avalon.ready(function () {
		var vm = avalon.define({
			$id: "schedule",
			week: ["星期一","星期二","星期三","星期四","星期五","星期六","星期日"],
			schedule: [],
			init: function(){
				$.ajax({
					url:"servlet/doctorSchedule/getOne?doctor_id=${doctor.doctor_id }",
					type: "GET",
					contentType:"application/json",
					dataType:"json",
					success:function(data){
						console.log(data);
						vm.schedule=data;
					}
				})
			},
			save: function(){
				var schedule =[];
				$("input[name='schedule']:visible").each(function(i){
					if(i<7){

						schedule.push({time:0,week:i,sum:$(this).val()});
					}else {
						schedule.push({time:1,week:i%7,sum:$(this).val()});

					}
				});
				console.log(schedule);
				$.ajax({
					url:"servlet/doctorSchedule/add?doctor_id=${doctor.doctor_id }",
					type: "POST",
					contentType:"application/json",
					dataType:"json",
					data: JSON.stringify(schedule),
					success:function(data){
						layer.alert(data.message);
					}
				});
			}
		});
		avalon.scan();
		vm.init();
	});
</script>
