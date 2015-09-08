<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>医院信息管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>

</head>

<body style="text-align: center;">
	<h1>医院信息管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<div id="manager_left"></div>
	<div id="manager_right"></div>
</body>
</html>
