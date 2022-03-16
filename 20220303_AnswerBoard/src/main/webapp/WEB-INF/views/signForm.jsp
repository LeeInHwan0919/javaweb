<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<%@include file="./header.jsp" %>
<body>

<form action="./sign.do" method="post" >
  <div id="container" style="width: 70%; margin:40px 30%;">
    <label for="uid"><b>아이디</b></label>
    <input type="text" placeholder="영어 또는 숫자만 5~10자리 입력해 주세요" name="id" required>

    <label for="psw"><b>패스워드</b></label>
    <input type="password"  placeholder="영어 또는 숫자만 8~15자리 입력해 주세요. 특수문자 제외" name="password" required>
        
    <label for="nm"><b>이름</b></label>
    <input type="text"  placeholder="이름 입력" name="name" required>
 
    <button type="submit" id="btnsign">sign up</button>
  </div>
</form>

</body>
<%@include file="./footer.jsp" %>
</html>
