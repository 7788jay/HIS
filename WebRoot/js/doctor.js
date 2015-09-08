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
/*修改用户角色*/
function updaterole_doc(){
	$.post("/HIS/servlet/DoctorServlet?method=UpdateDocRole",$("#dform").serialize(),
			function(data){
			data=eval("("+data+")");
			alert(data.message);
		}	
		);
}