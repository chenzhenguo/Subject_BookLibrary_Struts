<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="user_update.action" method="post">
  <input type="hidden" name="user.id" value="${user.id }">
  用户名	<input type="text"  name="user.name" value="${user.name }">
  	用户密码：<input type="text" name="user.password" value="${user.password}" >
用户权限：<select  name="user.roldId">
	<option  value="2">普通用户</option>
	<option  value="1">管理员</option>
  	<input type="submit" value="修改">
  
  </form>
  
  
  
  
  
  </body>
</html>
