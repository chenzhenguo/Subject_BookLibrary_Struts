<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
 <base href="<%=basePath%>">
<title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="jsp2/lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<link href="jsp2/css/foundation.min.css" rel="stylesheet" type="text/css">
		<link href="jsp2/css/foundation-datepicker.css" rel="stylesheet" type="text/css">
		<style>
		.container { margin:0 auto;  max-width:400px;padding:20px;}
		</style>

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
    
    
    
    


    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7"> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8"> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9"> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="jsp2/loginSuccess.jsp"><span class="first">图书</span> <span class="second">管理系统</span></a>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
    <div class="span4 offset4 dialog">
        <div class="block">
            <div class="block-heading">修改书籍</div>
            <div class="block-body">
 	 <form action="book_update.action" method="post">
 <input type="hidden" name="book.id" value="${book.id}">
		<label>书名</label>
	<input type="text" name="book.name" value="${book.name}">
	<label>价格</label>
<input type="text" name="book.price" value="${book.price }">
  	<label>出版社</label>
  <input type="text" name="book.publish"  value="${book.publish }">
 	<label>作者</label>
  <input type="text" name="book.author" value="${book.author}">
  	<label>状态</label>

  <input type="radio" value="0" name="sex" <c:if test="${book.bookNum==0 }">checked</c:if> class="input-xlarge">已被借阅
  <input type="radio" value="1" name="sex" <c:if test="${book.bookNum==1 }">checked</c:if> class="input-xlarge">未借阅


 <br> <label>分类</label>

  <select name="book.categoryId">
  <c:forEach items="${ categoryList}" var="bean">
  <option value="${bean.id }"  <c:if test="${bean.id==bean.id }">checked</c:if> >${bean.name }</option>
  </c:forEach>
  </select>
  <label>出版日期</label>
	<input   class="container"   type="text" name="book.pubDate" value="${book.pubDate }" id="demo-1">
		<script src="jsp2/js/jquery-1.11.3.min.js"></script>
		<script src="jsp2/js/foundation-datepicker.js"></script>
		<script src="jsp2/js/locales/foundation-datepicker.zh-CN.js"></script>	
		<script>
		
		$('#demo-1').fdatepicker({
		format: 'yyyy-mm-dd ',
		pickTime: false
		});
		$('#demo-2').fdatepicker({
			format: 'yyyy-mm-dd ',
			pickTime: true
		});
		$('#demo-3').fdatepicker();

		var nowTemp = new Date();
		var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate());
		var checkin = $('#dpd1').fdatepicker({
			onRender: function (date) {
				return date.valueOf() < now.valueOf() ? 'disabled' : '';
			}
		}).on('changeDate', function (ev) {
			if (ev.date.valueOf() > checkout.date.valueOf()) {
				var newDate = new Date(ev.date)
				newDate.setDate(newDate.getDate() + 1);
				checkout.update(newDate);
			}
			checkin.hide();
			$('#dpd2')[0].focus();
		}).data('datepicker');
		var checkout = $('#dpd2').fdatepicker({
			onRender: function (date) {
				return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
			}
		}).on('changeDate', function (ev) {
			checkout.hide();
		}).data('datepicker');
		</script>

		<input type="submit" value="修改" class="btn  btn-xlarge">
			</form>
            </div>
        </div>
        <p><a href="privacy-policy.html">Privacy Policy</a></p>
    </div>
</div>
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="lib/bootstrap/js/bootstrap.js"></script>
  </body>
</html>


