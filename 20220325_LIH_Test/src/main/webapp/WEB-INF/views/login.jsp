<!DOCTYPE html>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
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
    margin-left: 35px;
    width: 235px;
  }
</style>
</head>
<body>
<form action="./login.do">
  <fieldset>
    <legend>로그인창</legend>
     <table>
    <tbody>
      <tr>
        <td>id : </td>
        <td><input type="text" name="id" id="id"></td>
        <td rowspan="2"><button onclick='location.href="./signIn.do"' type="submit" id="signIn">로그인</button></td>
      </tr>
      <tr>
        <td>pw : </td>
        <td><input type="password" name="pw" id="pw"></td>
      </tr>
      <tr>
        <td colspan="3"><button onclick='location.href="./signUp.do"' type="submit" id="signUp">회원가입</button></td>
        
      </tr>
    </tbody>
  </table>
  </fieldset>
  </form>
</body>
</html>