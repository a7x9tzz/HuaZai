<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		
	});
	function addFood(){
		window.location.href = "${pageContext.request.contextPath}/menu/addView";
	}
	function deleteFood(id){
		window.location.href = "${pageContext.request.contextPath}/menu/delete?id="+id;
	}
	function updateFood(id){
		window.location.href = "${pageContext.request.contextPath}/menu/updateView?id="+id;
	}
	
	function getPage(odiv){
		var form = $("<form></form>");
		form.attr("action","${pageContext.request.contextPath}/menu/listMenu");
		form.attr("method","post");
		//var pagenum = $(odiv).html();
		var temp = $("<input type='hidden' name='currentPage' value='"+odiv+"'>");
		form.append(temp);
		form.appendTo("body");
		form.css("display","none");
		form.submit();
	}
</script>
</head>
<body>
	<h1 align="center">感谢小雨哥哥的大力指导!</h1>
	<hr>
	<div>
		<button onclick="addFood();">添加</button>
	</div>
	<table id="menutable">
		<tr>
			<td style="width:80px">ID</td>
			<td style="width:80px">菜名</td>
			<td style="width:80px">风格</td>
			<td style="width:80px">价格</td>
			
		</tr>
		
		<c:forEach items="${page.result }" var="menu">
			<tr>
				<td style="width:80px">${menu.id }</td>
				<td style="width:80px">${menu.name }</td>
				<td style="width:80px">${menu.style==1?'不辣':'辣' }</td>
				<td style="width:80px">${menu.price }</td>
				<td style="width:150px">
					<button type="button" onclick="deleteFood(${menu.id});">删除</button>
					<!--<button type="button" onclick="updateUser(${user});">修改2</button> -->
					<button type="button" onclick="updateFood(${menu.id});">修改</button>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<c:choose>
		<c:when test="${page.totalPage == 0 }">
			 <button>1</button>
		</c:when>
		<c:otherwise>
			<c:forEach var="i" begin="1" end="${page.totalPage }">
				<c:choose>
					<c:when test="${page.currentPage == i }">
					<button style="color:red" onclick="getPage(this);">${i }</button>
					</c:when>
					<c:otherwise>
						<button onclick="getPage(${i});" >${i }</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>