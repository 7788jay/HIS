<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>登录</title>
  	<base href="<%=basePath%>"/>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="plugin/layer.js"></script>
    <script type="text/javascript" src="js/login.js"></script> 
  </head>
  
  <body>
  <form method="post">
    <div id="login">
    	<div id="login_title">登录</div>
    	<div class="login_content">
	    	<div class="login_l">用户名:<input type="text" id="username" name="username"></div>
	    	<div class="login_l">密&nbsp;码:<input type="password" id="password" name="password"></div>
	    	<div class="login_l">身&nbsp;份:<select name="status" id="status">
	    		<option value="m">管理员</option>
	    		<option value="d">医生</option>
	    	</select></div>
	    	<div class="login_l"><input type="button" onclick="check()" value="登录"/></div>
    	</div>
    </div>
   </form>
  </body>
</html>
