<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/userInfo/add" method="post" id="addForm">
		姓名：<input name="name" type="text"/>
		手机号：<input name="phone" type="text"/>
		年龄：<input name="age" type="text"/>
		类型：<select name="type">
			<option value="1">管理员</option>
			<option value="2">用户</option>
		</select>
		地址:<input name="address" type="text"/>
		<div>
			<input type="submit" value="提交"/>
		</div>
	</form>
</body>
</html>