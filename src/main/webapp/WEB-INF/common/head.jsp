<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header" style="height:50px;widht:100%;background:blue;padding:5px 5px 6px 6px;">
	<div style="color:white;font-size:20px;float:left">SpaceEye后台系统</div>
    <div style="color:white;font-size:12px;float:right">您好,${sysuser.userName }&nbsp;&nbsp;&nbsp;&nbsp;  <span><a href="${pageContext.request.contextPath}/loginOut">退出</a></span></div>
</div>
