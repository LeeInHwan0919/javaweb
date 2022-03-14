<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글작성 폼</title>
</head>
<%@ include file ="./header.jsp" %>
<body>
<h2>답글 작성</h2>
<hr>
<form class="boardInForm" method="post" action="./boardAnswer.do">

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
</body>
<%@ include file ="./footer.jsp" %>
</html>