<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
     <base href="<%=basePath%>">
    <title>图书管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.8.1.min.js" type="text/javascript"></script>

    <!-- Demo page code -->
    
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>


  </head>

  <body> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <ul class="nav pull-right">
                    
                    <li id="fat-menu" class="dropdown">
                        <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i>${user.name }
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="user?action=logout">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                 <a class="brand" href="jsp/login.jsp"><span class="first">图书</span> <span class="second">管理系统</span></a>
            </div>
        </div>
    </div>
    

    <div class="container-fluid">
        
        <div class="row-fluid">
            <div class="span3">
                <div class="sidebar-nav">
                  <div class="nav-header" data-toggle="collapse" data-target="#dashboard-menu">书籍管理</div>
                    <ul id="dashboard-menu" class="nav nav-list collapse in">
                        <li ><a  href="book_list.action">书籍信息管理</a></li>
                        <li >  <a href="category_list.action">图书分类管理</a></li>
                    </ul>
                <div class="nav-header" data-toggle="collapse" data-target="#accounts-menu">用户管理</div>
                <ul id="dashboard-menu" class="nav nav-list collapse in">
         <li > <a href="user_list.action">用户信息管理</a></li>
                  
                        
                </ul>

                <div class="nav-header" data-toggle="collapse" data-target="#settings-menu">记录管理</div>
                <ul id="dashboard-menu" class="nav nav-list collapse in">
                 <li >  <a href="record_list.action">借书还书记录</a></li>
                      
                </ul>
            </div>
        </div>
 
        
    		<div align="center">
    		
    			<h1 class="page-title">欢迎<a>${user.name }</a>登陆图书管理系统</h1>
				</div>
    <script src="lib/bootstrap/js/bootstrap.js"></script>

  </body>
</html>


