<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="manager_left">
		<div class="subNavBox">
			<div class="subNav currentDd currentDt">查看医生</div>
			<ul class="navContent" style="display:block" >
					<li><a href="${pageContext.request.contextPath}/servlet/DoctorServlet?method=getAllDoc">查看全部</a></li>
					<li><a href="#">按科室查询</a></li>
			</ul>
			<div class="subNav">添加医生</div>
			<ul class="navContent">
					<li><a href="${pageContext.request.contextPath}/servlet/DoctorServlet?method=getDep_Pro">单独添加</a></li>
					<li><a href="#">批量添加</a></li>
			</ul>
			<div class="subNav">医生授权</div>
			<ul class="navContent">
					<li><a href="${pageContext.request.contextPath}/servlet/DoctorServlet?method=getAllDocForUpdate">医生授权</a></li>
			</ul>
			<div class="subNav">招商加盟</div>
			<ul class="navContent">
					<li><a href="#">添加新闻</a></li>
					<li><a href="#">添加新闻</a></li>
					<li><a href="#">新闻管理</a></li>
					<li><a href="#">添加新闻</a></li>
					<li><a href="#">新闻管理</a></li>
			</ul>
		</div>
	</div>
