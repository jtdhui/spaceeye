<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
       <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
  </head>
  
  <body style="height:100%;width:100%;background:#F3F2F0;">
  
    <P><b>联系我们</b></P>
  <hr/>
  
  <form  name="frmList"  action="${pageContext.request.contextPath }/saveAppInformation">
       <input type="hidden" name="type" value="${type }">
       <textarea id="contactUs" name="contactUs" rows="8" cols="52">${appInformation.contactUs }</textarea>

	 <div style="margin-top:10px;margin-left:100px;">  
		         <button type="submit" class="btn btn-primary">保存</button>  
		   </div> 
	</form>
	
</body>
</html>  

