<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/verificationNumbers.js"></script>
<script src="${pageContext.request.contextPath}/js/Particleground.js"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
		//验证码
		createCode();
	});
</script>
</head>
<body>
	<dl class="admin_login">
		<dt>
			<strong>货物管理登录</strong> <em>Management System</em>
		</dt>
		<center><font style="color:green;">${message}</font></center>
		<form id="myForm" action="${pageContext.request.contextPath}/login.do" method="post">
			<dd class="user_icon">
				<input type="text" placeholder="账号" name="uName" class="login_txtbx" />
			</dd>
			<dd class="pwd_icon">
				<input type="password" placeholder="密码" name="uPassword" class="login_txtbx" />
			</dd>
			<dd>
				<input type="submit" value="立即登陆" class="submit_btn" />
			</dd>
			<dd>
				<a href="${pageContext.request.contextPath}/register.do" style="font-size: 12px;color: white;align-content: center;">立即注册</a>
			</dd>
		</form>
	</dl>
</body>

</html>
