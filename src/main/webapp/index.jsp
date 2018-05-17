<%@ page language="java" pageEncoding="UTF-8"%>
<html>
  <head>
       <script language="javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
       <script language="javascript" src="${pageContext.request.contextPath }/ckfinder/ckfinder.js"></script>
            <script language="javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.9.1.min.js"></script>
           <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
    <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <%@ include file="/WEB-INF/common/head.jsp"%>
	   <%@ include file="/WEB-INF/common/left.jsp"%>
    <form  name="frmList"  action="${pageContext.request.contextPath }/company/save" enctype="multipart/form-data">
		<div align="center" style="float:right;margin-left:120px;margin-top:-150px;">
			<TABLE width="100%" height="100%" cellspacing="0" cellpadding="0" border="0">
				<TR>
				<TD valign="top" width="63%" height="100%">
				    <table width="100%" cellpadding="0">  
						<tr id="content1">
				            <td class="tdRight">
				           		<textarea id="helpCenter" name="helpCenter" rows="8" cols="52" class="ckeditor"></textarea>
				           		 
				            </td>
				            
				        </tr> 
					</table> 
				</TD>
				</TR>
			</TABLE>
		</div>
		
	 
	</form>
	
	<script type="text/javascript"> 
	function save(){
	
	      //JavaScript判空，如果确定  
        var editor_data = CKEDITOR.instances.helpCenter.getData();  
        console.info(editor_data);
        if(editor_data==null||editor_data==""){  
            alert("数据为空不能提交");  
        }else{  
            if(confirm(editor_data)){  
                document.frmList.submit();  
            }  
        }         
	
	};
	       	        
	</script>
  </body>
</html>  

