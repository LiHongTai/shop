$(function(){
	$("a[title]").click(function(){
		var tabTitle = $(this).text();
		var href = $(this).attr("title");
		//1.判断Tab选项卡，是否已经存在
		//2.如果没有则创建一个tab页，否则切换到相应的tab页
		if($("#tt").tabs('exists',tabTitle)){
			//切换到tab页
			$("#tt").tabs('select',tabTitle);
		}else{
			//创建新的tab页
			$('#tt').tabs('add',{
				title: tabTitle,
				content:'<iframe src="' + href + '" title="'+ tabTitle + '" frameborder="0" width="100%" height="100%"/>',
				closable:true
			});
		}
	});
});