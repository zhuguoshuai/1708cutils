<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fomt" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index3.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$("input[value='添加']").click(function(){
		var data=$("form").serialize();
		$.post("add",data,function(obj){
			if(obj){
				alert("添加成功");
				location.href="list";
			}else{
				alert("添加失败");
			}
		},"json");
	});
 
});
</script>
</head>
<body>
<form  >
手机号<input type="text" name="phone" ><br>
邮箱<input type="text" name="email" ><br>
昵称<input type="text" name="nickname" ><br>
年龄<input type="text" name="age" ><br>
<input type="button" value="添加" >  <br>
</form>
</body>
</html>