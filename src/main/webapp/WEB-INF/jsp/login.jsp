<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<html xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
    <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
    <style type="text/css">
html, body, table {
	background-color: #f5f5f5;
	width: 100%;
	text-align: center;
}

.form-signin-heading {
	font-family: Helvetica, Georgia, Arial, sans-serif, é»ä½;
	font-size: 36px;
	margin-bottom: 20px;
	color: #0663a2;
}

.form-signin {
	position: relative;
	text-align: left;
	width: 400px;
	padding: 25px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin div {
	margin-bottom: 10px;
	color: #0663a2;
}

.form-signin .input-label {
	font-size: 16px;
	line-height: 40px;
	color: #999;
}

.form-signin .input-block-level {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px;
	*width: 300px;
	*padding-bottom: 0;
	_padding: 7px 7px 9px 7px;
}

.form-signin .btn.btn-large {
	font-size: 16px;
}

.form-signin #themeSwitch {
	position: absolute;
	right: 15px;
	bottom: 10px;
}

.form-signin div.validateCode {
	padding-bottom: 15px;
}

.mid {
	vertical-align: middle;
}

.header {
	height: 80px;
	padding-top: 20px;
}

.alert {
	position: relative;
	width: 300px;
	margin: 0 auto;
	*padding-bottom: 0px;
}

label.error {
	background: none;
	width: 270px;
	font-weight: normal;
	color: red;
	margin: 0;
}
</style>
<script type="text/javascript">
		$(document).ready(function() {
			
			});
	</script>
</head>
<body>
	<div class="header">
          <h1 class="form-signin-heading">SpaceEye后台系统</h1>         
	</div>
	<label id="loginError" class="error">${message}</label>
	<form id="loginForm" style="height:300px;" class="form-signin" action="${pageContext.request.contextPath}/login.do"
		method="post">		
		<label class="input-label" for="username">用户名:</label> 
		<div><input type="text" id="username" name="userName" class="input-block-level required"/></div>
		<label class="input-label" for="password">密码:</label> 
		<div><input type="password" id="password" name="password" class="input-block-level required"/></div>
		<input class="btn btn-large " style="float: right" type="submit" value="登录" />
	</form>
</body>
</html>