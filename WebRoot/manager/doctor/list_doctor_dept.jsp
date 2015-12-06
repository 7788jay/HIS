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

<title>列出医生</title>
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
	<h1>医生信息列表</h1>
	<%@include file="/public/head.jsp" %>
	<div style="clear: both"></div>
	<%@include file="/public/doctor/list_left.jsp" %>
	<div id="manager_right">
        <div style="height: 30px;margin-top: 15px;" align="left">
            科室分类:<select onchange="listcategory(this.value)">
            <c:forEach var="dept_c" items="${categories }">
                <option value="${dept_c.depet_category_id }">${dept_c.name }</option>
            </c:forEach>
            </select>
                科室:<select id="next" name="dept" onchange="listdoctor(this.value)">
                <c:forEach var="dept" items="${departments }">
                    <option value="${dept.dept_id }">${dept.name }</option>
                </c:forEach>
            </select>
        </div>
		<table width="100%" class="table01" border="0" cellspacing="0" cellpadding="0" align="center" style="text-align:center">
    		<tr>
    			<td class="td_top">医生姓名</td>
    			<td class="td_top">职称</td>
    			<td class="td_top">所属科室</td>
    			<td class="td_top">操作</td>
    		</tr>
            <tbody id="dlist">
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
	    			<td class="td_01"><a href="${pageContext.request.contextPath }/servlet/OrdersServlet?method=select&order_id=${order.id}">修改</a>

	    			</td>
	    		</tr>
    		</c:forEach>
            </tbody>
    	</table>
	</div>
</body>
</html>
