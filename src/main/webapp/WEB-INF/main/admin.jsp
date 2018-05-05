<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../template/head.jsp"%>	
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'欢迎来到易购商城后台管理系统',split:true" style="height:100px;"></div>   
    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
    	<!-- 此处为菜单管理 -->
    	<div id="menu" class="easyui-accordion" data-options="fit:true">   
		    <div title="基本操作">   
		        <ul>
					<li><a href="#" title="send_category_show.action">类别管理</a></li>
					<li><a href="#" title="send_product_show.action">商品管理</a></li>
				</ul>
		    </div>   
		    <div title="其他操作" style="padding:10px;">   
		        <ul>
					<li>其他管理</li>
				</ul>
		    </div>   
		</div>  
    	
    </div>   
    <div data-options="region:'center',title:'后台管理页面'" style="padding:1px;background:#fff;">
    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
		    <div title="系统缺省页面" style="padding:10px;">   
		                              此处以后显示相应的系统信息(包含当前系统的类型 ,当前项目的域名，硬件相关配置，或者报表)
		    </div>   
		</div>  
    </div>   
    <!-- 此处为弹出窗体公共DIV -->
    <div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
</body>  
</html>