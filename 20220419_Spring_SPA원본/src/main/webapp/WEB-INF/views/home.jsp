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
<p>
  <a href="./loginForm.do">처음페이지</a>
</p>
<fieldset>
  <legend>회원관리테스트</legend>
  <div>
    <ol>
      <li><a href="./memberList.do">회원전체조회</a></li>
      <li>
        <b>회원가입</b><br>
        <form action="./signup.do" method="post">
          <input type="text" name="id">
          <input type="text" name="pw">
          <input type="submit" value="가입테스트">
        </form>
      </li>
      <li><a href="./idCheck.do?id=GD001">ID중복체크</a></li>
      <li><a href="./login.do?id=GD008&pw=1234">로그인</a></li>
      <li><a href="./pwCheck.do?id=GD001">비밀번호확인</a></li>
      <li><a href="./idLogin.do?id=GD001">아이디로그인</a></li>
    </ol>
  </div>
</fieldset>
</body>
</html>
