<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 채팅</title>

<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
	body{
		padding:0px;
		 font-family: 'Jeju Gothic', sans-serif;
	}
	table{
		border: 1px solid #4b4b4b;
		border-collapse: collapse;
	}
	.receive_msg{
		padding: 3px;
		width: 350px;
		height: 400px;
		overflow: auto;
		overflow-x:hidden;
		background: #f3f3f3;
	}
	.listTitle{
		height: 50px;
		vertical-align: top;
		font-size: 12px;
		font-weight: bold;
	}
	.memList{
		vertical-align: top;
	}
	.chat{
		width: 350px;
		height: 35px;
		padding: 5px;
		float: left;
		margin-top:  10px;
		margin-left:  5px;
		resize: none;
		border: 0.5px solid #f3f3f3;
	}
	.chat:focus{
		outline: none;
	}
	
	.chat_btn{
		margin-top: 0px;
		margin-left: 5px;
		width: 55px;
		height: 30px;
		background-image:url("./img/send.png");
		background-size:100% 100%;
		display: inline-block;
	}
	.memListBox{
		text-align: center;
		vertical-align: text-top;
		padding: 10px;
		overflow: auto;
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body onbeforeunload="roomClose()">
	<img alt="그림" src="./img/user.png"><br>
	<input type="text" id="nickName" value="${mem_id}">
	<table>
		<tr>
			<td width="300px" height="400px" align="center">
				<div class="receive_msg" style="border: 1px">
				<div class="last"></div>
				<input type="text" id="nickName" value="${mem_id}">
				</div>
			</td>
			<td width="130px" class="memListBox">
				<div class="listTitle">접속자 목록</div>
				<div class="memList"></div>
			</td>
		</tr>
	</table>
	
	<div class="chat_div" style="display: none; margin-top: 10px;">
		<textarea class="chat" onkeypress="if(event.keyCode=13)$('.chat_btn').click()"></textarea>
		<div class="chat_btn"></div>
	</div>
</body>

<script type="text/javascript">
	var ws = null;
	var url = null;
	var nick = null;
	
	$(document).ready(function(){
		
		console.log("------------:"+"${gr_id}")
		
		nick = $("#nickName").val();
		$(".receive_msg").html("");
		$(".chat_div").show("");
		$(".chat").focus("");
		
		ws = new WebSocket("ws://localhost:8090/20220412_Spring_EduBook/wsChatGr.do");
		
		ws.onopen = function(){
			console.log("nickName"+nick);
			ws.send("#$nick_"+nick);
		};
		
		ws.onmessage=function(event){
			var msg = event.data;
			var id = "${gr_id}";
			if(msg.startsWith("<font color=")){ //입장, 퇴장
				$(".receive_msg").append($("<div class='noticeTxt'>")).append(msg+"<br>");
				viewList(gr_id);
			}else if(msg.startsWith("[나]")){ //대화내용
				msg=msg.substring(3);
				$(".receive_msg").append($("<div class='sendTxt'>").append($("<span class='send_img'>").text(msg))).append("<br><br>");
			}else{
				$(".receive_msg").append($("<div class='receiveTxt'>").append($("<span class='receiver_img'>").text(msg))).append("<br><br>");
			}
			
			$(".receive_msg").scrollTop($(".receive_msg")[0].scrollHeight); //위로만 올라가도록 scroll 설정
			
		};
		
		ws.onclose=function(event){
			alert("채팅방이 삭제됩니다");
		};
		
		$(".chat_btn").bind("click",function(){
			if($(".chat").val()==''){
				alert("내용을 입력해주세요");
			}else{
				ws.send(nick+":"+$(".chat").val());
				$(".chat").val("");
				$(".chat").focus();
			}
		});
		
		function roomClose(){
			alert("채팅종료");
			$.ajax({
				type:"GET",
				url:"./socketOut.do",
				async:false,
				
			});
		}
		
		function disconnection(){
			ws.close();
			ws = null;
		}
		
		function viewList(grId){
			
		}
		
		
		
		
	});
	
</script>
</html>