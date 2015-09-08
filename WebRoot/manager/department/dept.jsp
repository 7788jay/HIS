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

<title>科室管理</title>
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
	<h1 style="text-align: center;">科室管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<div>
		<table width="90%" class="table01" border="0" cellspacing="0" cellpadding="0" align="center" style="text-align:center">
    		<tr>
    			<td class="td_top">科室分类</td>
    			<td class="td_top">科室名称</td>
    			<td class="td_top">操作</td>

    		</tr>
    		<c:forEach var="d" items="${departments }">
	    		<tr>
	    			<td class="td_01">
						<c:forEach var="dept_c" items="${categories }">
							<c:if test="${dept_c.depet_category_id==d.depet_category_id}">${dept_c.name}</c:if>
						</c:forEach>
					</td>
	    			<td class="td_01">${d.name }</td>
	    			<td class="td_01"><a href="javascript:updateInit('${d.dept_id}')">修改</a>
	    			<a href="${pageContext.request.contextPath }/servlet/OrdersServlet?method=select&order_id=${order.id}">删除</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    	<div class="privilege"><a href="javascript:void(0)" onclick="addprivilege(this)">添加科室</a></div>
    	<div id="add_privilege">
    		<div id="p_content">
    			<form action="${pageContext.request.contextPath }/servlet/RoleServlet?method=add" method="post">

			    	<div class="p_input">科室分类:<select onchange="listcategory(this.value)">
						<c:forEach var="dept_c" items="${categories }">
							<option value="${dept_c.depet_category_id }">${dept_c.name }</option>
						</c:forEach>
					</select></div>
					<div class="p_input">科室名称：<input type="text" name="rname" /></div>

			    	<div class="p_submit"><input type="submit" value="添加"/></div>
		    	</form>
		    </div>
    	</div>
	</div>
</body>
</html>
