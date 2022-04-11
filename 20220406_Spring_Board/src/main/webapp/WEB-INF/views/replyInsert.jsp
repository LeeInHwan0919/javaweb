<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>답글 작성 폼</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
부모의 SEQ값 : ${param.chkVal}
<div class="container">
  <h2>답글 입력폼입니다.</h2>
  <form action="./replyInsert.do" method="post">
    <input type="hidden" value="${param.chkVal}" name="seq">
    <div class="form-group">
      <label for="id">작성자:</label>
      <input type="text" class="form-control" id="id" name="id" value="${sessionScope.loginVo.id}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" name="title">
    </div>
    <div class="form-group">
      <label for="content">내용:</label>
      <textarea class="form-control" rows="5" id="content" name="content"></textarea>
    </div>
    <div>
      <input class ="btn btn-primary"  type="submit" value="답글입력">
      <input class ="btn btn-success"  type="reset" value="초기화">
      <input class ="btn btn-danger"  type="button" value="취소"  onclick="javascript:history.back(-1)">
    </div>
  </form>
</div>
</body>
</html>