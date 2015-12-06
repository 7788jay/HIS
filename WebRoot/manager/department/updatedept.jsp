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

<title>科室修改</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/privilege.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>
<script type="text/javascript" src="plugin/layer.js"></script>
<script type="text/javascript" src="js/dept.js"></script>
</head>

<body>
<div>
 	<div id="p_content">
 		<form id="p_form">
 			<input type="hidden" name="dept_id" value="${d.dept_id }"/>
			<div class="p_input">科室分类：
				<c:forEach var="dept_c" items="${categories }">
					<c:if test="${dept_c.depet_category_id==d.depet_category_id}">${dept_c.name}</c:if>
				</c:forEach>
			</div>
	    	<div class="p_input">科室名称：<input type="text" name="dname" value="${d.name }"/></div>
	    	<div class="p_submit"><input type="button" onclick="UpdateDept()" value="修改"/></div>
   		</form>
   </div>
 </div>
</body>
</html>
