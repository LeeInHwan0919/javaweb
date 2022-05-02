<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
<div class="container">
  <h2>아이디 찾기</h2>
  <form action="./findID.do" method="post">
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" value="홍길동" name="name">
    </div>
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="text" class="form-control" id="email" value="abcd@naver.com" name="email">
    </div>
    <input type="submit" class="btn btn-success" value="아이디 찾기">
    <input type="button" class="btn btn-primary" value="취소" onclick="javascript:history.back(-1)">
  </form>
</div>
</body>
</html>