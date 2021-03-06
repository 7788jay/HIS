<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>"/>
    <title>医生工作站-登录</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.css"/>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="plugin/layer.js"></script>
    <script type="text/javascript" src="plugin/avalon/avalon.js"></script>
    <script type="text/javascript" src="js/foreground/login.js"></script>
</head>
<body class="container" ms-controller="login">
<div class="col-lg-4 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" id="login">

    <div class="form-horizontal" role="form">
        <h2>HIS 登录</h2>
        <div class="form-group">
            <label for="inputName" class="col-sm-2 col-sm-offset-1 control-label">用户名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="inputName" placeholder="用户名" ms-duplex="name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 col-sm-offset-1 control-label">密码</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="inputPassword3" placeholder="密码" ms-duplex="password">
            </div>
        </div>
        <div class="form-group">
            <label for="status" class="col-sm-2 col-sm-offset-1 control-label">身份</label>
            <div class="col-sm-8">
                <select class="form-control" name="status" id="status"  ms-duplex="status">
                    <option ms-repeat="identity" ms-attr-value="{{$key}}">{{$val}}</option>
                </select>
            </div>
        </div>
        <input type="button" class="btn btn-lg btn-primary btn-block" ms-click="login" value="登录"/>
        <a class="btn btn-lg btn-primary btn-block" href="foreground/register.jsp">注册</a>
            <div class="form-group" style="margin-top: 20px">
                <div class="col-sm-4 col-sm-offset-9">
                    <a class="btn btn-primary" href="login.jsp">后台登录</a>
                 </div>
            </div>
    </form>
</div>
</body>
</html>
