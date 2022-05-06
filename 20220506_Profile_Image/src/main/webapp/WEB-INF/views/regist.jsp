<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>회원가입정보</title>
	<style type="text/css">
	  table, th, td{
	    border:1px solid #ccc;
	    border-collapse: collapse;
	  }
	  .fform{
	    width:100px;
	    height: 150px;
	  }
	</style>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
	
	<script type="text/javascript">
	window.onload= function(){
		$("#image").hide();
	}
	
	function readUrl(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload=function(e){
				$("#image").attr("src",e.target.result).width(150).height(200);
			}
			reader.readAsDataURL(input.files[0]);
			$("#image").show();
		}
	}
	
	  function idConfirm(){
		  console.log("idConfirm 동작");
		  var obj = document.getElementById("id");
		  if(obj.title == 'n'){
			  alert("아이디 중복 검사를 먼저 해주세요.");
			  obj.focus();
		  }
	  }
	  
	  function idChk(){
		  console.log("idChk 동작");
		  var obj = document.getElementById("id").value;
		  if(id==""||id==null){
			  document.getElementById("id").focus();
			  alert("값을 입력해 주세요");
		  }else{
			  open("./idCheck.do?id="+id, "아이디 중복 검사", "width=400px,height=500px");
		  }
	  }
	  
	  function emailCheck(){
		  console.log("emailCheck 동작");
		  var email = document.getElementById("email");
		  var regEx = /[0-9a-zA-Z][_0-9a-zA-Z]*@[_0-9a-zA-Z]+(\.[_0-9a-zA-Z]+){1,2}$/;
		  if(!regEx.test(email.value)){
			  alert("올바른 이메일 형식이 아닙니다.");
			  email.focus();
		  }else{
			  alert("사용 가능한 이메일 입니다.");
		  }
	  }
	</script>
</head>
<body>
<h1>
	회원가입 
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>
<%--#{id},#{pw},'U','N',sysdate,#{email},#{proimg} --%>
<form action="./regist.do" method="post" enctype="multipart/form-data">
  <table>
    <tr>
      <th rowspan="4" class="fform">
        <input type="file" multiple="multiple" name="filename" id="imgInput" onchange="readUrl(this)">
        <img src="https://via.placeholder.com/150" id="image">
      </th>
      <th>아이디</th>
      <td>
        <input type="text" title="n" name="id" id="id">
        <input type="button" value="중복체크" onclick="idChk()">
      </td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td>
        <input type="password" name="pw" onclick="idConfirm()">
      </td>
    </tr>
    <tr>
      <th>이메일</th>
      <td>
        <input type="text" name="email" id="email">
        <input type="button" value="이메일확인" onclick="emailCheck()">
      </td>
    </tr>
    <tr>
      <th colspan="3">
        <input type="submit" value="회원가입">
        <input type="reset" value="초기화">
      </th>
    </tr>
  </table>
</form>
</body>
</html>
