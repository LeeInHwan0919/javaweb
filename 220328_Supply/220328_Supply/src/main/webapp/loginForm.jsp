<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/login.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="container">
		<div id="title">Login</div>
		<!--       <form action="./login.do" method="post" name="loginForm"> -->
		<form method="post" name="loginForm">
			<div id="id">아이디</div>
			<input type="text" id="inputId" value="GD001" placeholder="아이디 입력"><br>
			<div id="pw">비밀번호</div>
			<input type="password" id="inputPw" value="GD001"
				placeholder=" 비밀번호 입력"><br>
		</form>
		<div id="btn">
			<input type="button" id="login" value="로그인">
		</div>
	</div>
</body>
<script type="text/javascript">
	//유효서 처리
	window.onload = function(){
		var login = document.getElementById("login");
		login.onclick=function(){
			
			//------------ java scirpt 기본 유효성-- 검사-------------
// 			var id = document.getElementById("inputId");
// 			var pw = document.getElementById("inputPw");
// 			if(id.value == "" || pw.value == ""){
// 				alert('아이디와 비밀번호를 반드시 입력해 주세요');
// 				return;
// 			}else{
// 				var frm = document.forms[0];
// 				frm.submit();
// 			}
//        ==============================================
	
			console.log('로그인 작동');
			var id = document.getElementById("inputId");
			var pw = document.getElementById("inputPw");
			console.log(id.value,pw.value);
			
			var frm = document.loginForm;
			frm.action = "./login.do";
			console.log(frm);
			
			//유효성 검사 
			if(id.value=="" ||id.value.trim()==""){
				alert('아이디를 입력해 주세요');
				id.value=""
				id.focus();
			}else if(pw.value=="" ||pw.value.trim()==""){
				alert('비밀번호를 입력해 주세요');
				pw.value=""
				pw.focus();
			}else{
				$.ajax({
					type:"post",
					url:"./loginCheckText.do",
// 					data:"id="+id.value+"&pw="+pw.value,
					data:{"id":id.value,"pw":pw.value},
					dataType:"json", //json으로 써놓은 경우 알아서 파싱
					success:function(msg){
// 						console.log(msg, typeof msg);//text 값만을 받았을 때 ex)"성공"
						
						// msg가 JSON형태 text형인 경우 json.parse ex){"isc":"테스트"}
// 						var obj = JSON.parse(msg); 
// 						console.log(obj.isc,typeof obj);

// 						console.log(msg.isc,typeof msg);
						console.log(msg.check,typeof msg);
					},
					error:function(){
						alert('잘못된 요청 처리 입니다.');
					}
				});
			}
		}
	}
</script>
</html>