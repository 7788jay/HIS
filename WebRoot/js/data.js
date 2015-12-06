
function backup(){
	$.post("/HIS/servlet/DataServlet?method=backup",
			function(data){
			data=eval("("+data+")");
			layer.alert(data.message,function(index){
                //do something
                location.reload(true);

            });

		}	
		);
}
function restore(name){
    if(confirm("确定还原到该时间点？")){

        $.post("/HIS/servlet/DataServlet?method=restore&name="+name,
            function(data){
                data=eval("("+data+")");
                layer.alert(data.message,function(index){
                    //do something
                    location.reload(true);

                });

            }
        );
    }

}function del(no){
    if(confirm("确定删除？")){

        $.post("/HIS/servlet/DataServlet?method=del&no="+no,
            function(data){
                data=eval("("+data+")");
                layer.alert(data.message,function(index){
                    //do something
                    location.reload(true);

                });

            }
        );
    }

}
