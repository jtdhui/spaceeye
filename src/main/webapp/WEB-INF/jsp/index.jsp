<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>

       <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
  </head>
  
  <body>
       <%@ include file="/WEB-INF/common/head.jsp"%>
	   <%@ include file="/WEB-INF/common/left.jsp"%>
	   <div id="content">
	       <iframe style="float:left;" src="${pageContext.request.contextPath}/satelliteList" id="iframepage" frameborder="0" scrolling="no" marginheight="0" name="iframepage" marginwidth="0"  width="90%" height="100%"></iframe>  
       </div>
  </body>
</html>  



