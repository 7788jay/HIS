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

<title>角色管理</title>
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
	<h1 style="text-align: center;">角色管理</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<div>
		<table width="90%" class="table01" border="0" cellspacing="0" cellpadding="0" align="center" style="text-align:center">
    		<tr>
    			<td class="td_top">角色名称</td>
    			<td class="td_top">创建时间</td>
    			<td class="td_top">权限描述</td>
    			<td class="td_top">角色操作</td>
    			<td class="td_top">权限管理</td>
    		</tr>
    		<c:forEach var="r" items="${roles }">
	    		<tr>
	    			<td class="td_01">${r.rolename }</td>
	    			<td class="td_01">${r.createtime }</td>
	    			<td class="td_01">${r.description }</td>
	    			<td class="td_01"><a href="javascript:updateInit('${r.roleid}')">修改</a>

	    			</td>
	    			<td class="td_01"><a href="javascript:listprivilrge('${r.roleid}')">查看权限</a>
	    			<a href="${pageContext.request.contextPath }/servlet/RoleServlet?method=getUpdateRole&roleid=${r.roleid}">修改权限</a>
	    			</td>
	    		</tr>
    		</c:forEach>
    	</table>
    	<div class="privilege"><a href="javascript:void(0)" onclick="addprivilege(this)">添加角色</a></div>
    	<div id="add_privilege">
    		<div id="p_content">
    			<form action="" method="post" id="pform">
			    	<div class="p_input">角色名称：<input type="text" name="rname" /></div>
			    	<div class="p_text">角色描述：<textarea name="description" cols="50" rows="3" ></textarea></div>
			    	<div class="p_submit"><input type="button" value="添加" onclick="one_add()"/></div>
		    	</form>
		    </div>
    	</div>
	</div>
</body>
</html>
