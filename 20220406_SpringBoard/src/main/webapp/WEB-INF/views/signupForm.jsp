<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입 정보 입력</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function duplication(){
    	console.log("중복체크확인");
    	window.open("./duplication.do","중복검사","width=500px, height=500px");  
    }
  </script>
</head>
<body>
  <div class="container">
      <form action="./signupForm.do" method="post">
      <h1>회원가입</h1>
      <h3>필수 값을 입력해 주세요</h3>
      <div>
        <input class="form-control" type="text" id="name" name="name" placeholder="이름작성">
        <input class="form-control" type="text" id="id" name="id" placeholder="아이디 작성(클릭시 중복 체크 화면으로 이동)" maxlength="10" onclick="duplication()">
        <span id="result"></span>
        <input class="form-control" type="password" id="pw" name="password" placeholder="비밀번호 작성">
        <input class="form-control" type="password" id="pwOk" placeholder="비밀번호 확인">
        <input class="form-control" type="text" id="email" name="email" placeholder="이메일 작성">
      </div>
      <div>
        <input class="btn btn-primary" type="submit" value="회원가입 완료">
        <input type="button" value="가입 취소" onclick="javascript:history.back(-1)">
      </div>
      </form>
  </div>
</body>
</html>