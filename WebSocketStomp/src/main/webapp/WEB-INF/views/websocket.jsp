<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script type="text/javascript" src="./js/web.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script type="text/javascript">
// function onSendMessage(){
// 	var name1 = $("#name").val()
// 	var name2 = $("#name2").val()
// 	var title = $("#title").val()
// 	var content = $("#content").val()
// 	var msg = "결재,"+name1+","+name2
// 	$.ajax({
// 		url:"./test.do",
// 		data:{"name":name1,"title":title,"content":content},
// 		type:"post",
// 		dataType:"text",
// 		success:function(data){
// 			console.log(msg)
// 			console.log(data)
// 			client.send(msg);
// 		},
// 		error:function(err){
// 			alert(err)
// 		}
// 	})
// }

// function onMessage(event){
// 	console.log(event)
// 	$("#textApp").append(event.data);
// }

</script>
<%-- <jsp:include page="./headers.jsp" flush="true"/> --%>
<style type="text/css">
	#container{
		margin: 0 auto;
		width: 1280px;
		height: 1024px;
		position: relative;
	}
	#textApp{
		border: 1px solid #000000;
		width: 250px;
		height: 60px;
		position: absolute;
		bottom: 0;
		right: 0;
	}
</style>
</head>
<body>
	<div id="container">
	<div>
		<b>발신 </b><br>
		이름 : <input type="text" id="name" readonly value="${name}">
		글 제목 : <input type="text" id="title">
		내용 : <input type="text" id="content">
		<button onclick="onSendMessage()">전송</button>
		<button onclick="onSendApprMessage()">결재전송</button>
	</div>
	<hr>
	<div>
		<b>수신 </b>
		<input type="text" id="name2">
	</div>
	<div id="sliceDiv">
	</div>
	<button onclick="sliceD()">웹소켓 생성</button>
	<button onclick="connect()">구독</button>
	<button onclick="disconn()">통신 제거</button>
	<button onclick="location.href='./comp.do'">결재하기</button>
	<div id="textApp" style="display:none;"></div>
	</div>
</body>
</html>