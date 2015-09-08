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
<link rel="stylesheet" href="css/doctor.css">
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
	<%@include file="/public/doctor/role_left.jsp" %>
	<div id="manager_right">
		<table width="90%" class="table01" border="0" cellspacing="0" cellpadding="0" align="center" style="text-align:center">
    		<tr>
    			<td class="td_top">医生姓名</td>
    			<td class="td_top">职称</td>
    			<td class="td_top">所属科室</td>
    			<td class="td_top">操作</td>
    		</tr>
    		<c:forEach var="d" items="${doctors }">
	    		<tr>
	    			<td class="td_01">${d.name }</td>
	    			<td class="td_01">
	    				<c:forEach var="pro" items="${professions }">
		    				<c:if test="${pro.profession_id==d.profession_id }">${pro.profession_name }</c:if>
	    				</c:forEach>
					</td>
	    			<td class="td_01">
	    				<c:forEach var="dept" items="${departments }">
		    				<c:if test="${d.dept_id==dept.dept_id }">${dept.name }</c:if>
	    				</c:forEach>
					</td>
	    			<td class="td_01"><a href="${pageContext.request.contextPath }/servlet/DoctorServlet?method=getRoleDoc&doctor_id=${d.doctor_id}">用户授权</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
	</div>
</body>
</html>
