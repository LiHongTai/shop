<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="../template/head.jsp" %>
	<script type="text/javascript">
		$(function(){
			//因为浏览器兼容问题，故先获取DOM对象，然后在转换成Jquery对象
			var $dg = parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
			var row = $dg.datagrid('getSelections');
			
			$('#cc').combobox({    
			    url:'account!findAll.action',    
			    valueField:'id',    
			    textField:'login',
			    panelHeight:'auto',
			    editable:false
			});  
			
			var accountId = "";
			if(row[0].account!=null && row[0].account.id!=null){
				accountId = row[0].account.id;
			}
			
			$('#ff').form('load',{
				id:row[0].id,
				type:row[0].type,
				hot:row[0].hot,
				'account.id':accountId
			});
			
			$('input[name=type]').validatebox({
				required: true,
				missingMessage:"请输入类别名称"
			});
			
			//在提交表单之前，禁用校验
			$('#ff').form('disableValidation');
			
			$('#btn').click(function(){
				//在提交表单的时候，启用校验
				$('#ff').form('enableValidation');
				if($('#ff').form('validate')){
					$('#ff').form('submit', {
						url: 'category!update.action',
						success: function(){
							//关闭当前窗体
							parent.$("#win").window("close");
							$dg.datagrid('uncheckAll');
							$dg.datagrid("reload");
						}
					});

				}
			});
		});
	</script>
</head>
<body>
	<form id="ff" method="post">   
	    <div>   
	        <label for="type">类别名称:</label>   
	        <input type="text" name="type"/>   
	    </div>   
	    <div>   
	        <label for="hot">类别性质:</label>   
	       	 <input type="radio" name="hot" value="true">热点
	       	 <input type="radio" name="hot" value="false" checked="checked">非热点
	    </div>
	    <div>   
	        <label for="hot">所属管理员:</label>   
	       	 <input id="cc" type="text" name="account.id" >
	    </div>
	    <div style="text-align: center;">
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>     
	    	<input type="hidden" name="id"/>
		</div>
	</form>  
</body>
</html>