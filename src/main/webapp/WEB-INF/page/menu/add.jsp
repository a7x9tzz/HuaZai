<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#me").blur(function(){
			if($("#me").val()==""){
				alert("菜名不能为空");
			}
		});
		
		/*$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/menu/test",
			data : JSON.stringify({"id":23,"name":"huazai","age":23,"sexy":"sfds"}),
			contentType : "application/json",
			success : function(res){
				alert(res);
			},
			error : function(e){
				alert("sjfowsjfeow");
			}
		});*/
		var str=$("#me").val();
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/menu/conflict",
			data:JSON.stringify({'"name":'+"str"}),
			contentType:"application/json",
			success:function(result){
				if(result!=0){
				$("#repeat").html("菜名不能重复");	
				}
			}
		});
		
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/menu/add" method="post" id="addForm">
		菜名：<input name="name" id="me" type="text"/><span id="repeat"></span><br/>
		风格:<input type="radio" name="style" value="1" checked>不辣
			<input type="radio" name="style" value="2">辣<br/>
		价格:<input name="price" type="text"/>
		<div>
			<input type="submit" value="提交"/>
		</div>
	</form>
</body>
</html>