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

<title>角色修改</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/privilege.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>
<script type="text/javascript" src="plugin/layer.js"></script>
<script type="text/javascript" src="js/role.js"></script>
</head>

<body>
<div>
 	<div id="p_content">
 		<form id="p_form">
 			<input type="hidden" name="role_id" value="${role.roleid }"/>
	    	<div class="p_input">角色名称：<input type="text" name="rname" value="${role.rolename }"/></div>
	    	<div class="p_text">权限描述：<textarea name="description" cols="50" rows="3" >${role.description }</textarea></div>
	    	<div class="p_submit"><input type="button" onclick="UpdateRoleDetail()" value="修改"/></div>
   		</form>
   </div>
 </div>
</body>
</html>
