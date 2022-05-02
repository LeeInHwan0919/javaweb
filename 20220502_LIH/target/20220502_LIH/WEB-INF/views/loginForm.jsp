<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
  .container{
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
  }
</style>
</head>
<body>
<div class="container">
  <h2>로그인</h2>
  <form action="./login.do" method="post">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" value="USER" name="id">
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" value="1234" name="pw">
    </div>
    <input type="submit" class="btn btn-success" value="로그인">
  </form>
    <button class="btn btn-primary" onclick="signUp()" id="signUp">회원가입</button>
    <input type="button" class="btn btn-primary" value="아이디찾기" id="findID">
    <input type="button" class="btn btn-primary" value="비밀번호찾기" id="findPW">
</div>
<script type="text/javascript">
window.onload = function(){
	
	document.getElementById("findID").onclick = function(){
		console.log("findID클릭");
		location.href="./findIdForm.do";
	}
	
	document.getElementById("findPW").onclick = function(){
		console.log("findPW클릭");
		location.href="./findPwForm.do";
	}
}
 
function signUp(){
	location.href="./signUpForm.do";
}
</script>
</body>
</html>