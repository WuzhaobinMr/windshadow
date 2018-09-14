<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="taglib.jsp"%>
<div class="nav" id="nav">
	<div class="t"></div>
   		<dl class="open">
	       	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">电影管理</dt>
	           <dd><a href="../../xgs/SeleFilm">查询电影</a></dd>
	           <dd><a href="XGS/claim/claim_voucher_edit.jsp">添加电影</a></dd>
	       </dl>
       <dl>
       		<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">人物管理</dt>
	           <dd><a href="leave_searchLeavegetLeaveList">查看请假</a></dd>
		       <dd><a href="leave/leave_edit.jsp">申请请假</a></dd>
       </dl>


       <dl>
       	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息中心</dt>
           <dd>信心收件箱</dd>
           <dd>信心发件箱</dd>
       </dl>
</div>
