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
<link rel="stylesheet" href="css/index1.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"></script>
</head>
<body>
<a href="add.jsp" >添加</a>
<table>
<tr>
<td>手机号</td>
<td>邮箱</td>
<td>昵称</td>
<td>年龄</td>
</tr>
<c:forEach items="${list }"  var="li">
<tr>
<td>${li.phone }</td>
<td>${li.email }</td>
<td>${li.nickname }</td>
<td>${li.age }</td>
</tr>
</c:forEach>
</table>
</body>
</html>