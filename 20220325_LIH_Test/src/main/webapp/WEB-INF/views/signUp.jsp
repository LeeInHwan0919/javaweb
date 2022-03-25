<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./js/js.js"></script>

<style type="text/css">
  fieldset {
    width :50%;
    height: 100%;
    margin : 0 auto;
    margin-top: 100px;
  }
  
  table{
    margin : 0 auto;
  }
  
  .btn{
    width:70px;
    margin-left: 60px;
  }
  </style>
</head>
<body>
<form action="./signUp.do">
  <fieldset>
    <legend>회원가입창</legend>
    <table>
      <tbody>
        <tr>
          <td>아이디 : </td>
          <td><input type="text" name="id" id="id"></td>
          <td><button onclick="idCheck()" id="btn">아이디 중복 체크</button></td>
        </tr>
        <tr>
          <td>비밀번호 : </td>
          <td><input type="text" name="pw" id="pw"></td>
        </tr>
        <tr>
          <td>이름 : </td>
          <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
          <td>생년월일 : </td>
          <td><input type="text" name="regdate" id="regdate"></td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="button" class="btn" value="등록"> 
            <input type="reset" class="btn" value="취소" onclick="javascript:history.back(-1)">
          </td>
        </tr>
      </tbody>
    </table>
  </fieldset>
  </form>
</body>
</html>