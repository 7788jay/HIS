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

<title>权限管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/privilege.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>


</head>

<body>
	<h1 style="text-align: center;">权限管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<div>
		<table width="90%" class="table01" border="0" cellspacing="0" cellpadding="0" align="center" style="text-align:center">
    		<tr>
    			<td class="td_top">权限名称</td>
    			<td class="td_top">资源名称</td>
    			<td class="td_top">权限描述</td>
    			<td class="td_top">权限类型</td>
    			<td class="td_top">操作</td>
    		</tr>
    		<c:forEach var="p" items="${privileges }">
	    		<tr>
	    			<td class="td_01">${p.pname }</td>
	    			<td class="td_01">${p.resourcename }</td>
	    			<td class="td_01">${p.pdescription}</td>
	    			<td class="td_01">${p.type_name }</td>
	    			<td class="td_01"><a href="${pageContext.request.contextPath }/servlet/OrdersServlet?method=select&order_id=${order.id}">修改</a>
	    			<a href="${pageContext.request.contextPath }/servlet/OrdersServlet?method=select&order_id=${order.id}">修改</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    	<div class="privilege"><a href="javascript:void(0)" onclick="addprivilege(this)">添加权限</a></div>
    	<div id="add_privilege">
    		<div id="p_content">
    			<form action="${pageContext.request.contextPath }/servlet/PrivilegeServlet?method=add" method="post">
			    	<div class="p_input">权限名称：<input type="text" name="pname" /></div>
			    	<div class="p_input">资源名称：<input type="text" name="rname" /></div>
			    	<div class="p_text">权限描述：<textarea name="description" cols="50" rows="2" ></textarea></div>
			    	<div class="p_input">权限类型：
			    		<select name="ptype">
			    			<c:forEach var="t" items="${typesList }">
								<option value="${t.tp_name }">${t.tp_name }</option>
			    			</c:forEach>
						</select>
			    	</div>
			    	<div class="p_submit"><input type="submit" value="添加"/></div>
		    	</form>
		    </div>
    	</div>
	</div>
</body>
</html>
