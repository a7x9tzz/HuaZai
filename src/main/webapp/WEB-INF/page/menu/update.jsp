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
		菜名：<input name="name" type="text" value=${menu.name}></input>
	          
		<c:choose>
		
			<c:when test="${menu.style}==1">
		风格：<input type="radio" name="style" value="1" checked>不辣
			<input type="radio" name="style" value="2">辣
			</c:when>
		 
		  <c:otherwise>
		风格：<input type="radio" name="style" value="1">不辣
			<input type="radio" name="style" value="2" checked>辣
		  </c:otherwise> 
	
		</c:choose>
		价格:<input name="price" type="text" value=${menu.price}></input>
		<div>
			<input type="submit" value="保存"/>
		</div>
	</form>
</body>
</html>