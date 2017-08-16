<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script >
	//全选和全不选的功能
	function checkAllOrNot(checked){
		$(" #tableList input[type='checkbox']").attr("selected",selected);
		
	}
	//完成选中的行进行删除操作
	function optDelete(name,isDisplay,pageNum,pageSize){
		alert("aaa");
		var size = $("input[name='ids']:checked ").size();
		if(size==0){
			alert("您还没有选中,请选中后再进行删除");
		}
		//您确定要删除吗?
		if (!confirm("你确定删除吗？")) {
			return;
		}
		//提交表单
		$("#formList")[0].action="/console/brand/deleteByIsDisplay.do?name="+name+"&isDisplay="+isDisplay+"&pageNum="+pageNum+"&pageSize="+pageSize;
		$("#formList").submit();	
	}
	

</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='/console/brand/add.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form  action="/console/brand/list.do" method="get" style="padding-top:5px;">
品牌名称: <input type="text" name="name" value="${name}"/>
	<select name="isDisplay">
		<option value="1" <c:if test="${isDisplay==1 }">selected ="selected"</c:if>>是</option>
		<option value="0" <c:if test="${isDisplay==0 }">selected ="selected"</c:if>>否</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form id="formList" method="post">
<table id="tableList" cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkAllOrNot(this.checked);"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		 <c:forEach items="${page.result }" var="brand" >
			<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox"  name="ids" value="${brand.id }" /></td>
			
			
			<td align="center">${brand.id}</td>
			<td align="center">${brand.name}</td>
			<td align="center"><img width="40" height="40" src="${brand.imgUrl }"/></td>
			<td align="center">${brand.description }</td>
			<td align="center">${brand.sort }</td>
			<td align="center">
			<c:if test="${brand.isDisplay==1 }">是</c:if>
			<c:if test="${brand.isDisplay==0 }">否
			</c:if>
			</td>
			
			<td align="center">
			<a class="pn-opt" href="/console/brand/edit.do?id=${brand.id }">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
		</c:forEach> 
		
	
	</tbody>
</table>

<div class="page pb15">
	<span class="r inb_a page_b">
	
		<!-- 首页条件分页查询 -->
		<a href="/console/brand/list.do?name=${name }&isDisplay=${isDispaly }&pageNum=1"><font size="2">首页</font></a>
		<!-- 上一页条件分页查询 ,如果当前页码小于等于1那么上一页为1-->
		<c:if test="${page.pageNum<=1 }">
			<a href="/console/brand/list.do?name=${name }&isDisplay=${isDispaly }&pageNum=1"><font size="2">上一页</font></a>
		</c:if>
		<!-- 上一页条件分页查询  -->
		<c:if test="${page.pageNum>1 }">
			<a href="/console/brand/list.do?name=${name }&isDisplay=${isDispaly }&pageNum=${page.pageNum-1}"><font size="2">上一页</font></a>
		</c:if>
		<!-- 遍历页码 -->
		<c:forEach begin="1" end="${page.pages }" var="i" step="1" >
			<a href="/console/brand/list.do?name=${name }&isDisplay=${isDispaly }&pageNum=${i}">
			<!-- 如果当前页面和遍历的页码一致,那么则对其加粗 -->
			
			<!-- 如果此处查出1000条数据,如何处理 -->
			<c:if test="${page.pages>10 }">
				
			</c:if>
			
				<c:if test="${page.pageNum==i}">
					<strong>${i }</strong>
				</c:if>
				<!-- 如果当前页码和遍历的页码不一致,那么直接展示 -->
				<c:if test="${page.pageNum!=i}">
					${i }
				</c:if>
			</a>
			
		</c:forEach>
		
		<!-- 下一页分页查询如果页码小于最大页码 -->
		<c:if test="${page.pageNum<page.pages }">
			<a href="/console/brand/list.do?name=${name }&isDisplay=${isDispaly }&pageNum=${page.pageNum+1}"><font size="2">下一页</font></a>
		</c:if>
		<!-- 下一页分页查询 ,如果当前页大于等于最大页码,尾页是最大页码-->
		<c:if test="${page.pageNum>=page.pages }">
			<a href="/console/brand/list.do?name=${name }&isDisplay=${isDispaly }&pageNum=${page.pages}"><font size="2">下一页</font></a>
		</c:if>
		<!-- 尾页分页查询 -->
		<a href="/console/brand/list.do?name=${name }&isDisplay=${isDispaly }&pageNum=${page.pages}"><font size="2">尾页</font></a>
		
	
		
	
		共<var>${page.pages}</var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = '/console/brand/list.do?&amp;pageSize=7&amp;pageNum=' + $('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	</span>
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete('${name}','${isDisplay }','${page.pageNum }','${page.pageSize }');"/></div>
</form>
</div>

</body>
</html>