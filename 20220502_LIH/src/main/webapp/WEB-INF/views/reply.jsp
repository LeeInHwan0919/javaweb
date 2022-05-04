<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 달기</title>
<style type="text/css">
  .container{
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
  }
</style>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<form action="./reply.do" method="post">
	<div class="container">
		<div class="form-group">
			<label for="title">답글 제목:</label> 
			<input type="text" class="form-control" id="title" name="title" value="답글의 제목을 입력하세요" required="required">
		</div>
		<div class="form-group">
			<label for="content">답글 내용:</label>
			<textarea class="form-control" rows="7" id="content" name="content" required="required">답글의 내용을 입력하세요.</textarea>
		</div>
		<input type="hidden" name="id" id="id" value="${member.id}">
		<input type="hidden" value="${seq}" name="seq">
		<div>
		  <input class="btn btn-success" type="submit" value="답글 입력">
		  <input class="btn btn-primary" type="button" value="취소" onclick="javascript:history.back(-1)">
		</div>
	</div>
	</form>
</body>
</html>