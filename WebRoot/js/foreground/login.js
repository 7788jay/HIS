avalon.ready(function () {
	var vm = avalon.define({
		$id: "login",
		name: "",
		password: "",
		identity:{"fd":"医生","fp":"病人"},
		status: "fd",

		login: function(){
			if(vm.name == ""){
				layer.msg("请输入用户名！");
				return;
			}
			if(vm.password == ""){
				layer.msg("请输入密码！");
				return;
			}
			$.post("fore/login",{
				name:vm.name,
				password:vm.password,
				status:vm.status
			},function(data){
				if(data.message == "error"){
					layer.msg("用户名或密码错误，请重试！");
				}else{
					window.location.href = data.message;
				}
			});
		}
	});
	avalon.scan();
})