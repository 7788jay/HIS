function updateInit(id){
	
	var index=layer.open({
		type:2,
		title:["修改科室",'font-size:20px;font-weight:bold;'],
		closeBtn:2,
		area:['550px','300px'],
		content: 'servlet/DepartmentServlet?method=UpdateInit&dept_id='+id,
	});
};
function UpdateDept(){
	
	$.post("servlet/DepartmentServlet?method=UpdateDept",$("#p_form").serialize(),function(data){

		data = eval("("+data+")");
		parent.layer.msg(data.message,{
			icon: 1,
			time: 2000
		},function(){
			parent.location.reload();//刷新父窗口
			//当你在iframe页面关闭自身时
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭

		});

	});

};
function del(dept_id){
    if(confirm("确定删除该部门？")){
        $.post("servlet/DepartmentServlet?method=del",{dept_id:dept_id},function(data) {
            data = eval("(" + data + ")");
            layer.msg(data.message, {
                icon: 2,
                time: 2000
            });
        });
    }

}
function one_add(){
    $.post("/HIS/servlet/DepartmentServlet?method=add",$("#dform").serialize(),
        function(data){
            data=eval("("+data+")");
            alert(data.message);
            location.reload(true);
        }
    );
}
