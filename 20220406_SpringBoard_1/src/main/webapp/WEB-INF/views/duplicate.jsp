<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 검사 window open창</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	  document.getElementById("btnUseId").style.display="none";
  });
  
  function checkId(){
	  var id = document.getElementById("id").value;
	  console.log(id);
	    
	  if(id != ""){
		  $.ajax({
			  url:"./duplicationAjax.do",
			  type:"post",
			  data:"checkId="+id,
			  async:true,
			  success:function(msg){
				  if(msg == "false"){
					  document.getElementById("condition").innerHTML = "사용가능한 아이디 입니다."
						document.getElementById("btnUseId").style.display="block";
				  }else{
					  document.getElementById("condition").innerHTML = "사용할 수 없는 아이디 입니다."
				    document.getElementById("btnUseId").style.display="none";
				  }
			  },
			  error:function(){
				  alert("잘못된 요청 입니다.");
			  }
		  });
	  }else{
		  alert("값이 없는데예~?");
	  }
  }
  
    function useId(){
    	var id = document.getElementById("id").value;
    	opener.document.getElementById("id").value = id;
    	window.close();
    }
  </script>
</head>
<body>
    <div class="container">
      <h4>아이디 중복확인</h4>
      <h4>ID를 입력해 주세요</h4>
      <input type="text" class="form-control" id="id">
      <input type="button" value="확인" class="btn btn-success" onclick="checkId()">
      <input type="button" value="사용하기" class="btn btn-warning" id="btnUseId" onclick="useId()">
    </div>
    <div id="condition"></div>
</body>
</html>