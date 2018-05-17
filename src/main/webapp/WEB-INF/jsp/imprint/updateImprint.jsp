<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
       <script language="javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
       <script language="javascript" src="${pageContext.request.contextPath }/ckfinder/ckfinder.js"></script>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/css/bootstrap.min.css"/>  
       <script src="${pageContext.request.contextPath}/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
  </head>
  
  <form  name="frmList"  action="${pageContext.request.contextPath }/saveImprint" enctype="multipart/form-data">
		<div align="center">
			<TABLE width="100%" height="100%" cellspacing="0" cellpadding="0" border="0">
				<TR>
				<TD valign="top" width="63%" height="100%">
				    <table width="100%" cellpadding="0">  
						<tr id="content1">
				            <td class="tdRight">
				           		<textarea id="content" name="content" rows="8" cols="52" class="ckeditor">${imprint.content }</textarea>				           		 
				            </td>				            
				        </tr> 
					</table> 
				</TD>
				</TR>
			</TABLE>
		</div>
		
		 <div class="modal-footer" style="position: absolute;margin-top:-200px;" >  
		         <button type="button" class="btn btn-primary" onclick="save()">保存</button>  
		   </div> 
	</form>
	
	<script type="text/javascript"> 
	function save(){	
	      //JavaScript判空，如果确定  
        var editor_data = CKEDITOR.instances.content.getData();  
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

</html>  

