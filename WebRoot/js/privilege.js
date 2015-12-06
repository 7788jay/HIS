/*function listprivilrge(id){

	layer.open({
		type:2,
		title:["查看权限",'font-size:20px;font-weight:bold;'],
		closeBtn:2,
		area:['500px','300px'],
		content: 'servlet/RoleServlet?method=GetRoleById&roleid='+id,
	});
};

function updateInit(id){

	var index=layer.open({
		type:2,
		title:["修改角色",'font-size:20px;font-weight:bold;'],
		closeBtn:2,
		area:['550px','300px'],
		content: 'servlet/RoleServlet?method=GetRoleDetail&role_id='+id,
	});
};
function UpdateRoleDetail(){

	$.post("servlet/RoleServlet?method=UpdateRoleDetail",$("#p_form").serialize(),function(data) {
        data = eval("(" + data + ")");
        layer.msg(data.message, {
            icon: 1,
            time: 2000
        }, function () {
            parent.location.reload();//刷新父窗口
            //当你在iframe页面关闭自身时
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭

        });
    });
}*/
function one_add(){
    $.post("/HIS/servlet/PrivilegeServlet?method=add",$("#pform").serialize(),
        function(data){
            data=eval("("+data+")");
            alert(data.message);
            location.reload(true);
        }
    );
}

