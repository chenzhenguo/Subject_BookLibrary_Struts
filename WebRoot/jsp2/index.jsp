<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"  src="jquery-1.11.3.js"></script>



  </head>
  
  <body>
  <h1> 欢迎<a>${user.name }</a>登陆图书管理系统</h1>
  
  <a  href="book_list.action">书籍管理</a>
  <a href="user_list.action">用户管理</a>
  <a href="record_list.action">借书还书记录</a>
  <a href="category_list.action">图书分类管理</a>


  </body>
</html>
