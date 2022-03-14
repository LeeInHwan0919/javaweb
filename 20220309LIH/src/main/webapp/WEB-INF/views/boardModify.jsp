<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 폼</title>
</head>
<%@ include file ="./header.jsp" %>
<body>
<form class="modifyBoard" method="post" action="./boardModify.do">

    <div class="form-group">
      <label for="content">내용:</label>
      <textarea class="form-control" rows="5" id="content" name="content"></textarea>
    </div>
    <button type="submit" class="btn btn-default">입력</button>
    <button type="button" class="btn btn-default">취소</button>
  </form>
</body>
</body>
<%@ include file ="./footer.jsp" %>
</html>