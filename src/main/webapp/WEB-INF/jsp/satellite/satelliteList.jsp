<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
       <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
       <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
  </head>  
 <body>
	    <div style="background:#F3F2F0;border-right:1px solid #787771;width:300px;height:600px;padding-top:10px;float:left;">
            <input type="text" id="satelliteName" class="form-control">
           <ul class="list-group"></ul>
        </div>      
        <div style="float:left;width:75%;height:600px;background:#F3F2F0;">
           <iframe style="float:left;" src="" id="iframepage" frameborder="0" scrolling="no" marginheight="0" name="iframepage" marginwidth="0"  width="90%" height="100%"></iframe>         
        </div>	
	<script type="text/javascript">
	     $(function(){
	         $("#satelliteName").blur(function(){
	            var bhao=$("#satelliteName").val();
	                $.ajax({
	                    url:"${pageContext.request.contextPath}/findSatelliteLikeBhao",
	                    type:"post",
	                    dataType:"json",
	                    data:{bhao:bhao},
	                    success: function(data){  
	                       var str="";                      
	                           $.each(data,function (i,item) {
                                    str+="<li class='list-group-item'>"+item+"</li>";                                            
                                });                       
                             $("ul").append(str);  
                             console.info($("ul li").length);                         
                             $("ul li").each(function(x,y){
	                             $(this).click(function(){
	                                var name=$(this).text();
	                                var bhao_name=name.split("-");
	                                var bhao=bhao_name[0];
	                                console.info(bhao);
	                                 $("#satelliteName").val(name);
	                                 $("ul").hide();
	                                 $("#iframepage").attr("src","${pageContext.request.contextPath}/findArticleList?categoryId=1&name="+name+"&satelliteBhao="+bhao);
	                              });
	                             
	                         });
	                      }
	                });
	         
	         });

	   });
	
	</script>
       

</body>
</html>  

