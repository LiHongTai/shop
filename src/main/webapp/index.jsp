<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<a href="${pageContext.request.contextPath}/category!save.action?category.id=1&category.type=男士休闲&category.hot=false">保存类别</a>
	
	<a href="${pageContext.request.contextPath}/category!save.action?id=10&type=男士休闲&hot=true">ModelDriven保存类别</a>
</body>
</html>
