<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html><head lang="en">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
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
	});
</script>
    <script>
        // 1、获得焦点，内容为空，tip默认提示
        // 2、失去焦点，内容为空，tip为隐藏
        // 3、其他情况（按键抬起，失去焦点且内容不为空，或最后表单总验证）
        //    按键抬起为空，报错，不能为空
        //    内容匹配，成功
        //    内容不匹配，失败
        // 4、密码要进行安全等级检测，含数字、字母、特殊字符为强，两种为中，一种为弱
        // 5、确认密码失去焦点的时候就要验证是否一致
    </script>
</head>
<body>
    <!--头部-->
    <div class="header"> 
        <div class="desc">欢迎注册</div>
    </div>    
    <!--版心-->
    <div class="container">
    	<!--京东注册模块-->
    	<div class="register">
    	<form action="${pageContext.request.contextPath}/register.do" method="post">
    		<!--用户名-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="userName">用&nbsp;户&nbsp;名</label>
    				<input id="userName" name="uName" placeholder="您的账户名和登录名" type="text">
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--设置密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="pwd">设 置 密 码</label>
    				<input id="pwd" name="uPassword" placeholder="建议至少两种字符组合" type="password">
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--确认密码-->
    		<div class="register-box">
    			<!--表单项-->
    			<div class="box default">
    				<label for="pwd2">确 认 密 码</label>
    				<input id="pwd2" placeholder="请再次输入密码" type="password">
    				<i></i>
    			</div>
    			<!--提示信息-->
    			<div class="tip">
    				<i></i>
    				<span></span>
    			</div>
    		</div>
    		<!--注册-->
    		<input id="btn" type="submit" value="注册" id="btn" />
    </form>
			
    	</div>   	
    </div>
    <script>
    	
    
    
    </script>
</body>
</html>