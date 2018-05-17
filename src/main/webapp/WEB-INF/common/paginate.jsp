<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.aspan a,.aspan span{
		display:block;
		width:40px;
		height:30px;
		text-decration:none;
		border-radius: 50%;
		float:left;
		margin-left: 10px;
		color: #333;
		font: 14px "Microsoft YaHei";
		text-align:center;
		line-height:30px;
		cursor: pointer;
	}
	.aspan a:hover,.aspan span:hover{
		background-color: #199bff;
	}
	.clearfix:after{visibility:hidden;display:block;font-size:0;content:" ";clear:both;height:0}
	.container{
		height: 100px;
		margin: 20px 0;
	}
</style>

<div class="clearfix container">
	<div class="" style="float: right;margin-top: 40px;height: 30px;margin-left: 20px;">
		<a style="color:#00A0E9;cursor: pointer" onclick="go()">GO</a> <input name="pageNumber" type="number" min="1" value="${pageNum}" style="width: 40px;height: 30px;text-align: center;-webkit-appearance: none;-moz-appearance: none;appearance: none;border: 1px solid rgb(169, 169, 169);"> 页
	</div>



	<div style="float:right;margin-top:0;" class="aspan">
		<c:if test="${urlParas == null}">
			<c:set var="urlParas" value="" />
		</c:if>
		<c:if test="${(totalPage > 0) && (currentPage <= totalPage)}">
			<c:set var="startPage" value="${currentPage - 4}" />
			<c:if test="${startPage < 1}" >
				<c:set var="startPage" value="1" />
			</c:if>
			<c:set var="endPage" value="${currentPage + 4}" />
			<c:if test="${endPage > totalPage}" >
				<c:set var="endPage" value="totalPage" />
			</c:if>

			<div class="pagination clearfix">
				<c:if test="${currentPage <= 8}">
					<c:set var="startPage" value="1" />
				</c:if>

				<c:if test="${(totalPage - currentPage) < 8}">
					<c:set var="endPage" value="${totalPage}" />
				</c:if>

				<c:choose>
					<c:when test="${currentPage == 1}">
						<span class="disabled prev_page">上页</span>
					</c:when>
					<c:otherwise>
						<a  onclick="page(${currentPage - 1})"  class="prev_page">上页</a>
					</c:otherwise>
				</c:choose>

				<c:if test="${currentPage > 8}">
					<a onclick="page(1)">${1}</a>
					<a onclick="page(2)">${2}</a>
					<span class="gap">…</span>
				</c:if>

				<c:forEach begin="${startPage}" end="${endPage}" var="i">
					<c:choose>
						<c:when test="${currentPage == i}">
							<span class="current">${i}</span>
						</c:when>
						<c:otherwise>
							<a onclick="page(${i})">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${(totalPage - currentPage) >= 8}">
					<span class="gap">…</span>
					<a onclick="page(${totalPage - 1})">${totalPage - 1}</a>
					<a onclick="page(${totalPage}) ">${totalPage}</a>
				</c:if>

				<c:choose>
					<c:when test="${currentPage == totalPage}">
						<span class="disabled next_page">下页</span>
					</c:when>
					<c:otherwise>
						<a onclick="page(${currentPage+1})" class="next_page" rel="next">下页</a>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
	</div>



	<div class="" style="font-size: 14px;float:right;margin-right: 32px;margin-top:40px">
		每页显示数据数量 <select name="selectNumber" id="selectNumber" style="margin-left: 10px;height: 30px;border: 1px solid #ccc;cursor: pointer">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="50">50</option>
		<option value="100">100</option>
	</select>
	</div>
</div>

<script>
	 function go(){
           var pageNum=$("input[name='pageNumber']").val();
		 $("#currentPage").val(pageNum);
		 $("#from").submit();
	 }
	 $(function(){
		 $("#selectNumber").change(function(){
			 $("#pageSize").val($(this).val());
			 $("#from").submit();
		 })
		 var pageSize=$("#pageSize").val();
		 $("#selectNumber option").each(function(){

			 if($(this).val()==pageSize){
				 $(this).attr("selected",true);
			 }
		 });

	 });
	 function  page(num){
			$("#currentPage").val(num);
			$("#from").submit();
		}

</script>
