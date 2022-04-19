<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>참여자 목록</legend>
	<div>
		<button onclick="goSocket('S','super')">채팅방 입장하기 그룹(S오일) : 사용자(super)</button>
		<button onclick="goSocket('S','high')">채팅방 입장하기 그룹(S오일) : 사용자(high)</button>
		<button onclick="goSocket('H','super')">채팅방 입장하기 그룹(Hiway) : 사용자(super)</button>
		<button onclick="goSocket('H','top')">채팅방 입장하기 그룹(Hiway) : 사용자(top)</button>
	</div>
</fieldset>
<script type="text/javascript">
	function goSocket(gr_id, mem_id){
		window.open("./socketOpenGr.do?mem_id="+mem_id+"&gr_id="+gr_id,"그룹 채팅","width=450px, height=500px, resizable=none, toolbar=no, menubar=no, left=300px, top=50px");
	}
</script>
</body>
</html>