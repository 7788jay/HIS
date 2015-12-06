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

<title>医生信息管理</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" href="css/head.css">
<link href="css/lrtk.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/manager.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/doctor.js"></script>
    <style type="text/css" >
        .addline{
            width: 100%;
            height: 30px;
            margin-left: 20px;
            line-height: 30px;
            margin-top: 5px;
            text-align: left;
        }

    </style>
<script type="text/javascript">
//Excel文件导入到数据库中  
function importEmp(){  
    //检验导入的文件是否为Excel文件  
    var excelPath = document.getElementById("excelPath").value;  
    if(excelPath == null || excelPath == ''){  
        alert("请选择要上传的Excel文件");  
        return;  
    }else{  
        var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase();   
        if(fileExtend == '.xls'){  
        }else{  
            alert("文件格式需为'.xls'格式");  
            return;  
        }  
    }  
    //提交表单  
    document.getElementById("empForm").action="<%=request.getContextPath()%>/servlet/DoctorServlet?method=importExcel";
    document.getElementById("empForm").submit();
}
</script>

</head>

<body style="text-align: center;">
	<h1>医院信息管理</h1>
	<%@include file="/public/head.jsp"%>
	<div style="clear: both"></div>
	<%@include file="/public/doctor/add_left.jsp"%>
	<div id="manager_right">
		<form action="" id="empForm" method="post" enctype="multipart/form-data">
			<div style="font-size:14px;margin-top: 40px;">
                <div class="addline">1.请先下载模板，<a href="<%=request.getContextPath()%>/servlet/DoctorServlet?method=downExcel">---></a></div>
                <div class="addline">2.选择导入文件(xls结尾) <input type="file" id="excelPath" name="excelPath" /></div>
                <div class="addline"> <input type="button" value="导入Excel" onclick="importEmp()" /></div>
			</div>
		</form>
	</div>
</body>
</html>
