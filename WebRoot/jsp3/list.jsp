<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lsit.jsp' starting page</title>
    
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
  <table width="80%" align="center" >
  
   <tr colspan="5" align="left">
  <td><a href="jsp2/index.jsp">图书管理首页</a></td>
  </tr>
  <tr colspan="5" align="left">
  <td><a href="book_toAdd.action">添加</a></td>
  </tr>
  <tr>
  	<th>书名</th>
  	<th>价格</th>
  	<th>作者</th>
  	<th>类型</th>
  	<th>出版商</th>
  	<th>數量</th>
  	<th>出版日期</th>
  	<th>操作</th>
  </tr>
  <c:forEach items="${list }" var="bean">
    <tr>
  	<td>${bean.name }</td>
  	<td>${bean.price }</td>
  	<td>${bean.author }</td>
  	<td>${bean.categoryName }</td>
  	<td>${bean.publish }</td>
  	<td>${bean.bookNum}</td>
  	<td>${bean.pubDate }</td>
  	<td><a href="book_borrow.action?book.id=${bean.id }">借书</a></td>
  </tr>
  </c:forEach>
  </table>
  
  
 
  </body>
</html>
