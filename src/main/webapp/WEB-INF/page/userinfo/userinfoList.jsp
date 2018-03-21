<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		
	});
	function addUser(){
		window.location.href = "${pageContext.request.contextPath}/userInfo/addView";
	}
	function deleteUser(id){
		window.location.href = "${pageContext.request.contextPath}/userInfo/delete?id="+id;
	}
	function updateUser(id){
		window.location.href = "${pageContext.request.contextPath}/userInfo/updateView?id="+id;
	}
	
	function getPage(odiv){
		var form = $("<form></form>");
		form.attr("action","${pageContext.request.contextPath}/userInfo/listView");
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
	<div>
		<button onclick="addUser();">添加员工</button>
	</div>
	<table id="usertable">
		<tr>
			<td style="width:70px">ID</td>
			<td style="width:70px">姓名</td>
			<td style="width:70px">电话</td>
			<td style="width:70px">年龄</td>
			<td style="width:70px">员工类型</td>
			<td style="width:70px">地址</td>
			<td style="width:70px">操作</td>
		</tr>
		
		<c:forEach items="${page.result }" var="user">
			<tr>
				<td style="width:70px">${user.id }</td>
				<td style="width:70px">${user.name }</td>
				<td style="width:70px">${user.phone }</td>
				<td style="width:70px">${user.age }</td>
				<td style="width:70px">${user.type==1?'管理员':'用户' }</td>
				<td style="width:70px">${user.address }</td>
				<td style="width:150px">
					<button type="button" onclick="deleteUser(${user.id});">删除</button>
					<!--<button type="button" onclick="updateUser(${user});">修改2</button> -->
					<button type="button" onclick="updateUser(${user.id});">修改</button>
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