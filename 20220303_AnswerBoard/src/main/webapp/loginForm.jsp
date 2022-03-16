<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/loginForm.css"> 
</head>
<body>
	<form action="./boardLogin.do" class="box" method="post">
		<h1>login</h1>
		<input type="text" placeholder="Username" name="id">
		<input type="password" placeholder="Password" name="password">		
		<input type="submit" value="login">		
	</form>
	<a href="./boardPaging.do">boardList페이지 처리 이동</a>
	<a href="./boardJSTL.do">boardListJSTL페이지 처리 이동</a>
</body>
</html>