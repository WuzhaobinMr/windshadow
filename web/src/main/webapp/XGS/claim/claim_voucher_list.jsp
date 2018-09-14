<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<link href="<%=request.getContextPath() %>/css/style2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function(){
			 //日期选择控件
		 	$("#startDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',isShowClear:true, readOnly:true });
			});
			$("#endDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}',isShowClear:true, readOnly:true });
			});

			$("select#op").change(function () {
			    var op = $("#op").val();
			    $("#status").val(op);
                document.claimVoucherForm.action = "../../xgs/SeleFilmStatus"
                document.claimVoucherForm.submit();

            });
		});
   	function delVoucher(id){
   		if(!confirm('确定删除此电影吗')) return;
   		$("#id").val(id);
   		document.claimVoucherForm.action = "../../xgs/DeleFilm"
   		document.claimVoucherForm.submit();
   	}
   	
</script>
<div class="action  divaction">
	<div class="t">电影列表</div>
	<div class="pages">
		<div class="forms">

	     </div>
	<!--增加报销单 区域 开始-->
	<form action="../../xgs/DeleFilm" name="claimVoucherForm">
		<input type="hidden" name="id" id="id" value=""/>
		<input type="hidden" name="status" id="status" value=""/>
		<table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
			<tr>
				<td><select id="op">
					<option value="请选择">请选择</option>
					<option value="全部">全部</option>
					<option value="预上架">预上架</option>
					<option value="已上架">已上架</option>
					<option value="已下架">已下架</option>
				</select></td>
			</tr>
	      <tr class="even">
	        <td>编号</td>
	        <td>电影名称</td>
	        <td>语言</td>
	        <td>片长</td>
	        <td>放映日期</td>
	        <td>状态</td>
	        <td>操作</td>
	      </tr>
			<c:forEach var="li" items="${list}" begin="0">
				<tr>
					<td id="td1">${li.id}</td>
					<td>${li.name}</td>
	        		<td>${li.language}</td>
					<td>${li.min}</td>
	        		<td><fmt:formatDate value="${li.date}" type="date" pattern="yyyy-MM-dd"/></td>
	        		<td>${li.status}</td>
	        	<td>
	        		<a href="../../xgs/SeleFilmId?id=${li.id}&is=1">
			        	<img src="${images}/edit.gif" width="16" height="16" />
						</a>
						<a onClick="delVoucher(${li.id})" href="#">
							<img src="${images}/delete.gif" width="16" height="16" />
						</a>
						<a href="../../xgs/SeleFilmId?id=${li.id}&is=2">
							<img src="${images}/search.gif" width="16" height="15" />
						</a>
					</td>
				</tr>
			</c:forEach>
	    </table>      
	   </form>
	          <!--增加报销单 区域 结束-->
       </div>
      </div>