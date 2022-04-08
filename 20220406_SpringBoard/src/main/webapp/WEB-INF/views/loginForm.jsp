<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인 값 입력 폼</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function findid(){
	  window.open("./findIdWindow.do","_blank","width=500px", "height=300px");
  }
  </script>
</head>
<body>
  <form action="./login.do" method="post">
    <table class="table table-hover">
      <tr>
        <th>아이디</th>
        <td>
          <input type="text" name="id">
        </td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td>
          <input type="password" name="password">
        </td>
      </tr>
      <tr>
        <th colspan="2">
          <input type="submit" value="전송">
          <input type="button" value="회원가입" onclick="location.href='./signupForm.do'">         
        </th>
      </tr>
    </table>
  </form>
</body>
</html>