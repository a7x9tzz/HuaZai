<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/userInfo/update" method="post" id="updateForm">
		姓名：<input name="name" type="text" value=${user.name}></input>
	           手机号：<input name="phone" type="text" value=${user.phone}></input>
		年龄：<input name="age" type="text" value=${user.age}></input>
		<c:choose>
			<c:when test="${user.type}==1">
		类型：<select name="type">
			<option value="1" selected>管理员</option>
			<option value="2">用户</option>
		   </select>
			</c:when>
		 
		  <c:otherwise>
		类型：<select name="type">
			<option value="1">管理员</option>
			<option value="2" selected>用户</option>
		   </select>
		  </c:otherwise> 
	
		</c:choose>
		地址:<input name="address" type="text" value=${user.address}></input>
		<div>
			<input type="submit" value="保存"/>
		</div>
	</form>
</body>
</html>