<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글작성 폼</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
</head>


<%@ include file ="./header.jsp" %>

<body>
	<div class="container">
  <h2>게시글 새글 입력</h2>
  <hr>
  <form class="boardInForm" method="post" action="./boardInsert.do">
  <div class="form-group">
      <label for="id">작성자 아이디:</label>
      <h4 id="id"><%=loginInfo.getId() %></h4>
    </div>
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" name="title">
    </div>
    <div class="form-group">
      <label for="content">내용:</label>
      <textarea class="form-control" rows="5" id="content" name="content"></textarea>
    </div>
    <button type="submit" class="btn btn-default">입력</button>
    <button type="button" class="btn btn-default">취소</button>
  </form>
</div>
</body>
<%@ include file ="./footer.jsp" %>
</html>