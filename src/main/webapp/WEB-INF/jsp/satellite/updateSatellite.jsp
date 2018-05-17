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
     <P><b>卫星详情>概述编辑</b></P></br>
     
      <div id="sTitle"></div>
	  <form  name="frmList"  action="${pageContext.request.contextPath }/saveSatellite" enctype="multipart/form-data">
	         <input type="text" name="satelliteId" id="satelliteId" value="${satelliteId }"> 
	          <input type="text" name="appDetail" id="appDetail"> 
		<div align="center">
			<TABLE width="100%" height="100%" cellspacing="0" cellpadding="0" border="0">
				<TR>
				<TD valign="top" width="63%" height="100%">
				    <table width="100%" cellpadding="0">  
						<tr id="content1">
				            <td class="tdRight">		           		 
				             <textarea id="detail" name="detail" rows="8" cols="52" class="ckeditor">${satellite.detail }</textarea>
				           		  <script type="text/javascript">
				           		  		if( CKEDITOR.instances['detail'] ){    
						                   CKEDITOR.remove(CKEDITOR.instances['detail']);    
						                }  //解决 例外被抛出且未被接住 问题
										CKEDITOR.replace("detail",{ height: 200, width: 820});
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
         var editor_data = CKEDITOR.instances.detail.getData(); 
         var stemTxt=CKEDITOR.instances.detail.document.getBody().getText(); //取得纯文本   
         $("#appDetail").val(stemTxt);
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

