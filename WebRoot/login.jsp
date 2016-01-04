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
      <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.css"/>
    <script type="text/javascript" src="js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="plugin/layer.js"></script>
    <script type="text/javascript" src="js/login.js"></script> 
  </head>
  <body class="container">
  <div class="col-lg-4 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" id="login">

      <form class="form-horizontal" role="form">
          <h2>HIS 登录</h2>
          <div class="form-group">
              <label for="username" class="col-sm-2 col-sm-offset-1 control-label">用户名</label>
              <div class="col-sm-8">
                  <input type="text" class="form-control" id="username" placeholder="用户名" ms-duplex="name"/>
              </div>
          </div>
          <div class="form-group">
              <label for="password" class="col-sm-2 col-sm-offset-1 control-label">密码</label>
              <div class="col-sm-8">
                  <input type="password" id="password" class="form-control" placeholder="密码" ms-duplex="password">
              </div>
          </div>
          <div class="form-group">
              <label for="status" class="col-sm-2 col-sm-offset-1 control-label">身份</label>
              <div class="col-sm-8">
                  <select class="form-control" name="status" id="status">
                      <option value="m">管理员</option>
                      <option value="d">医生</option>
                  </select>
              </div>
          </div>
          <input type="button" class="btn btn-lg btn-primary btn-block" onclick="check()" value="登录"/>
      </form>
  </div>
  </body>
</html>
