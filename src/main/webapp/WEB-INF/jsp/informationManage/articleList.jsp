<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="${pageContext.request.contextPath}/css/paginate.css" rel="stylesheet" type="text/css" />
<html>
  <head>
       <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
       <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
  </head> 
 <body style="height:100%;width:100%;background:#F3F2F0;">
    <form class="bs-example bs-example-form" id="from" action="${pageContext.request.contextPath}/findArticleList" method="post">
        <div id="articleTop">
		     <P><b>新闻资讯</b></P>    
		     
		       <div style="float:left;margin-left:5px;;margin-right:15px;" onclick="add('0')">      
                 <button type="button"  class="btn btn-primary">添加文章</button>       
            </div> 
		     
		      <div class="input-group input-group-sm" style="margin-top:10px;margin-left:20px;"> 
             <div style="float:left;margin-top:5px;margin-right:10px;">标题</div> 
             <div style="float:left;margin-right:10px;">      
                  <input type="text" id="title" name="title" value="${article.title}" class="form-control" placeholder="请输入文章标题">             
            </div>
             <div style="float:left;">      
                 <input id="search" class="btn btn-primary"
				type="button" value="查询" />        
            </div>
        </div>
        <br>                
        </div>      
            <div id="satelliteTop"> 
        <div class="input-group input-group-sm" style="margin-top:10px;margin-left:10px;"> 
             <div style="color:#666560;font-weight:bold;font-size:14px;margin-bottom:10px;" id="titleName">
                  ${name}
             </div>
             <div style="float:left;margin-left:5px;" onclick="update()">      
                 <input id="editor" class="btn btn-primary"
				type="button" value="编辑概述" />        
            </div>           
             <div style="float:left;margin-left:5px;" onclick="add('1')">      
                 <input id="add"  class="btn btn-primary"
				type="button" value="新增文章" />        
            </div>          
             <div style="float:left;margin-left:5px;">      
                 <input id="reprintArticle" class="btn btn-primary"
				type="button" value="转载文章" data-toggle="modal" data-target="#myModal"/>        
            </div>
        </div>
        <br>  
            <input type="hidden" id="categoryId" name="categoryId" value="${article.categoryId}">  
            <input type="hidden" id="satelliteBhao" name="satelliteBhao" value="${article.satelliteBhao}">     
            <input type="hidden"  id="pageSize" name="pageSize" value="${pagemsg.pageSize}">
            <input type="hidden" id="currentPage" name="currentPage" value="${pagemsg.currPage}">
    </div>
    </form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>序号</th><th class="sort-column login_name">文章标题</th><th>发布时间</th><th>状态</th><th>操作</th></tr></thead>
		<tbody>
			  <c:forEach items="${pagemsg.lists }" var="article" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${article.title }</td>
					<td><fmt:formatDate value="${article.publishTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
					   <c:if test="${article.status=='0'}">
					              未推送
					   </c:if>
					    <c:if test="${article.status=='1'}">
					              已推送
					   </c:if>					    
					</td>
					<td>
					    <a href="${pageContext.request.contextPath}/toAddOrUpdateArticle?articleId=${article.articleId}">编辑</a>
					    <a href="${pageContext.request.contextPath}/deleteArticle?articleId=${article.articleId}">删除</a>
					    <a href="${pageContext.request.contextPath}/pushArticle?articleId=${article.articleId}">推送</a>
					</td>
				</tr>
				</c:forEach>
		</tbody>
	</table>
    <div>
		<c:set var="currentPage" value="${pagemsg.currPage}" />
		<c:set var="totalPage" value="${pagemsg.totalPage}" />
		<%@ include file="../../common/paginate.jsp" %>
	</div>
