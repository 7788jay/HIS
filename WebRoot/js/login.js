function check(){
	
	var username = $("#username").val();
	var password = $("#password").val();
	var status = $("#status").val();
	if(username == ""){
		layer.msg("请输入用户名！");
		return;
	}
	if(password == ""){
		layer.msg("请输入密码！");
		return;
	}
	$.post("servlet/LoginServlet",{
		username:username,
		password:password,
		status:status
		},function(data,status){
			data = eval("("+data+")");
			if(data.message == "error"){
				layer.msg("用户名或密码错误，请重试！");
			}else{
				window.location.href = "servlet/"+data.message;
			}
	});
}