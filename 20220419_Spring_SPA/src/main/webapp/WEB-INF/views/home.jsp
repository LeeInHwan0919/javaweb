<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<fieldset>
  <legend>회원관리 TEST</legend>
  <div>
    <ol>
      <li><a href="./memberList.do">회원전체조회</a></li>
      <li>
        <b>회원가입</b><br>
        <form action="./signUp.do" method="post">
          <input type="text" name="id">
          <input type="text" name="pw">
          <input type="submit" value="가입테스트">
        </form>
      </li>
      <li><a href="./idCheck.do?id=GD004">ID중복체크</a></li>
      <li><a href="./login.do?id=GD002&pw=1234">로그인</a></li>
      <li><a href="./pwCheck.do?id=GD004">비밀번호 확인</a></li>
      <li><a href="./idLogin.do?id=GD004">아이디로그인</a></li>
    </ol>
  </div>
</fieldset>
</body>
</html>
