<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음화면</title>
</head>
<body>
	<div style="width:300px; margin: 100px auto; border: 2px solid tomato;">
		<form action="./info.do" method="post">
			이름 : <input type="text" name="name"><br>
			나이 : <input type="number" name="age"><br>
			<input type="submit" value="전송">
		</form>
		
		<h2><a href="./home.do">home으로 이동</a></h2>
	</div>
</body>
</html>