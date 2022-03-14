<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형 게시판 처음페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
</head>
<%@include file="./WEB-INF/views/header.jsp" %>
<body>
<hr>
	<form class="loginForm" method="post" action="./login.do">
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="id" class="form-control" id="id" placeholder="아이디를 입력해 주세요." name="userId" style="width: 400px;">
    </div>
    <div class="form-group">
      <label for="pw">비밀번호:</label>
      <input type="password" class="form-control" id="pw" placeholder="비밀번호를 입력해 주세요." name="userPw" style="width: 400px;">
    </div>
    
    <button type="submit" class="btn btn-default">로그인</button>
    <button type="button" class="btn btn-default" onclick = "location = './signUp.do'">회원가입</button>
</div>
  </form>
	
	
</body>
<%@ include file="./WEB-INF/views/footer.jsp" %>
</html>
 