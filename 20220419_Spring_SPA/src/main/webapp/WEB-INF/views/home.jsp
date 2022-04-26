<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>회원 관리 테스트</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<p>
	<a href="./loginForm.do">처음 페이지</a>
</p>
<fieldset>
	<legend>회원 관리 TEST</legend>
	<div>
		<ol>
			<li><a href="./memberList.do ">회원 전체 조회</a></li>
			<li>
				<b>회원 가입</b><br>
				<form action="signup.do" method="post">
					<input type="text" name="id">
					<input type="text" name="pw">
					<input type="submit" value="가입테스트">
				</form>
			</li>
			<li><a href="./idCheck.do?id=GD009">ID 중복체크</a></li>
			<li><a href="./login.do?id=GD009&pw=GD009">로그인</a></li>
			<li><a href="./pwCheck.do?id=GD009">비밀번호 확인</a></li>
			<li><a href="./idLogin.do?id=GD009">아이디 로그인</a></li>
		</ol>
	</div>
</fieldset>
</body>
</html>
