<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
var client;
var susin;
var barsin;
function sliceD(){
	$("#textApp").hide();
	var ws = new SockJS("/WebSocketStomp/stompSocket")
	console.log(ws)
	client = Stomp.over(ws)
	console.log("stomp : "+client);
// 	barsin = $("#name").val()
// 	susin = $("#name2").val()
// 	makeSession();
	client.connect({},function(frame){
		console.log(ws._transport.url); 
// 		urlAjax(ws._transport.url);
	console.log("연결"+frame);
	client.subscribe('/sub/entr', function(alm){
		var hel = JSON.parse(alm.body);
		console.log(hel)
		console.log(hel.name)
		$("#textApp").text("주요 공지사항이 등록되었습니다. 공지게시판을 확인해주세요");
		$("#textApp").slideDown();
		$("#textApp").delay(2000).slideUp();
	})
	
	client.subscribe('/sub/approval/김우연', function(text){
		console.log(text.body)
		$("#textApp").text(text.body+" 님이 결재를 요청하였습니다.")
		$("#textApp").slideDown();
		$("#textApp").delay(2000).slideUp();
	})
	
	client.subscribe('/sub/Comp/김우연',function(){
		console.log(text.body)
		$("#textApp").text("결재가 반려되었습니다.")
		$("#textApp").slideDown();
		$("#textApp").delay(2000).slideUp();
	})
})
// 	client.onopen = onOpen;
// 	client.onmessage = onMessage;
// 	client.onclose = disconn;
}


// function urlAjax(url){
// 	console.log("#####"+url)
// 	$.ajax({
// 		url:"./urlAjax.do",
// 		type:"post",
// 		data:{"url":url,"name":barsin},
// 		success:function(msg){
// 			console.log(msg)
// 			console.log("url 보내기 성공")
// 		},
// 		error:function(err){
// 			console.log("오류",err.status)
// 		}
// 	})
// }

function onSendMessage(){
	client.send("/pub/login",{},JSON.stringify({susin:susin}))
}

function onSendApprMessage(){
	client.send("/pub/apprMem/"+susin,{},JSON.stringify({barsin:barsin,susin:susin}));
}

function onSendCompMessage(){
	client.send("/pub/Comp/"+susin,{},JSON.stringify({barsin:barsin,susin:susin}));
}

function disconn(){
	if(client != null){
	console.log("연결종료")
		client.send("/pub/logout",{},JSON.stringify({barsin:barsin}))
		client.disconnect();
	}
}

// function makeSession(){
// 	let name = $("#name").val();
// 	$.ajax({
// 		url:"./makeSession.do",
// 		type:"post",
// 		data:{'name':name},
// 		success:function(msg){
// 			console.log("세션 생성")
// 		},
// 		error:function(){
// 			console.log("통신 실패")
// 		}
// 	})
// }

function onOpen(){
	console.log("오픈합니다.");
	
}
</script>
</head>
<body>
</body>
</html>