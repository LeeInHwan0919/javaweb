<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home화면</title>
</head>
<body>
	<fieldset>
		<legend>처리 방식에 따른 Controller연습</legend>
		<ul>
			<li>home Get방식 호출<br>
				<a href="./home.do?name=banana">home Get 호출</a>
			</li>
			<li>home Post방식 호출
				<form action="./home.do" method="post">
					<input type="text" name="name" value="tomato">
					<input type="submit" value="POST전송">
				</form>
			</li>
		</ul>
	</fieldset>
	<hr>
	<h3>전달값</h3>
		model 전달 : ${requestScope.str}<br>
		request전달 : ${requestcope.req_str}<br>
	<hr>
	<a href="./selectBoard.do">게시글 전체보기</a>
	<a href="./user/logout.do">컨트롤러 요청하기</a>
</body>
</html>