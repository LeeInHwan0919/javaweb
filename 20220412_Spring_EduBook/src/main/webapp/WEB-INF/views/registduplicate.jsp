<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  window.onload = function(){
	  document.getElementById("useId").style.display = "none";
	  
  }
  
  function checkId(obj){
	  console.log("checkId : "+obj);
	  var id = document.getElementById("id").value;
	  $.ajax({
		  url:"./duplicateAjax"+obj+".do",
		  type:"post",
		  async:true,
		  data:"chkId="+id,
		  dataType:"json",
		  success: function(msg){
			  console.log("값:"+msg.isc+",반환된 타입 : "+typeof msg);
// 			console.log("값:"+msg.isc.job_id+",반환된 타입 : "+typeof msg);
// 			console.log("값:"+msg.isc.job_title+",반환된 타입 : "+typeof msg);
			  if(msg.isc == true){
				  document.getElementById("useId").innerHTML = "사용 가능 합니다.";
				  document.getElementById("useId").style.display = "block";
			  }else{
				  document.getElementById("useId").innerHTML = "사용 불가능 합니다.";
				  document.getElementById("useId").style.display = "none";				  
			  }
		  },
		  error: function(){
			  alert("잘못된 요청 처리");
		  }
	  });
  }
  

	function userId(){
		var doc = document.getElementById("id").value
		opener.document.getElementById("id").value = doc;
		opener.document.getElementById("name").focus();
		window.close();
	}
</script>
<body>
	<div>
		<input type="text" id="id">
		<input type="button" value="확인(spring3.0)" onclick="checkId(3)">
		<input type="button" value="확인(spring4.0)" onclick="checkId('4')">
	</div>
	<div>
		<input type="button" value="사용" id="useId" onclick="userId()">
	</div>
	<div id="msg">
	
	</div>
</body>
</html>