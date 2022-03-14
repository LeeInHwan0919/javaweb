<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<style>
.form-control{
width:300px
}
</style>
<%@ include file ="./header.jsp" %>
<body>
	<form class="signUpForm" method="post" action="./signUp.do">
    <div class="form-group">
    
    <h1>회원가입</h1>
    <p>회원가입을 위한 필요한 정보를 입력해 주세요.</p>
    <hr>

    <label for="userId"><b>아이디</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" class="form-control" placeholder="아이디를 입력해 주세요." name="userId" required>
<hr>
    <label for="userPw"><b>비밀번호</b></label>&nbsp;&nbsp;&nbsp;
    <input type="password" class="form-control" placeholder="비밀번호를 입력해 주세요." name="userPw" required>
<hr>
    <label for="userName"><b>이름</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" class="form-control" placeholder="이름을 입력해 주세요." name="userName" required>
    
    <hr>
  	<input class="signUpBtn" type="submit" value="가입하기">

	</div>
    
    
  </form>
</body>
<%@ include file ="./footer.jsp" %>
</html>