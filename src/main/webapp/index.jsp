<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<style type="text/css">
		#menu{
			width: 200px;
		}
		
		#menu ul{
			list-style: none;
			padding: 0px;
			margin: 0px;
		}
		
		#menu ul li{
			border-bottom: 1px solid #fff;
		}
		
		#menu ul li a{
			display: block;
			background-color: #9A32CD;
			color: #fff;
			padding: 5px;
			text-decoration: none;
		}
		
		#menu ul li a:hover {
			background: #9F79EE;
		}
	</style>
<body>
	<div id="menu">
		<ul>
			<li><a href="#">类别管理</a></li>
			<li><a href="#">商品管理</a></li>
		</ul>
	</div>
</body>
</html>
