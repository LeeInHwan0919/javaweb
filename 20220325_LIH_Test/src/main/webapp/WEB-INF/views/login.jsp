<!DOCTYPE html>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script type="text/javascript" src="./js/signIn.js"></script>
<style type="text/css">
  #signIn{
    height: 50px;
  }
  
  fieldset {
	  width :30%;
	  height: 10%;
	  margin : 0 auto;
	  margin-top: 100px;
  }
  
  table{
    margin : 0 auto;
  }
  
  #signUp{
    width: 150px;
  }
  
  div{
    text-align:center;
    width: 50%;
    position: absolute;
    left: 20%; 
  }
</style>
</head>
<body>
<div>

<form action="./login.do" method="post">
    <h3>로그인창</h3>
     <table>
    <tbody>
      <tr>
        <td>id : </td>
        <td><input type="text" name="id" id="id"></td>
        <td rowspan="2"><button type="submit" id="signIn">로그인</button></td>
      </tr>
      <tr>
        <td>pw : </td>
        <td><input type="password" name="pw" id="pw"></td>
      </tr>
    </tbody>  
      
  </table>
</form>

  <button onclick='location.href="./signUp.do"' id="signUp">회원가입</button>
  </div>
</body>
</html>