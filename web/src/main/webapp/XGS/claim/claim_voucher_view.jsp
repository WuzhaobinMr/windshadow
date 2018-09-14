<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>大B哥自动化影院后台管理系统</title>
		<link href="<%=request.getContextPath() %>/css/style2.css" rel="stylesheet" type="text/css" />
	</head>
<body>
<form id="myForm" name="myForm" method="post" >
    <div class="action  divaction">
    	<div class="t">查看详细</div>
   		<div class="pages">
        	<!--增加报销单 区域 开始-->
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>电影信息</caption>
                  <tr>
                      <td >编&nbsp;&nbsp;号：</td>
                      <td>${list.id}</td>
                      <td>电&nbsp;影&nbsp;名&nbsp;称：</td>
                      <td>${list.name}</td>
                      <td>语&nbsp;&nbsp;言：</td>
                      <td>${list.language}</td>
                  </tr>
                    <tr>
                        <td>片&nbsp;&nbsp;长：</td>
                        <td>${list.min}</td>
                        <td>放&nbsp;映&nbsp;时&nbsp;间：</td>
                        <td><fmt:formatDate value="${list.date}" pattern="yyyy-MM-dd" type="date"/></td>
                        <td>价&nbsp;&nbsp;格：</td>
                        <td>${list.monye}￥</td>
                    </tr>
                  <tr>
                    <td>海&nbsp;&nbsp;报：</td>
                      <td><img src="${list.hoto}" width="50px" height="50px"/></td>
                      <td>电&nbsp;影&nbsp;类&nbsp;型：</td>
                      <td><c:forEach var="so" items="${sort}">
                          ${so.name}&nbsp;
                      </c:forEach></td>
                      <td>电影&nbsp;状态：</td>
                      <td>${list.status}</td>
                  </tr>
                    <tr>
                        <td>电影&nbsp;地区：</td>
                        <td>${list.area}</td>
                        <td>电&nbsp;影&nbsp;票&nbsp;房：</td>
                        <td>${list.office}</td>
                        <td>电影&nbsp;评分：</td>
                        <td>${list.grade}</td>
                    </tr>
                  <tr>
                  	<td colspan="4"><p>-------------------------------------------------------------------------------</p></td>
                  </tr>
                </table>
      
      <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">

         
    </table>
    <p>&nbsp;</p>
   
    <p>&nbsp;</p>
    <p><input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01"/></p>       
<!--增加报销单 区域 结束-->
        </div>
    </div>
</form>
</body>