<script type="text/javascript">
     $(function(){
       $("#search").click(function(){
             $("#from").submit();  
       }); 
       var categoryId=$("#categoryId").val();
       if(categoryId=="1"){
    	   $("#articleTop").hide();
       }else if(categoryId=="0"){
    	   $("#satelliteTop").hide();
       }      
	   $("input[name='checkAll']").click(function(){
	    	  if (this.checked) {
	    			$("input[name='checkArticle']").each(function() {
	    				this.checked = true;
	    			});
	    		} else {
	    			$("input[name='checkArticle']").each(function() {
	    				this.checked = false;
	    			});
	    		}
	    });     
       $("#reprintArticle").click(function(){
    	   $("input[name='pageNumber']").val("");
    	   $("input[name='showSize']").val("");
    	   var pageNow = 1;
    	   var showSize=5;
    	   var categoryId="0";
    	   var url="${pageContext.request.contextPath}/findArticleListJson";
    	   showPage(url,pageNow,showSize,categoryId);
       });
       
       $("#insertArticle").click(function(){
    	   $("#bhao").val($("#satelliteBhao").val());
    	   var checkArticles=$("input[name='checkArticle']:checked");
    	  $("#name").val($("#satelliteName",window.parent.document).val());
      		if(checkArticles.length>0){
      			//ȡid
      			var ids=new Array();			
      			checkArticles.each(function(){
      				 ids.push($(this).val());
      			});
      			$("#articleIds").val(ids.toString());
      		}
      		
      		$("#updateForm").submit();
      		 
       });
       
       

     });
     function add(type){
    	 window.location.href="${pageContext.request.contextPath }/toAddOrUpdateArticle?type="+type;  
     }
     function update(){
    	 var bhao=$("#titleName").text().split("-")[0];
         window.location.href="${pageContext.request.contextPath }/toAddOrUpdateSatellite?satelliteId="+bhao;
     }    
     function showPage(url,curPage,showSize,categoryId) {
    	 $.ajax({
             url: url,
             type: "POST",
             data:{"currentPage":curPage,"pageSize":showSize,"categoryId":categoryId},
             dataType: "json",
             success: function(data) {
            	 $("#articleList tbody").empty();          	
            	 var articleArrays=data.lists; 
            	 var totalPage=data.totalPage;
            	 var currPage=data.currPage;  
            	 $("#fenye").empty();
    			 var html_fy = "<div class='yemk'> 总共" + totalPage + "页/当前第<b id='cc'>" + currPage + "</b>页"
                 + "<span class='s' id='prevPage1'>" +
                 "<a  onclick='get1(0)'>上一页 </a>"
                 + "</span><span id='_cc_'></span><span class='x' id='nextPage1'><a  onclick='get1(2)'>下一页</a>"
                 + "</span> </div>";
                $("#fenye").append(html_fy);
                //显示的页码
                 var startPage;
                 var endPage;
                 if (totalPage <= 9) {
                     startPage = 1;
                     endPage = totalPage;
                 } else {
                     startPage = pageNow - 4;
                     endPage = pageNow + 4;
                     if (startPage < 1) {
                         startPage = 1;
                         endPage = 9;
                     }
                     if (endPage > totalPage) {
                         endPage = totalPage;
                         startPage = totalPage - 8;
                     }
                 }
                
                var html = "";
                 for (var ii = startPage; ii <= endPage; ii++) {
                     var ahtml = "<span class='dd'><a  href='javascript:void(0)'onclick='get1(1)'>" + parseInt(ii) + "</a></span>";
                     html = html + ahtml;
                 }
                 
                 $("#_cc_").append(html);
	    		 $.each(articleArrays,function(x,article){     			
    	    			 var tr="<tr><td><input type='checkbox' name='checkArticle' value='"+article.articleId+"'></td><td>"+article.title+"</td><td>"+article.publishTime+"</td></tr>";
    	    			 $("#articleList tbody").append(tr);      	    	    			 
	    		 });
             }

         });
     }
     function get1(va) {
    	 var url="${pageContext.request.contextPath}/findArticleListJson";
         if (va === 0) {
             getCjPageNow(url, 'prevPage');
         }
         if (va === 1) {
             getCjPageNow(url, 'curPage');
         }
         if (va === 2) {
             getCjPageNow(url, 'nextPage');
         }
     }

     function getCjPageNow(url, curPage) {
         var pageNow;
         var categoryId="1";
         var showSize=5;
         if (curPage === 'prevPage') {
             var pageNow = $("#pageNumber").val();
             pageNow = parseInt(pageNow) - 1;
             $("#pageNumber").val(pageNow);
             showPage(url, pageNow,showSize,categoryId);
         }
         if (curPage === 'nextPage') {
             var pageNow = $("#pageNumber").val();
             pageNow = parseInt(pageNow) + 1;
             $("#pageNumber").val(pageNow);
             showPage(url, pageNow,showSize,categoryId);
         }
         if (curPage === 'curPage') {
             $(".dd").click(function() {
                 $("#pageNumber").val($(this).text());
                 var pageNow = $("#pageNumber").val();
                 showPage(url, pageNow,showSize,categoryId);
             });
         }
     }
</script>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">文章列表</h4>
            </div>
            <div class="modal-body">
            <input id="pageNumber" value="" type="hidden" name="pageNumber"/>
            <input type="hidden" name="showSize"/>
            <table id="articleList"  class="table table-striped table-bordered table-condensed">
		<thead><tr><th>全选/反选 <input type="checkbox" name="checkAll"></th><th class="sort-column login_name">文章标题</th><th>发布时间</th></tr></thead>
		<tbody>

		</tbody>
		</table>
                 <div id="fenye"></div>

                 <div class="cl"></div>
		</div>
            <div class="modal-footer">
                <button type="button" id="insertArticle" class="btn btn-primary">添加</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<form action="${pageContext.request.contextPath}/updateArticle" id="updateForm" method="post">
      <input name="articleIds" id="articleIds" type="hidden"/>
      <input name="bhao" id="bhao" type="hidden"/>
      <input name="name" id="name" type="hidden"/>
</form>
</body>
</html>  

