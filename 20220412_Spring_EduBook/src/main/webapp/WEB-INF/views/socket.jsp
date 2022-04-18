<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모두 다 채팅</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	var ws = null; //웹소켓 객체
	var url = null; //웹소켓 주소
	var nick = null; //대화명
	
	$(document).ready(function(){
		console.log("채팅 동작 되니?");
		$("#nickName").focus(); //사용자가 대화명 입력하라고 시키는 무언의 압박
		
		$("#join_room").bind('click',function(){
			console.log("닉네임 입력");
			if($("#nickName").val()==""){
				alert("닉네임을 입력해 주세요");
				$("#nickName").focus();
				return;
			}
			nick = $("#nickName").val(); //대화창에서 입력받은 닉네임 -> server side로 전송하여 (Map<WebsocketSession, nickName>)
			console.log(nick);
			
			$("#resive_msg").html("");
			$("#chat_div").show();
			$("#chat").focus();
			
			//웹소켓의 객체를 생성하여 Spring bean으로 작성 (wsChat.do)
			//afterConnectionEstablish -> ArrayList<WebSoketSession>에 참여하는 대상의 session을 담아 줌
			ws = new WebSocket("ws://localhost:8090/20220412_Spring_EduBook/wsChat.do");
			console.log(ws, typeof ws);
			
			//웹소켓을 open 한 후 send()를 통해서 서버에 text를 전송함 -> handleTextMessage -> Session Map
			ws.onopen=function(){
				console.log("웹소켓 객체 open");
				ws.send("#&nick_"+nick);
			}
			ws.onmessage = function(event){
				$("#resive_msg").append(event.data+"<br>");
			}
			
			ws.onclose = function(){
				alert("서버와 연결이 종료되었습니다");
			}
			
			
		});
		
		$("#chat_btn").bind("click",function(){
			console.log("대화내용 전달");
			if($("#chat").val()==""){
				alert("대화내용을 입력해 주세요");
				return;
			}else{
				ws.send("["+nick+"]"+$("#chat").val());
				$("#chat").val("");
				$("#chat").focus();
			}
		});
	});
	
	function disconnection(){
		ws.close();
		ws = null;
		window.close();
	}
	
	window.onbeforeunload = function(){
		ws.close();
		ws = null;
	}
	document.getElementsByTagName('button')[0].innerHTML="STOP";
	
</script>
</head>
<body>
	<button onclick="disconnection()">연결종료</button>
	<table border="1">
		<tr>
			<td width="500px" height="500px" align="center">
				<div id="resive_msg" style="border: 1px;">
					<input type="text" id="nickName" style="width: 200px" height="25px" onkeypress="if(event.keyCode==13)$('#join_room').click()">
					<input type="button" value="대화입장" id="join_room">
				</div>
			</td>
		</tr>
	</table>
	<hr>
	<div id="chat_div" style="display: none;">
		<input type="text" id="chat" style="width: 450px;" onkeypress="if(event.keyCode==13)$('#chat_btn').click()">
		<input type="button" id="chat_btn" value="엔터">
	</div>
</body>
</html>