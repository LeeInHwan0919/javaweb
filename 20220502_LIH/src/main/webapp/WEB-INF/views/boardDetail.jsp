<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
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
	<div class="container">
	<h3>게시글 상세보기</h3>
		<div class="form-group">
			<label for="name">작성자 아이디:</label> 
			<input type="text" class="form-control" id="id" name="id" value="${list.id}" readonly>
		</div>
		<div class="form-group">
			<label for="title">제목:</label> 
			<input type="text" class="form-control" id="title" name="title" value="${list.title}" readonly>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" rows="7" id="content" name="content" readonly>${list.content}</textarea>
		</div>
		<input type="hidden" name="seq" id="seq" value="${list.seq}">
		<div>
		  <input class="btn btn-success" type="button" value="답글" onclick="replyBoard()">
		  <c:if test="${member.id eq list.id}">
		    <input class="btn btn-primary" type="button" value="수정" onclick="updateBoard()">
		    <input class="btn btn-danger" type="button" value="삭제" onclick="deleteBoard()">
		  </c:if>
		  <input class="btn btn-primary" type="button" value="취소" onclick="javascript:history.back(-1)">
		</div>
	</div>
	<script type="text/javascript">
		function replyBoard(){
			console.log(${list.seq});
			var seq = ${list.seq};
			location.href="./reply.do?seq="+seq;
		}
		
		function updateBoard(){
			console.log(${list.seq});
			var seq = ${list.seq};
			location.href="./updateBoard.do?seq="+seq;
		}
		
		function deleteBoard(){
			console.log(${list.seq});
			location.href="./Delete.do";
		}
	</script>
</body>
</html>