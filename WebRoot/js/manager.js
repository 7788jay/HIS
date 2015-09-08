function change(obj) {
	var d = $(obj).find("#ul_xiala").css("display");
	$(obj).find("#ul_xiala").css("display",d=='block'?'none':'block');
}
//增加权限
function addprivilege(a){
	var d = $("#add_privilege").css("display");
	$("#add_privilege").css("display",d=='block'?'none':'block');
}
//修改权限
function dosubmit(){
	$.post("/HIS/servlet/RoleServlet?method=UpdateRole",$("#rform").serialize(),
		function(data){
		data=eval("("+data+")");
		alert(data.message);
	}	
	);
}