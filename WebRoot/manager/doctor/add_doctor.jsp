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

<title>医生信息管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>


</head>

<body style="text-align: center;">
	<h1>医院信息管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<%@include file="/public/doctor/add_left.jsp" %>
	<div id="manager_right">
		<form action="<%=basePath%>servlet/DoctorServlet?method=one_add" method="post">
			科室分类:<select onchange="listcategory(this.value)">
				<c:forEach var="dept_c" items="${categories }">
				<option value="${dept_c.depet_category_id }">${dept_c.name }</option>
				</c:forEach>
			</select>
			科室:<select id="next" name="dept">
				<c:forEach var="dept" items="${departments }">
				<option value="${dept.dept_id }">${dept.name }</option>
				</c:forEach>
			</select>
			<br/>
			username:<input type="text" name="username"><br/>
			password:<input type="password" name="password"><br/>
			职称:<select name="pro">
				<c:forEach var="pro" items="${pros }">
				<option value="${pro.profession_id }">${pro.profession_name }</option>
				</c:forEach>
			</select>
			<br/>
			<input type="submit" value="添加">
		</form>
	</div>
</body>
</html>
