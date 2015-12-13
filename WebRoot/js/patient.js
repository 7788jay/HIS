$(function(){
$(".subNav").click(function(){
			$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
			$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
			
			// 修改数字控制速度， slideUp(500)控制卷起速度
			$(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
	})	
});

function one_add(){
    $.post("/HIS/servlet/PatientServlet/one_add",$("#pform").serialize(),
        function(data){
			console.log(data);
            layer.alert(data.message);
        }
    );
}