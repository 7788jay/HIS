<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>医生工作站-注册</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.css"/>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="plugin/layer.js"></script>
    <script type="text/javascript" src="plugin/avalon/avalon.js"></script>
    <script type="text/javascript" src="js/foreground/login.js"></script>
</head>
<body class="container" ms-controller="register">
<div class="col-lg-4 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2" id="login">

    <form class="form-horizontal" role="form">
        <h2>HIS 用户注册</h2>
        <div class="form-group">
            <label for="inputName" class="col-sm-3 col-sm-offset-1 control-label">用户名</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="inputName" placeholder="用户名" ms-duplex="name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword1" class="col-sm-3 col-sm-offset-1 control-label">密码</label>
            <div class="col-sm-7">
                <input type="password" class="form-control" id="inputPassword1" placeholder="密码" ms-duplex="password">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword2" class="col-sm-3 col-sm-offset-1 control-label">确认密码</label>
            <div class="col-sm-7">
                <input type="password" class="form-control" id="inputPassword2" placeholder="确认密码" ms-duplex="password2">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-3 col-sm-offset-1 control-label">年龄</label>
            <div class="col-sm-7">
                <input type="text" class="form-control" id="age" placeholder="年龄" ms-duplex="age">
            </div>
        </div>
        <div class="form-group">
            <label for="sex" class="col-sm-3 col-sm-offset-1 control-label">性别</label>
            <div class="col-sm-7">
                <select class="form-control" id="sex" ms-duplex="sex">
                    <option>男</option>
                    <option>女</option>
                </select>
            </div>
        </div>
        <input type="button" class="btn btn-lg btn-primary btn-block" ms-click="register" value="注册"/>
    </form>
</div>
</body>
</html>
<script>
    avalon.ready(function () {
        var vm = avalon.define({
            $id: "register",
            name: "",     //用户名
            password: "",   //密码
            password2: "",  //二次密码
            age: "",     //年龄
            sex: "男",   //性别

            //注册
            register: function(){
                if(vm.name == ""){
                    layer.msg("请输入用户名！");
                    return;
                }
                if(vm.password == ""){
                    layer.msg("请输入密码！");
                    return;
                }
                if(vm.password2 != vm.password){
                    layer.msg("确认密码不一致！");
                    return;
                }
                if(vm.age == ""){
                    layer.msg("请输入年龄！");
                    return;
                }
                $.post("fore/register",{
                    name:vm.name,
                    password:vm.password,
                    age:vm.age,
                    sex: vm.sex
                },function(data){
                    if(data.message == "注册失败！"){
                        layer.msg("注册失败，请重试！");
                    }else{
                        layer.alert(data.message,function(){
                            window.location.href = "foreground/login.jsp";
                        })
                    }
                });
            }
        });
        avalon.scan();
    })
</script>
