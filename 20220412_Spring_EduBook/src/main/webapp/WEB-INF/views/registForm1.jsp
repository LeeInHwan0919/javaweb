<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
	function duplicateId(){
		var url = "./duplicateId.do";
		var title = "아이디 중복검사";
		var attr = "width=500px, height=300px";
		window.open(url, title, attr);
	}
	
	function returnView(){
		location.href="./main.do";
	}
	
</script>
<body>
	<form action="./regist.do" method="post" onsubmit="return checkPassword()">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" readonly>
				</td>
				<td>
					<input type="button" value="중복확인" onclick="duplicateId()">
				</td>
			</tr>
			<tr>
				<th>성명</th>
				<td colspan="2">
					<input type="text" id="name">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td colspan="2">
					<input type="password" id="password">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td colspan="2">
					<input type="password" id="passwordChk">
				</td>
			</tr>
			<tr>
				<th colspan="3">
					<input type="submit" value="가입">
					<input type="button" value="취소" onclick="returnView()">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>