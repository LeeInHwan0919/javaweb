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
		<legend>회원 관리 결과</legend>
			<ol>
				<li>회원전체조회  : memberList.do : ${memLists}</li>
				<li>회원가입         : signup.do : ${isc}</li>
				<li>ID 중복체크    : idCheck.do</li>
				<li>로그인            : login.do : ${sessionScope.mem} / ${requestScope.mem} / ${sessionScope.mem2}</li>
				<li>비밀번호 확인 : pwCheck.do</li>    
				<li>아이디 로그인 : idLogin.do</li>
				<li><a href="./logout.do">로그아웃        : logout.do</a></li>
			</ol>
	</fieldset>
</body>
</html>