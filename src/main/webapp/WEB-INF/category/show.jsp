<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="../template/head.jsp"%>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({    
			    url:'category!list.action',
			    queryParams:{
			    	"type":"休闲"
			    },
			    //显示斑马线 奇偶行变色
			    striped:true,
			    //数据显示在同行，默认是true
			    nowrap:true,
			    //自动适应列
			    fitColumns:true,
			    //同列属性，这些列将会被冻结在左侧
			    pagination:true,
			    frozenColumns:[[
			    	{field:'xyz',checkbox:true},    
			    	{field:'id',title:'编号',width:100}
			    ]],
			    columns:[[    
			        {field:'type',title:'类别名称',width:100},    
			        {field:'hot',title:'热点',width:100},
			        {field:'account.login',title:'所属管理源',width:100}    
			    ]]    
			});  

		});	
	</script>

</head>
<body>
	<table id="dg"></table>  
</body>
</html>