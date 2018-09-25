<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
<style type="text/css">
	#aside{
		background-color:  #dbe8d4;
		background-image: url("${pageContext.request.contextPath}/images/icon/bj3.jpg");
		background-repeat: no-repeat;
		
	}
	body{
		background-image: url("${pageContext.request.contextPath}/images/icon/bj4.jpg");
		background-repeat: no-repeat;
		background-size: 1350px;
	
	}
#message{
	width: 236px;
	height: 30px;
	background-color: #f8f8f8;
	text-align: 20px;
	color: #19a97b;
	padding-top: 14px;
	padding-left: 10px;
}
#add{
	width: 300px;
	height: 40px;
	background-color: #f8f8f8;
	margin-top: 40px;
}
#list{
	width: 300px;
	height:40px;
	background-color: #f8f8f8;
	margin-top: 40px;
}
#p{
	width: 220px;
	height:40px;
	background-color: #f8f8f8;
	margin-top: 300px;
}
input{
	margin-left: 40px;
	margin-top: px;
	border-color: #bbbabf;
	
}
header{
background:#a3a2a8;overflow:hidden;
	color: black;
}
</style>
<script>
	(function($) {
		$(window).load(
				function() {

					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
									//scroll-to appended content 
									$(".content").mCustomScrollbar("scrollTo",
											"h2:last");
								});
							});

					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

				});
	})(jQuery);
</script>
</head>
<body>
	<!--header-->
	<header>
		<h1>
			<img src="${pageContext.request.contextPath}/images/admin_logo.png" />
		</h1>
		<ul class="rt_nav">
			<li><a href="index.jsp" target="_blank" class="website_icon">站点首页</a></li>

			<li><a href="#" class="set_icon">账号设置</a></li>
			<li><a href="${pageContext.request.contextPath}/logout.do" class="quit_icon">安全退出</a></li>
		</ul>
	</header>

	<!--aside nav-->
	<aside class="lt_aside_nav content mCustomScrollbar" id="aside">
		<h2>
			<a href="index.php">起始页</a>
		</h2>
		<ul>
			<li>
				<dl>
					<div id="message">商品信息</div>
					<!--当前链接则添加class:active-->
					<dd>
						<div id="list"><a href="${pageContext.request.contextPath }/product/list.do" class="active">商品列表</a></div>
					</dd>
					<dd>
						<div id="add"><a href="${pageContext.request.contextPath }/product/add.do" class="active">添加商品</a></div>
					</dd>
				</dl>
			</li>
			<li>
			 <p id="p" class="btm_infor">© 望唐集团 版权所有</p>
			</li>
		</ul>
	</aside>

	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<!--点击加载-->
			<script>
				$(document).ready(function() {
					$("#loading").click(function() {
						$(".loading_area").fadeIn();
						$(".loading_area").fadeOut(1500);
					});
				});
			</script>
			<section class="loading_area">
				<div class="loading_cont">
					<div class="loading_icon">
						<i></i><i></i><i></i><i></i><i></i>
					</div>
					<div class="loading_txt">
						<mark>数据正在加载，请稍后！</mark>
					</div>
				</div>
			</section>
			<!--结束加载-->
			<section>
				<form action="${pageContext.request.contextPath}/product/list.do" method="post">
					<input type="text" class="textbox" placeholder="商品名" name="pName" />
					<input type="text" class="textbox textbox_225" placeholder="最小数"
						name="minprice" /> 
					<input type="text" class="textbox textbox_225"
						placeholder="最大数" name="maxprice" /> 
					<input class="link_btn"
						type="submit" value="查询" /> 
							
					<a class="link_btn" id="loading">刷新</a>
				
				</form>
				<hr width="2000px" color="#bbbabf">
			</section>
			
			<section>
				<div class="page_title">
					<h2 class="fl">产品详情</h2>
				</div>
				<table class="table">
					<tr>
						<th>商品名</th>
						<th>价格</th>
						<th>图片</th>
						<th>描述</th>
						<th>类别</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pb. products}" var="product">
						<tr>
							<td style="width: 265px;">
								<div class="cut_title ellipsis">${ product.pName}</div>
							</td>
							<td>${ product.pPrice}</td>
							<td><c:if test="${product.pImage!=null }">
								<!-- <img src="/image/2018091805542739309563.jpg" width="40px"> -->
								<a href="/image/${product.pImage }"><span style="color:black;">查看图片</span></a>
							</c:if></td>
							<td>${ product.pDesc}</td>
							<td>${ product.category.cName}</td>
							<td>${ product.pNumber}</td>
							<td><a href="${pageContext.request.contextPath}/product/toUpdate.do?pId=${product.pId}" class="inner_btn"><span style="color:black;">修改</span></a> 
							<a href="${pageContext.request.contextPath}/product/delete.do?pId=${product.pId}" class="inner_btn"><span style="color:black;">删除</span></a></td>
						</tr>
					</c:forEach>
				</table>
				
			<aside class="paging">
				
				<a href="${pageContext.request.contextPath  }/product/list.do?currentPage=${pb.currentPage==1?1:pb.currentPage-1}" style="background-color: #bbbabf;border:#bbbabf">&lt;&lt;上一页</a>
						

			<span >第${pb.currentPage}页/共${pb.totalPage}页</span>

				<a href="${pageContext.request.contextPath }/product/list.do?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}" style="background-color: #bbbabf;border:#bbbabf">&lt;&lt;下一页</a>
							
				</aside>
			</section>
			
</body>
</html>
