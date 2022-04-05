<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD연습중</title>
</head>
<body>
	${lists}
	<hr>
	<fieldset>
		<legend>기본 Parameter 처리 DTO/VO</legend>
		<form action="./insertBoardVO.do" method="post">
			<input type="text" name="id" value="GD002">
			<input type="text" name="title" value="꽃이 폈어요">
			<input type="text" name="content" value="오늘도 꽃구경 해봅시다">
			<input type="submit" value="전송">
		</form>
	</fieldset>
		<fieldset>
		<legend>기본 Parameter 처리 Map</legend>
		<form action="./insertBoardMap.do" method="post">
			<input type="text" name="id" value="GD001">
			<input type="text" name="title" value="Map으로 값넘기기">
			<input type="text" name="content" value="Map을 받아주세요">
			<input type="submit" value="전송">
		</form>
	</fieldset>
	
	<fieldset>
		<legend>@RequestParam</legend>
		<p>
			화면에서 요청되는 name값을 변경하여 처리 할 수 있다.
			예를 들어 화면의 name이 pw라고 전송되고 서버사이드에서 password를 필요로 함
			String password = request.getParameter("pw");
		</p>
		<p>
			문제점 <br> 
			화면에서 요청되는 name이 없거나 값이 없다면 null이 발생함 
		</p>
		<form action="./insertBoardRequestParam.do" method="post">
			<input type="text" name="a" value="M001">
			<input type="text" name="b" value="켄타로스">
			<input type="text" name="c" value="아침에는 추워요 건강 조심하세요">
			<input type="submit" value="전송">
		</form>
	</fieldset>
	
	<fieldset>
		<legend>주소값을 Parameter로 처리</legend>
		<form action="./com/min/login/paramValue.do" method="get">
			<input type="submit" value="주소처리 전송">
		</form>
	</fieldset>
	<hr>
	
	<fieldset>
		<legend>Transaction Annotation 처리</legend>
		<form action="./transaction.do" method="post">
			<input type="text" name="id" value="GD001">
			<input type="text" name="title" value="매운갈비찜">
			<input type="text" name="content" value="규철이가 좋아하는 매운 갈비찜">
			<input type="submit" value="전송">
		</form>
	</fieldset>
</body>
</html>