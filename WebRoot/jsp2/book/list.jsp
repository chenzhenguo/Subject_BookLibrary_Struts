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
                            <i class="icon-user"></i>${sessionScope.currentUser.name } 
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="login_logOut.action">退出</a></li>
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
                        <li class="active" ><a  href="book_list.action">书籍信息管理</a></li>
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
 
 <div class="span9">


				<h1 class="page-title">书籍信息管理</h1>
				<div class="btn-toolbar">
					<button class="btn btn-primary">
						<i class="icon-plus"></i><a href="book_toAdd.action">添加</a>
					</button>
					<a href="#myModal" data-toggle="myModal" class="btn">导入</a>
					<button class="btn">导出</button>
					<div class="btn-group"></div>
				</div>
				<div class="well search-well">
				
					<form id="searchForm" class=form-inline action="book_list.action" method="post">
					<input class="input-mini" placeholder="书籍名" name="book.name" 	type="text"> 
<input class="input-mini" placeholder="作者" name="book.author"  type="text" > 
<input class="input-small" placeholder="类型" name="book.categoryName"  type="text" > 
<input class="input-small" placeholder="出版商" name="book.publish"    type="text">
<input type="submit" class="btn" value="查询" />
					</form>
					
					
				</div>
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>书名</th>
							  	<th>价格</th>
							  	<th>作者</th>
							  	<th>类型</th>
							  	<th>出版商</th>
							  	<th>状态</th>
							  	<th>出版日期</th>
							  	<th>操作</th>
								<th style="width: 26px;"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="bean" varStatus="Status">
								<tr>
							<td>${bean.name }</td>
  							<td>${bean.price }￥</td>
 						 	<td>${bean.author}</td>
  							<td>${bean.categoryName }</td>
  							<td>${bean.publish }</td>

  	<td><c:if test="${bean.bookNum==0}" >借阅中</c:if>
  	 <c:if test="${bean.bookNum==1}" >未借阅</c:if></td>
  	<td>${bean.pubDate }</td>
				<td><a href="book_toUpdate.action?book.id=${bean.id }"><i class="icon-pencil"></i></a>					
	<a href="#myModal" onclick="deleteBook('${bean.id}');" role="button" data-toggle="modal"><i class="icon-remove"></i></a></td></tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="pagination">
					<script type="text/javascript">
						function deleteBook(id) {
							$("#pid").val(id);
						}
						function pageFunction(url) {
							location.href = url + '&'
									+ $('#searchForm').serialize();
						}
					</script>
					<ul>
					
						<li><a
							href="javascript:pageFunction('book_list.action?page.currentPage=${page.currentPage-1 }')">上一页</a></li>
						<c:choose>
							<%-- 只要总页数小于10直接显示所有页数 --%>
							<c:when test="${page.totalPage<10 }">
								<c:forEach begin="1" end="${page.totalPage }" var="pc" step="1">
									<li><a
										href="javascript:pageFunction('book_list.action?page.currentPage=${pc }')">${pc }</a></li>
								</c:forEach>
							</c:when>
							<%-- 总页数大于10 --%>
							<c:otherwise>
								<%--当前页在头部  小于5--%>
								<c:if test="${page.currentPage<5}">
									<c:forEach begin="1" end="9" var="pc" step="1">
										<li><a
											href="javascript:pageFunction('book_list.action?page.currentPage=${pc }')">${pc }</a></li>
									</c:forEach>
								</c:if>
								<%-- 当前页在中间 --%>
								<c:if
									test="${page.currentPage+4<=page.totalPage and page.currentPage-4>0}">
									<c:forEach begin="${page.currentPage-4}"
										end="${page.currentPage+4 }" var="pc" step="1">
										<li><a
											href="javascript:pageFunction('book_list.action?page.currentPage=${pc }')">${pc }</a></li>
									</c:forEach>
								</c:if>
								<%-- 当前页在尾部 currentPage+4 大于 totalPage --%>
								<c:if test="${page.currentPage+4>page.totalPage}">
									<c:forEach begin="${page.totalPage-8 }"
										end="${page.totalPage }" var="pc" step="1">
										<li><a
											href="javascript:pageFunction('book_list.action?page.currentPage=${pc }')">${pc }</a></li>
									</c:forEach>
								</c:if>
							</c:otherwise>
						</c:choose>
						<li><a
							href="javascript:pageFunction('book_list.action?page.currentPage=${page.currentPage+1 }')">下一页</a></li>
					</ul>
				</div>
<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">删除确认框</h3>
    </div>
	    <div class="modal-body">
	    	是否确定删除?
	    <form id="uploadForm" action="reason" method="post">
			<input type="hidden" name="book.id" id="pid"/>
	   	</form>
	    </div>
	    <div class="modal-footer">
	   		  <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
	    	<input form="book_toUpdate.action" class="btn" type="submit" value="确定"/>
	    </div>
</div>
<footer>
	<hr>
	<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
	<p class="pull-right">
		A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free
			Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a>
	</p>
	<p>
		&copy; 2012 <a href="http://www.portnine.com">Portnine</a>
	</p>
</footer>

<!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="lib/bootstrap/js/bootstrap.js"></script>

</body>
</html>



 
		
