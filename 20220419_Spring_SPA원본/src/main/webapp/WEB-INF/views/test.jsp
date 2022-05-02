<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 테스트 결과 페이지</title>
</head>
<body>
	<fieldset>
	  <legend>회원관리 결과</legend>
	  <ol>
	  	<li>memberList.do : 회원 전체조회 : ${memLists}</li>
		<li>signup.do : 회원가입 ${isc}</li>
		<li>idCheck.do : ID 중복체크</li>
		<li>login.do : 로그인 ${sessionScope.mem} / ${requestScope.mem}/ ${sessionScope.mem2}</li>
		<li>pwCheck.do : 비밀번호 확인</li>
		<li>idLogin.do : 아이디로그인</li>
		<li><a href="./logout.do">logout.do : 로그아웃</a></li>
	  </ol>
	</fieldset>
</body>
</html>