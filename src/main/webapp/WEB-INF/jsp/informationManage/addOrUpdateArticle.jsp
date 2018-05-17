<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
       <script language="javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
       <script language="javascript" src="${pageContext.request.contextPath }/ckfinder/ckfinder.js"></script>
       <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
       <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
  </head>
  
 <body style="background:#F3F2F0;width:100%;height:600px;">
     <P><b>新闻资讯>资讯编辑</b></P>
	  <form  name="frmList"  action="${pageContext.request.contextPath }/saveArticle" enctype="multipart/form-data">
	         <input type="hidden" name="articleId" id="articleId" value="${article.articleId }"> 
	         <input type="hidden" name="type" id="type" value="${type }"> 
	         <input type="hidden" name="appContent" id="appContent">
	   
	    <div id="top">
	             <div class="input-group input-group-sm"> 
                                               文章标题:<input type="text" name="title" id="title" value="${article.title }" class="form-control">
                  </div>
	        <div id="bottom">
	           <div id="sName" style="margin-top:15px;">卫星名称:
	           <select name="satelliteBhao" class="selectpicker">
	               <c:forEach items="${satelliteList }" var="satellite">
	                  <option value="${satellite.satelliteId }">${satellite.satelliteName }</option>
	               </c:forEach>
	                     </select>
	           </div>
	            <div id="push" style="margin-top:15px;margin-bottom:15px">发布位置:
	              <input type="checkbox" name="categoryId" value="0">新闻资讯 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	              <input type="checkbox" name="categoryId" value="1">本卫星资讯 
	           </div>
	        </div>
	     </div>        
		<div align="center">
			<TABLE width="100%" height="100%" cellspacing="0" cellpadding="0" border="0">
				<TR>
				<TD valign="top" width="63%" height="100%">
				    <table width="100%" cellpadding="0">  
						<tr id="content1">
				            <td class="tdRight">
				           		<!--<textarea id="" name="content" rows="8" cols="52" class="ckeditor">${information.content }</textarea>-->			           		 
				             <textarea id="content" name="content" rows="8" cols="52" class="ckeditor">${article.content }</textarea>
				           		  <script type="text/javascript">
				           		  		if( CKEDITOR.instances['content'] ){    
						                   CKEDITOR.remove(CKEDITOR.instances['content']);    
						                }  //解决 例外被抛出且未被接住 问题
										CKEDITOR.replace("content",{ height: 200, width: 820});
								  </script>
				            
				            </td>				            
				        </tr> 
					</table> 
				</TD>
				</TR>
			</TABLE>
		</div>
		
		 <div class="modal-footer" style="position: absolute;margin-top:-240px;" >  
		         <button type="button" class="btn btn-primary" onclick="save();">保存</button>  
		   </div> 
	</form>
</body>

<script type="text/javascript"> 
	function save(){	
	      //JavaScript判空，如果确定  
         var editor_data = CKEDITOR.instances.content.getData(); 
         var stemTxt=CKEDITOR.instances.content.document.getBody().getText(); //取得纯文本   
         $("#appContent").val(stemTxt);
        if(editor_data==null||editor_data==""){  
            alert("数据为空不能提交");  
        }else{  
            if(confirm(editor_data)){
                 document.frmList.submit();               
            }  
        }

	};	
	
	$(function(){
	      var type=$("#type").val();
	      if(type==0){
	           $("#bottom").hide();	      
	      }
	
	});
	
   	        
	</script>
</html>  

