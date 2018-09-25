<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />

<title>添加商品</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
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
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript">
	/* $(function(){
		$("#file").click(function(){
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/upload.do",
				 /*  // data: $("#itemAddForm").serialize(),
				   statusCode: {
					   statusCode : {
						   204 : function(){
							   $.message.alert('提示','文件添加上传成功!');
						   },
						   500 : function(){
							   $.message.alert('提示','文件上传失败!');
						   }
					   } 
				});
		});
		
	}); */
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/product/list.do">返回</a>
	<form action="${pageContext.request.contextPath}/product/save.do" method="post" enctype="multipart/form-data">
		 <ul class="ulColumn2">
			<li>
				<span class="item_name" style="width: 120px;">商品名称：</span> 
				<input type="text" name="pName" class="textbox textbox_225"/> 
			</li>
			<li>
				<span class="item_name" style="width: 120px;">价格：</span> 
				<input type="text" name="pPrice" class="textbox textbox_225"/> 
			</li>
			<li>
				<span class="item_name" style="width: 120px;">数量：</span> 
				<input type="text" name="pNumber" class="textbox textbox_225"/> 
			</li>
			<li>
				<span class="item_name" style="width: 120px;">类别：</span> 
				<select name="pCid" class="select">
					<c:forEach items="${list}" var="name">
						<option value="${name.cId }">${name.cName}</option>
				   </c:forEach>
						
				</select> 
				
			</li>
			<li>
				<span class="item_name" style="width: 120px;">描述：</span>
				 <textarea placeholder="摘要信息" name="pDesc" class="textarea"
						style="width: 500px; height: 100px;">
				</textarea>
			</li>
			<li>
				<span class="item_name" style="width: 120px;">上传图片：</span> 
			<label
				class="uploadImg"> 
				<input type="file" name="file" id="file"/> 
				<span>上传图片</span>
			</label>
			</li>
			<li>
				<span class="item_name" style="width: 120px;"></span>
				<input type="submit" value="添加" class="link_btn" />
			</li>
		</ul>
		</form>
	
</body>
</html>