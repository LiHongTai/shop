<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="../template/head.jsp"%>
	
	<script type="text/javascript">
		$(function(){
			$('input[name=name]').validatebox({
				required: true,
				missingMessage:"请输入商品名称"
			});
			
			$('input[name=price]').numberbox({
				required: true,
				min:0,    
			    precision:2,
			    prefix:'$',
				missingMessage:"请输入商品价格"
			});
			
			$.extend($.fn.validatebox.defaults.rules, {    
			    format: {    
			        validator: function(value,param){    
			        	var ext = value.substring(value.lastIndexOf(".")+1);
			        	if(param[0].indexOf(ext) != -1){
			        		return true;
			        	}
			            return false;    
			        },    
			        message: '文件格式必须为{0}'   
			    }    
			});  
			
			$('input[name=upload]').validatebox({
				required: true,
				missingMessage:"请上传商品图片",
				validType:"format['gif,jpg,jpeg,png']"
			});
			
			$('textarea[name=remark]').validatebox({
				required: true,
				missingMessage:"请输入简单介绍"
			});
			
			$('#cc_product').combobox({    
			    url:'category!findAll.action',    
			    valueField:'id',    
			    textField:'type',
			    panelHeight:'auto',
			    panelWidth:120,
			    width:120,
			    editable:false,
			    required: true,
				missingMessage:"请选择所属类别"
			});  
			
			//在提交表单之前，禁用校验
			$('#ff_product').form('disableValidation');
			
			$('#submit').click(function(){
				//在提交表单的时候，启用校验
				$('#ff_product').form('enableValidation');
				if($('#ff_product').form('validate')){
					$('#ff_product').form('submit', {
						url: 'product!save.action',
						success: function(){
							//关闭当前窗体
							parent.$("#win").window("close");
							//因为浏览器兼容问题，故先获取DOM对象，然后在转换成Jquery对象
							var $dg = parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg");
							$dg.datagrid("reload");
						}
					});
				}
			});
			
			$('#reset').click(function(){
				//在提交表单的时候，启用校验
				$('#ff_product').form('disableValidation');
				$('#ff_product').form('reset');
			});
		});
	</script>
	
</head>

<body>
	<form title="添加商品" id="ff_product" method="post" enctype="multipart/form-data">
		<div>
			<label>商品名称:</label> <input type="text" name="name" />
		</div>
		<div>
			<label>商品价格:</label> <input type="text" name="price" />
		</div>
		<div>
			<label>图片上传:</label> <input type="file" name="fileImage.upload" />
		</div>
		<div>
			<label>所属类别：</label> 
			<input id="cc_product" type="text" name="category.id" >
		</div>
		<div>
			<label>加入推荐:</label> 
			    推荐:<input type="radio" name="commend" checked="checked" value="true" /> 
			不推荐:<input type="radio" name="commend" value="false" />
		</div>
		<div>
			<label>是否有效:</label> 
			上架:<input type="radio" name="open" checked="checked" value="true" /> 
			下架:<input type="radio" name="open" value="false" />
		</div>
		<div>
			<label>简单描述:</label>
			<textarea name="remark" cols="40" rows="4"></textarea>
		</div>
		<div>
			<label>详细描述:</label>
			<textarea name="remarkDetail" cols="40" rows="8"></textarea>
		</div>
		<div style="text-align: center;">
			<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
			<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
		</div>
	</form>
</body>
</html>
