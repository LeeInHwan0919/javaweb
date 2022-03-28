<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./js/signUp.js"></script>

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
  
  span{
   display:none;
   color:red;
  }
  
  </style>
</head>
<body>

  <fieldset>
    <legend>회원가입창</legend>
    <form action="./RealSignUp.do" method="post">
    <table>
      <tbody>
        <tr>
          <td>아이디 : </td>
          <td><input type="text" name="id" id="id"></td>
          
        </tr>
        <tr>
          <td colspan="2"><span id="idok">id가 중복입니다.</span>
          <span id="iduse">사용가능한 아이디 입니다.</span>
          </td>
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
          <td> <input type="submit" id="insert" class="btn" value="등록" disabled> </td>
        </tr>
      </tbody>
    </table>
    </form>
    <table>
      <tr>
      <td><button onclick="idCheck()" id="btn">아이디 중복 체크</button></td>
          <td colspan="2">
          
           
            <input type="reset" class="btn" value="취소" onclick="javascript:history.back(-1)">
          </td>
        </tr>
    </table>
  </fieldset>

</body>
</html>