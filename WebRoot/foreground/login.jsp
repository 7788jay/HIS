<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--
  Created by IntelliJ IDEA.
  User: lwt
  Date: 2015/12/6
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>"/>
    <title>医生工作站-登录</title>
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="plugin/avalon/avalon.js"></script>
    <script type="text/javascript" src="js/foreground/login.js"></script>
    <script style="text/javascript"></script>
</head>
<body>
<form method="post">
    <div id="login">
        <div id="login_title">登录</div>
        <div class="login_content">
            <div class="login_l">用户名:<input type="text" id="username" name="username"></div>
            <div class="login_l">密&nbsp;码:<input type="password" id="password" name="password"></div>
            <div class="login_l">身&nbsp;份:<select name="status" id="status">
                <option value="fd">医生</option>
                <option value="fp">病人</option>
            </select></div>
            <div class="login_l"><input type="button" onclick="check()" value="登录"/></div>
        </div>
    </div>
</form>
</body>
</html>
