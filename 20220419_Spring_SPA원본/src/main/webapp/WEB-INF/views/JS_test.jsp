<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<span id="testRow"></span>
	
	<div id="test">유준상</div>
</body>
<script type="text/javascript">
	var test = document.getElementById("test").textContent;
	console.log(test);

	window.onload = function(){
	$.ajax({
		url:"./test.do",
		method:"post",
		data:
			{"test":test}
		,
		dataType:"text",
		success:function(msg){
			console.log(msg);
			alert(msg);
		},
		error:function(err){
			alert("통신 실패"+err.message+err.status);
		}
	})
	}
</script>
</html>