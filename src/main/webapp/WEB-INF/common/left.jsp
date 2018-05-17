<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
         <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
  </head>

	<div id="main" style="float:left; border:1px solid #D0CDC7;">
	    <ul class="nav nav-pills nav-stacked">
	      <li><a href="#">更新卫星数据库</a></li>
          <li class="active"><a href="#">卫星详情管理</a></li>
          <li><a href="#">资讯管理</a></li>
          <li><a href="#">帮助中心</a></li>
          <li><a href="javascript:void(0)">联系我们</a></li>
          <li><a href="#">版本说明</a></li>
       </ul>
	</div>
	
	<script type="text/javascript">
	     $(function(){
	         $("#main ul li").each(function(x,y){
	             $(this).click(function(){
	                  $("#main ul li").removeClass("active");
	                  $(this).addClass("active");
	                  if(x==0){
	                     $("#iframepage").attr("src","${pageContext.request.contextPath}/datatable/findDatatableList");
	                  }else if(x==1){
	                     $("#iframepage").attr("src","${pageContext.request.contextPath}/satelliteList");
	                  }else if(x==2){
	                     $("#iframepage").attr("src","${pageContext.request.contextPath}/findArticleList?categoryId=0");
	                  }else if(x==3){
	                   $("#iframepage").attr("src","${pageContext.request.contextPath}/findAppInformation?type=1");
	                   /*$.ajax({
	                        url:"${pageContext.request.contextPath}/appFindInformation",
	                        type:"post",
	                        dataType:"json",
	                        data:{type:"1"},
	                        success: function(data){
	                              console.info(data);
	                         
	                         }
	                        }
	                        
	                     );*/
	                  }else if(x==4){
	                    $("#iframepage").attr("src","${pageContext.request.contextPath}/findAppInformation?type=2");
	                    /*$.ajax({
	                        url:"${pageContext.request.contextPath}/appFindInformation?type=2",
	                        type:"post",
	                        dataType:"json",
	                        success: function(data){
	                              console.info(data);
	                         
	                         }
	                        }
	                        
	                     );*/
	                  }else if(x==5){
	                     //$("#iframepage").attr("src","${pageContext.request.contextPath}/findImprint");
	                     $("#iframepage").attr("src","${pageContext.request.contextPath}/findAppInformation?type=3");
	                      /*$.ajax({
	                        url:"${pageContext.request.contextPath}/appFindInformation?type=3",
	                        type:"post",
	                        dataType:"json",
	                        success: function(data){
	                              console.info(data);
	                         
	                         }
	                        }
	                        
	                     );*/
	                  }else if(x==6){
	                      $.ajax({
	                        url:"${pageContext.request.contextPath}/appSatellite/appFindSatelliteList",
	                        type:"post",
	                        dataType:"json",
	                        data:{"data":{pageNumber:1,pageSize:20}},
	                        success: function(data){
	                              console.info(data);
	                         
	                         }
	                        }
	                        
	                     );
	                  }
	                  
	             });
	         });
	     
	     });
	
	</script>

</html>  

