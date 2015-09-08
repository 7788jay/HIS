function updateInit(id){
	
	var index=layer.open({
		type:2,
		title:["修改科室",'font-size:20px;font-weight:bold;'],
		closeBtn:2,
		area:['550px','300px'],
		content: 'servlet/DepartmentServlet?method=UpdateInit&dept_id='+id,
	});
};
function UpdateRoleDetail(){
	
	$.post("servlet/RoleServlet?method=UpdateRoleDetail",$("#p_form").serialize(),function(data){
		data = eval("("+data+")");
		layer.msg(data.message);
		//当你在iframe页面关闭自身时
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭 
	});
	parent.location.reload();//刷新父窗口
};
