<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>글상세정보</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
			<h1>게시글 상세</h1>
			<h3>필수 값을 입력해 주세요</h3>
			<div>
				<div class="form-control">아이디 : ${vo.id}</div>
				<div class="form-control">제목 : ${vo.title }</div>
				<div class="form-control">내용 : ${vo.content }</div>
				<div class="form-control">작성일 : ${vo.regdate }</div>
			</div>
			<div>
				<input class="btn btn-primary" type="button" value="삭제" onclick="deleteOne()">
				<input class="btn btn-success" type="button" value="수정" onclick="">
				<input class="btn btn-danger" type="button" value="답글" onclick="answerBoardOne()">
			</div>
	</div>
	<script type="text/javascript">
		function deleteOne(){
			console.log(${vo.seq});
			var seq = ${vo.seq};
			location.href='./multiDel.do?chkVal='+seq;
		}
		
		function answerBoardOne(){
			var seq = ${vo.seq};
			location.href='./replyInsert.do?chkVal='+seq;
		}
	</script>
	
</body>
</html>



