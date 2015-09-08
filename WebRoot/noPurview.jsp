<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  	<base href="<%=basePath%>"/>
  	<link rel="stylesheet" href="css/nopurview.css">
    <title>提示</title>
  </head>
  
  <body>
  	<div id="purview">
	    <div id="tip"><img alt="" src="images/p.jpg"> ${message }</div>
	    <a href="" onClick="javascript :history.back(-1);">返回</a>
    </div>
  </body>
</html>
