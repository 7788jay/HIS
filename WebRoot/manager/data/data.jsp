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

<title>数据库管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/privilege.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/data.js"></script>
<script type="text/javascript" src="plugin/layer.js"></script>


</head>

<body>
	<h1 style="text-align: center;">数据库管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<div>
		<table width="90%" class="table01" border="0" cellspacing="0" cellpadding="0" align="center" style="text-align:center">
    		<tr>
    			<td class="td_top">序号</td>
    			<td class="td_top">文件名</td>
    			<td class="td_top">备份时间</td>

    			<td class="td_top">操作</td>
    		</tr>
    		<c:forEach var="d" items="${lists }" varStatus="status">
	    		<tr>
	    			<td class="td_01">${status.index + 1}</td>
	    			<td class="td_01">${d.name }</td>
	    			<td class="td_01">${d.backuptime}</td>

	    			<td class="td_01"><a href="javascript:void(0)" onclick="restore('${d.name}')">还原</a>
	    			<a href="javascript:void(0)" onclick="del('${d.no}')">删除</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    	<div class="privilege"><a href="javascript:void(0)" onclick="backup()">备份数据库</a></div>

	</div>
</body>
</html>
