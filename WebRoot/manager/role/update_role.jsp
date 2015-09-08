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

<title>角色赋权管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/role.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>


</head>

<body>
	<h1 style="text-align: center;">角色赋权管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<div id="role">
		<div id="role_back"><a href="${pageContext.request.contextPath }/servlet/RoleServlet?method=get">返回</a></div>
		<div id="role_name">当前角色：<span>${role.rolename }</span></div>
		<div id="role_name">创建时间：<span>${role.createtime }</span></div>
		<div id="role_name">角色描述：<span>${role.description }</span></div>
	</div>
		<form action="" id="rform"  method="post">
			<div>
				<c:forEach var="t" items="${typesList }">
				<!-- 取出全部类型 -->
					<div id="tp">	
						<div id="tp_name">${t.tp_name }</div>
						<c:forEach var="p" items="${privileges }">
						<!-- 取出该类型全部类型 -->
							<c:if test="${p.type_name==t.tp_name }">
								<c:set var="flag" value="t"></c:set>
								<c:forEach var="rp" items="${role_privileges }">
									<c:if test="${rp.pid==p.pid }">
									<c:set var="flag" value="tu"></c:set>
									</c:if>
								</c:forEach>
								<div>
									<input type="checkbox" <c:if test="${flag=='tu' }">checked='checked'</c:if> value="${p.pid }" name="privilege">${p.pname }
								</div>
							</c:if>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
			<div style="clear: both"></div>
			<input type="hidden" name="roleid" value="${role.roleid}">
			<input id="p_submit" onclick="dosubmit()" value="修改">
		</form>
	</body>
</html>
