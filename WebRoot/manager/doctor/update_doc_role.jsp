<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>用户-角色管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/role.css">
<link rel="stylesheet" href="css/doctor.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>

</head>

<body>
	<h1 style="text-align: center;">用户-角色管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<div id="role">
		<div id="role_back"><a href="${pageContext.request.contextPath}/servlet/DoctorServlet?method=getAllDocForUpdate">返回</a></div>
		<div id="role_name">当前用户：<span>${doctor.name }</span></div>
		<div id="role_name">职称：<span>${pro.profession_name }</span></div>
		<div id="role_name">所属科室：<span>${dept.name }</span></div>
	</div>
		<form action="" id="dform"  method="post">
			<div>
				<table width="90%" class="table01" border="0" cellspacing="0" cellpadding="0" style="text-align:center;margin-left: 30px;">
					
		    		<tr>
		    			<td class="td_top"><input type="checkbox"/></td>
		    			<td class="td_top">角色名称</td>
		    			<td class="td_top">创建时间</td>
		    			<td class="td_top">权限描述</td>
		    		</tr>
		    		<c:forEach var="r" items="${roles }">
			    		<tr>
			    			<c:set var="flag" value="t"></c:set>
			    			<c:forEach var="d" items="${docRoles }">
			    				<c:if test="${d.roleid==r.roleid }">
			    					<c:set var="flag" value="tu"></c:set>
			    				</c:if>
			    			</c:forEach>
			    			<td class="td_top"><input type="checkbox" <c:if test="${flag=='tu' }">checked='checked'</c:if> name="roleid" value="${r.roleid }"/></td>
			    			<td class="td_01">${r.rolename }</td>
			    			<td class="td_01">${r.createtime }</td>
			    			<td class="td_01">${r.description }</td>
			    		</tr>
		    		</c:forEach>
		    	</table>
			</div>
			<div style="clear: both"></div>
			<input type="hidden" name="docid" value="${doctor.doctor_id}">
			<input id="p_submit" onclick="updaterole_doc()" value="修改">
		</form>
	</body>
</html>
