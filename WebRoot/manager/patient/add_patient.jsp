<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>病人信息管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/patient.js"></script>
<script type="text/javascript" src="plugin/layer.js"></script>
<style type="text/css" >
    .addline{
        width: 100%;
        height: 30px;
        line-height: 30px;
        margin-top: 5px;
		text-align: left;
    }

</style>

</head>

<body style="text-align: center;">
	<h1>医院信息管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<%@include file="/public/patient/add_left.jsp" %>
	<div id="manager_right">
		<form id="pform" method="post">
			<div class="addline">姓名:<input type="text" name="name"></div>
			<div class="addline">性别:
				<select name="sex">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
			<div class="addline">年龄:<input type="text" name="age"></div>
			<div class="addline">密码:<input type="password" name="password"></div>

			<div class="addline"><input type="button" onclick="one_add()" value="添加"></div>
		</form>
	</div>
</body>
</html>
