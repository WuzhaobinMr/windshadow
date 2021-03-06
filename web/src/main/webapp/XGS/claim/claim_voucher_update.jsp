﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
		<link href="<%=request.getContextPath() %>/css/style2.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
            var k = 0;
            $(function(){
                //表单提交校验


                var items = new Array();
                var l = 0;
                //电影多个类型
                $("#AddRow").click(function(){
                    k++;
                    if(k >= 4){
                        alert("最多三个类型");
                        return;
                    }
                    var tr=$("#myTable tr").eq(0).clone();
                    ++i;
                    var j=i-1;
                    var id = $("#item").val();
                    var item=$("form select[name=item]").find('option:selected').text();
                    for(var ii=0;ii<items.length;ii++)
                    {
                        if(item == items[ii])
                        {
                            alert("类型不能重复");
                            k--;
                            return;
                        }
                    }
                    items[l] = item;
                    l++;
                    tr.find("td").get(0).innerHTML="<input  name=sid id=item"+j+" type=hidden value="+id+" />"+item;
                    tr.find("td").get(1).innerHTML="<input type=button name=DelRow"+j+" id=DelRow"+j+" onclick=delRow("+j+") value="+'删除'+" />";
                    tr.find("td").get(1).innerHTML="<img src=${images}/delete.gif width=16 height=16 id=DelRow"+j+" onclick=delRow("+j+") />";
                    tr.show();
                    tr.appendTo("#myTable");
                    //传递一共添加多少问题
                    rowNumber=i;
                });
            });
            var i = 0;
            function delRow(id){
                $("#myTable tr").eq(id+1).remove();
                //var rowNumber=$("#rowNumber").val();
                for(var s=id+1;s<rowNumber;s++){

                    $("#item"+s).attr("name","sid["+(s-1)+"].item");
                    $("#item"+s).attr("id","item"+(s-1));
                    var js="delRow("+(s-1)+");";
                    var newclick=eval("(false||function (){"+js+"});");
                    $("#DelRow"+s).unbind('click').removeAttr('onclick').click(newclick);
                    $("#DelRow"+s).attr("id","DelRow"+(s-1));
                }
                $("#rowNumber").attr("value",rowNumber-1);
                --i;
                k--;
            }

            var is = 0;
            function dela() {
				$("#dd").remove();
				is = 1;
            }

            function submitClaimVoucher(action){
                if(!confirm("确定"+action+"电影吗")) return;
                var name = $("#Name").val;//获取电影名称
                var language = $("#Language").val();//获取电影语言
                var min = $("#Min").val();//片长
                var monye = $("#Monye").val();//价格
                var shijian = $("#Date").val();//放映时期
                var office = $("#Office").val();//电影票房
                var aid = $("#Aid").val();//地区
                var intro = $("#intro").val();//电影简介
                if(name == "")
                {
                    alert("电影名称不能为空！");
                    return;
                }else if(language == "")
                {
                    alert("电影语言不能为空！");
                    return;
                }
                else if(min == "")
                {
                    alert("片长不能为空！");
                    return;
                }else if(monye == "")
                {
                    alert("价格不能为空！");
                    return;
                }else if(shijian == "")
                {
                    alert("放映时期不能为空！");
                    return;
                } else if(office == "")
                {
                    alert("电影票房不能为空！");
                    return;
                }
                else if(aid == "请选择")
                {
                    alert("请选择地区！");
                    return;
                }
                else if(intro == "")
                {
                    alert("电影简介不能为空！");
                    return;
                }

                document.claimForm.submit();
            }

            function imgPreview(fileDom){
                //判断是否支持FileReader
                if (window.FileReader) {
                    var reader = new FileReader();
                } else {
                    alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
                }

                //获取文件
                var file = fileDom.files[0];
                var imageType = /^image\//;
                //是否是图片
                if (!imageType.test(file.type)) {
                    alert("请选择图片！");
                    return;
                }
                //读取完成
                reader.onload = function(e) {
                    //获取图片dom
                    var img = document.getElementById("preview");

                    //图片路径设置为读取的图片
                    img.src = e.target.result;
                };
                reader.readAsDataURL(file);

                //判断文件是否是图片
                if(typeof FileReader != 'undefined'){
                    var file = document.getElementById("URL").files[0];
                    if((file.type).indexOf("image/")==-1){
                        alert("请上传图片!");
                    }
                }else{
                    var fileName=document.getElementById(this).value;
                    var suffixIndex=fileName.lastIndexOf(".");
                    var suffix=fileName.substring(suffixIndex+1).toUpperCase();
                    if(suffix!="BMP" && suffix!="JPG" && suffix!="JPEG" && suffix!="PNG" && suffix!="GIF"){
                        alert("请上传图片（格式BMP、JPG、JPEG、PNG、GIF等）!");
                    }
                }
            }

		</script>
		
		</head>
	<body>
	<div class="action  divaction">
		<div class="t">电影更新</div>
		<div class="pages">
			<form action="../../xgs/UpdaFilm" name="claimForm">
				<table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <tr>
					  <td >编号：</td>
					  <td><input type="text" id="id" name="id" readonly="readonly" value="${list.id}"/></td>
					  <td>电影名称：</td>
					  <td><input type="text" id="Name" name="name" value="${list.name}" style="width: 80px"/></td>
                  </tr>
                  <tr>
					  <td>语言：</td>
					  <td><input type="text" id="Language" name="language" value="${list.language}"/></td>
					  <td>片长：</td>
					  <td><input type="text" id="Min" name="min" value="${list.min}"/></td>
				  </tr>
					<tr>
						<td>价格：</td>
						<td><input type="text" id="Monye" name="monye" value="${list.monye}"/></td>
						<td>放映日期：</td>
						<td><fmt:formatDate value="${list.date}" pattern="yyyy-MM-dd" type="date"/></td>
					</tr>
					<tr>
						<td>海报：</td>
						<td>
							<img id="preview" width="100px" height="100px" src="${list.hoto}"/>
							<br />
							<input type="file" name="fileG" id="URL" onchange="imgPreview(this)" />
						</td>
					</tr>
				</table>
				<table id="myTable" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<tr>
						<td width="30%">电影类别</td>
						<td width="30%">操作</td>
					</tr>
				</table>
				<table id="detailTable1" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<tr id="dd">
					<c:forEach items="${sort}" var="so">
						<td>
							<input  name=sid id=sid type=hidden value="${so.id}"/>${so.name}
						</td>
					</c:forEach>
						<td><input type="button" name="but"  id="but" value="删除" onclick="dela()"/></td>
					</tr>
					<tr>
						<td width="30%">
							<select name="item" id="item">
								<option value="1">剧情</option>
								<option value="2">喜剧</option>
								<option value="3">惊悚</option>
								<option value="4">动作</option>
								<option value="5">爱情</option>
								<option value="6">犯罪</option>
								<option value="7">恐怖</option>
								<option value="8">冒险</option>
								<option value="9">悬疑</option>
								<option value="10">科幻</option>
								<option value="11">家庭</option>
								<option value="12">奇幻</option>
								<option value="13">纪录片</option>
								<option value="14">动画</option>
								<option value="15">战争</option>
								<option value="16">历史</option>
								<option value="17">传记</option>
								<option value="18">音乐</option>
								<option value="19">歌舞</option>
								<option value="20">运动</option>
							</select>
						</td>
						<td width="30%"><img src="${images}/add.gif" width="16" height="16" id="AddRow"/></td>
					</tr>
				</table>
				<table>
					<tr>
						<td width="30%">电影状态
							<select name="status" id="Status">
								<option value="${list.status}">${list.status}</option>
								<option value="已上架">已上架</option>
								<option value="已下架">已下架</option>
								<option value="预上架">预上架</option>
							</select>
						</td>
					</tr>
					<tr>
						<td width="30%">电影地区
							<select name="Aid" id="Aid">
								<option value="${list.ad}">${list.area}</option>
								<option value="1">中国</option>
								<option value="2">哈萨克斯坦</option>
								<option value="3">印度</option>
								<option value="4">德国</option>
								<option value="5">日本</option>
								<option value="6">韩国</option>
								<option value="7">俄罗斯</option>
								<option value="8">美国</option>
								<option value="9">泰国</option>
								<option value="10">英国</option>
								<option value="11">马来西亚</option>
								<option value="12">澳大利亚</option>
								<option value="13">中国台湾</option>
								<option value="14">法国</option>
								<option value="15">中国香港</option>
								<option value="16">意大利</option>
								<option value="17">丹麦</option>
								<option value="18">比利时</option>
								<option value="19">加拿大</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>电影票房：<input type="text" value="${list.office}" name="office"></td>
					</tr>
					<tr>
						<td>电影评分：<input type="text" value="${list.grade}" name="grade"></td>
					</tr>
					<tr>
						<td>电影简介：<textarea rows="5" cols="66" name="intro" id="intro">${list.intro	}</textarea></td>
					</tr>
				</table>
					  <%--

				<table id="myTable" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<tr>
						<td width="30%">职务</td>
						<td width="30%">演员</td>
						<td width="30%">人物简介</td>
						<td width="10%">操作</td>
					</tr>
					<c:forEach var="name" begin="" end="">
						<tr>
							<td>
							<td><c:out value="bbb"/></td></td>
							<td>
							<td><c:out value="bbb"/></td></td>
							<td>
							<td><c:out value="bbb"/></td>
							</td>
							<td>
								<img src=${images}/delete.gif width=16 height=16 id=DelRow${s.index}
									 onclick=delRow(${s.index}) />
							</td>
						</tr>
					</c:forEach>
				</table>--%>
				<table>
					<tr align="center" colspan="4">
						<td >
							<input type="button" id="2" name="2" value="提交" class="submit_01" onclick="submitClaimVoucher('提交')"/>
							<input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01"/>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</body>
</html>
