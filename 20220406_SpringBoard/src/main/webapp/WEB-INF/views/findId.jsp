<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
  function findId(){
	  var name = document.getElementById("name").value;
	  var email= document.getElementById("email").value;
	  var info = document.getElementById("info");
	  console.log(name);
	  console.log(email);
	  if(email.match(refExp)){
		  
	  }
	  $.ajax({
		  url:"./findId.do",
		  type:"post",
		  async:true,
		  data:{"name":name,"email":email},
		  success:function(data){
			  if(data==""){
				  info.innerHTML="아이디를 찾을 수 없습니다."
			  }else{
				  info.innerHTML="회원님의 아이디는 ["+data+"]입니다";
			  }
		  }
			
	  });
  }
</script>
</head>
<body>
  이름:<input type="text" id="name">
  이메일:<input type="text" id="email">
  <input type="button" onclick="findId()" value="아이디 찾기">
  <p id="info"></p>
</body>
</html>