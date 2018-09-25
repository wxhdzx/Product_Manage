<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
<style>
body {
	height: 100%;
	background:#FFFAFA;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/product/list.do">返回</a>
	<section>
		<form action="${pageContext.request.contextPath}/product/update.do" enctype="multipart/form-data" method="post">
		<input type="hidden" name="pId" value="${product.pId}">
		<ul class="ulColumn2">
			<li>
				<span class="item_name" style="width: 120px;"></span> 
				<input type="text" name="pName" class="textbox textbox_225" value="${product.pName }"/> 
			</li>
			<li>
				<span class="item_name" style="width: 120px;"></span> 
				<input type="text" name="pPrice" class="textbox textbox_225" value="${product.pPrice }"/> 
			</li>
			<li>
				<span class="item_name" style="width: 120px;"></span> 
				<input type="text" name="pNumber" class="textbox textbox_225" value="${product.pNumber }"/> 
			</li>
			<li>
				<span class="item_name" style="width: 120px;">类别:</span> 
				<select name="pCid" class="select">
					<c:forEach items="${list}" var="name">
						<option value="${name.cId }" <c:if test="${name.cId==product.pCid}"> selected</c:if>>
						${name.cName}</option>
				   </c:forEach>
						
				</select> 
			</li>
			<li>
				<span class="item_name" style="width: 120px;"></span>
				 <textarea placeholder="摘要信息" name="pDesc" class="textarea"
						style="width: 500px; height: 100px;">
						${product.pDesc}
				</textarea>
			</li>
			<li>
				
				<span class="item_name" style="width: 120px;">上传图片：</span> 
			<label
				class="uploadImg"> 
				<input type="file" name="file"/> 
				<span>上传图片</span>
				
			</label>
			<img src="/image/${product.pImage }" width="130px">
			</li>
			<li>
				<span class="item_name" style="width: 120px;"></span>
				<input type="submit" value="修改" class="link_btn" />
			</li>
		</ul>
		</form>
	</section>
</body>
</html>