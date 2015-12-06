$(function(){
$(".subNav").click(function(){
			$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
			$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
			
			// 修改数字控制速度， slideUp(500)控制卷起速度
			$(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
	})	
});
/*获取科室*/
function listcategory(value){
	var sele=document.getElementById('next');
	sele.options.length=0; 
	$.post("/HIS/servlet/DepartmentServlet?method=getbyid",{id:value},
			function(data){
				data = eval("("+data+")");
				 for(var i=0;i<data.dept.length;i++){
					 sele.options[i]=new Option(data.dept[i].name,data.dept[i].dept_id);
				 }
				
	   }
	);
}
/*根据科室获取医生*/
function listdoctor(value){

	$.post("/HIS/servlet/DoctorServlet?method=getDoctorbyDeptid",{dept_id:value},
			function(data){
				//data = eval("("+data+")");
				$("#dlist").html('');

                $("#dlist").html(data);
	   }
	);
}
/*修改用户角色*/
function updaterole_doc(){
    $.post("/HIS/servlet/DoctorServlet?method=UpdateDocRole",$("#dform").serialize(),
        function(data){
            data=eval("("+data+")");
            alert(data.message);
        }
    );
}
function one_add(){
    $.post("/HIS/servlet/DoctorServlet?method=one_add",$("#dform").serialize(),
        function(data){
            data=eval("("+data+")");
            alert(data.message);
        }
    );
}
function show(id){

    var index=layer.open({
        type:2,
        title:["修改医生",'font-size:20px;font-weight:bold;'],
        closeBtn:2,
        area:['550px','300px'],
        content: '/HIS/servlet/DoctorServlet?method=dupdateInit&id='+id,
    });
}