<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="../template/head.jsp"%>
	<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({    
		    url:'product!list.action',
		    queryParams:{
		    	"type":""
		    },
		    //显示斑马线 奇偶行变色
		    striped:true,
		    //数据显示在同行，默认是true
		    nowrap:true,
		    idField:'id',
		    //自动适应列
		    fitColumns:true,
		    //同列属性，这些列将会被冻结在左侧
		    pagination:true,
		    pageSize:5,
		    pageList:[5,10,15,20],
		    toolbar: [{
				iconCls: 'icon-add',
				text:'添加商品',
				handler: function(){
					parent.$('#win').window({    
						title:'添加商品',
					    width:480,    
					    height:520,
					    content:'<iframe src="send_product_save.action" frameborder="0" width="100%" height="100%"/>'
					});  
				}
			},'-',{
				iconCls: 'icon-edit',
				text:'更新商品',
				handler: function(){
					//首先查看是否有被选中的对象，并且只能有一条，因为一次只能更新一个对象
					var selectIds = $('#dg').datagrid('getSelections');
					if(selectIds.length != 1){
						$.messager.show({
							title:'消息提示',
							msg:'至少选中一行,并且只能选择一行',
							timeout:5000,
							showType:'slide'
						});
					}else{
						parent.$('#win').window({    
							title:'更新商品',
						    width:450,    
						    height:280,
						    content:'<iframe src="send_product_update.action" frameborder="0" width="100%" height="100%"/>'
						});  
					}
				}
			},'-',{
				iconCls: 'icon-remove',
				text:'删除商品',
				handler: function(){
					//首先获取被选中的行
					var selectIds = $('#dg').datagrid('getSelections');
					if(selectIds.length == 0){
						$.messager.show({
							title:'消息提示',
							msg:'至少选中一行',
							timeout:5000,
							showType:'slide'
						});
					}else{
						var ids = "";
						for(var i = 0; i < selectIds.length ; i ++){
							ids = selectIds[i].id + "," + ids;
						}
						ids = ids.substring(0,ids.lastIndexOf(","));
						$.post('product!deleteByIds.action',{"ids":ids},function(result){
							if('true' == result){
								//	取消选中，因为删除后，虽然数据库中已无该数据，在datagrid中，也看不到被选中的行
								// 但是，datagrid仍然记录者选择的 对象行
								$('#dg').datagrid('uncheckAll');
								$('#dg').datagrid('reload');
							}else{
								$.messager.show({
									title:'消息提示',
									msg:'删除失败，请检查操作',
									timeout:5000,
									showType:'slide'
								});
							}
						},'text');
					}
					
				}
			},'-',{
				text:"<input id='search' name='name' />"
			}],
		    frozenColumns:[[
		    	{field:'xyz',checkbox:true},    
		    	{field:'id',title:'编号',width:100,align:'center',hidden:true}
		    ]],
		    columns:[[    
		        {field:'name',title:'商品名称',width:100,align:'center',
		        	formatter:function(value,row,index){
		        		return "<alt title='" + value + "'>" + value + "</alt>";
		        	}	
		        },    
		        {field:'remark',title:'简单描述',width:100,align:'center'},
		        {field:'productDate',title:'生成日期',width:100,align:'center',
		        	formatter:function(value,row,index){
		        		var unixTimestamp = new Date(value);
		        		return unixTimestamp.toLocaleString();
		        	}
		        },
		        {field:'category.type',title:'所属类别',width:100,align:'center',
		        	formatter:function(value,row,index){
		        		if(row.category != null && row.category.type != null){
		        			return row.category.type;
		        		}
		        	}	
		        }    
		    ]]    
		});  
		
		
	$('#search').searchbox({
			searcher : function(value, name) {
				$('#dg').datagrid('load',{
					name: value,
				});
			},
			prompt : '请输入商品名称'
		});
	});
	</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>