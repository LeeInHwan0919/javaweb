<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css"/>
<link rel="stylesheet" type="text/css" href="./css/login.css"> 

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript">
  function loginCheck(){
	  console.log("로그인 작동")
	  var id = document.getElementById("inputId");
	  var pw = document.getElementById("inputPw");
	  console.log(id.value,pw.value);
	  
	  var frm = document.forms[0];
	  frm.action = "./login.do";
	  console.log(frm);
	  
	  //유효성 검사 후 ajax 로그인
	  if(id.value==""||id.value.trim()==""){
		  id.value="";
		  id.focus();
		  swal("로그인","아이디를 입력해 주세요");
	  }else if(pw.value==""||pw.value.trim()==""){
		  pw.value="";
		  pw.focus();
		  swal("로그인","패스워드를 입력해 주세요");
	  }else{
		$.ajax({
// 			url:"./loginCheckText.do", //반환되는 값을 text로 처리
			url:"./loginCheckMap.do", //반환되는 값을 Map to JSON으로 처리
			type:"post",
			data:"id="+id.value+"&pw="+pw.value,
			success:function(msg){
				console.log(msg,typeof msg);//형태확인
				if(msg.isc == "성공"){
				console.log(msg.isc);
				frm.submit();
				}else{
					swal("로그인","해당 사용자는 존재하지 않습니다.")
				}
			},
			error:function(){
				swal("로그인","로그인에 장애가 발생 ");
			}	
			
			
		
		}); 
	  }
  }
</script>
</head>
<body>
  <fieldset>
    <legend>${mem2}</legend>
  </fieldset>
  <div id="container">
  <div id="title">Spring Single Page</div>
    <form method="post">
		<div class="inputWord">아 이 디</div>
		<input type="text" name="id" id="inputId" placeholder="아이디 입력" value="GD002"><br>
		
		<div class="inputWord">비밀번호</div>
		<input type="text"  name="pw" id="inputPw" placeholder="비밀번호 입력" value="1234" onkeyup="enterKey()"><br>
		
		<div style="text-align:center">
		  <input type="button" id="login" name="login" value="LOGIN" onclick="loginCheck()">
		</div>
		
		<div id="bottom">
		  <input type="button" id="signup" value="회원가입">
		  <input type="button" value="아이디 찾기">
		  <input type="button" value="비밀번호 찾기">
		</div>		
		<script type="text/javascript">
      function enterKey() {
         if(window.event.keyCode==13){
            loginCheck();
         }
      }
      
      window.onload = function () {
         document.getElementById("signup").onclick=function (){
            console.log("회원가입");
            location.href="./signup.do";
         }
      }
   </script>
    </form>
  </div>
</body>
</html>