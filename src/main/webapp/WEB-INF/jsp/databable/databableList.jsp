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
    <form id="form" action="${pageContext.request.contextPath }/datatable/upload" enctype="multipart/form-data" method="post">
        <table style="margin-top:20px;margin-left:20px;">
            <tr>
                <td>上传sql文件:</td>
                <td>
                    <div style="float:left;"><input type="file" name="file"></div>
                    <div style="float:left;"><input id="upload" data-toggle="modal" data-target="#myModal" class="btn btn-primary" value="上传"></div>
                    <input type="hidden" name="imprint">
                </td>
            </tr>
        </table>
    </form>
    <form class="bs-example bs-example-form" id="from" action="${pageContext.request.contextPath}/findArticleList" method="post">
         <input type="hidden"  id="pageSize" name="pageSize" value="${pagemsg.pageSize}">
         <input type="hidden" id="currentPage" name="currentPage" value="${pagemsg.currPage}">
    </form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>序号</th><th class="sort-column login_name">上传时间</th><th>版本说明</th><th>当前版本</th></tr></thead>
		<tbody>
			  <c:forEach items="${pagemsg.lists }" var="databable" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td><fmt:formatDate value="${databable.pushTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${databable.imprint }</td>
					<td>
					    <input type="radio">			    
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
             $("#upload").click(function(){
                   $("#imprint").val("");
                   var file=$("input[name='file']").val();
                   $("#fileName").html(file);
             });
             
             $("#updateDatabable").click(function(){
                  var file=$("input[name='file']").val();
                  if(file==null || file==""){
                      alert("请选择上传文件");
                      return false;
                  }
                  var imprint=$("#imprint").val();
                  $("input[name='imprint']").val(imprint);
                  $("#form").submit();
                  
             });
       });

</script>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
           
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
             
         
                                已选择文件:<span id="fileName"></span>
            </div>
            <div class="modal-body">
                 <textarea rows="10" cols="70" id="imprint"></textarea>
		      </div>
            <div class="modal-footer">
                <button type="button" id="updateDatabable" class="btn btn-primary">更新</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>  

