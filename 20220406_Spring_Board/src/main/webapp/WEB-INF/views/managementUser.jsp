<%@page import="com.min.edu.vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원관리 </title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  	table,th,td{
  		border : 1px solid #CCC;
  		border-collapse: collapse;
  		padding: 5px;
  		margin-top: 50px;
  	}
  </style>
</head>
<%
  List<UserVo> lists=	(List<UserVo>)request.getAttribute("listsVo");
%>
<script type="text/javascript">
	var btn ="test";
	$(document).ready(function(){
		$("button[name=btnChk]").click(function(){
			btn=$(this).attr("value");
		});
	});

	function allChk(bool) {
		var chks = document.getElementsByName("chksId");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked=bool;
		}
	}
	
	function checkBox(){
		var chks = document.getElementsByName("chksId");
		
		var cnt =0;
		for (var i = 0; i < chks.length; i++) {
			if(chks[i].checked){
				cnt++;
			}
		}
		if(cnt==0){
			alert("한 개 이상을 체크 해 주세요");
			return false;
		}else{
			var data = $("#form").serialize();
			data +="&btnChk="+btn;
			
			$.ajax({
				url:"./managementUser.do",
				type:"post",
				async:true,
				data:data,
				dataType:"text",
				success: function(msg){
					if(msg =="yes"){
						alert("회원의 권한을 변경하였습니다.");
						location.href='./managementUser.do'
					}else{
						alert("변경사항이 없습니다..");
						location.href='./managementUser.do'
					}
				},
				error: function(request,status,error){
					console.log("");
				}
			})
		}
		
	}
	
</script>

<body>
<div class="container">
<h1>회원 관리</h1>
<form action="./managementUser.do"  id="form" method="post" name="form" onsubmit="return checkBox()">
	<table class="table">
		<thead>
			<tr>
			<th><input type="checkbox" onclick="allChk(this.checked)" > </th>
			<th>ID</th>
			<th>이름</th>
			<th>이메일</th>
			<th>권한</th>
			<th>활성화여부</th>
			<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<%for(UserVo vo : lists){ %>
				<tr>
					<td><input type="checkbox" name="chksId" value="<%=vo.getId()%>"> </td>
					<td><%=vo.getId() %></td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getEmail() %></td>
					<%if(vo.getAuth().equalsIgnoreCase("U")) {%>
							<td>일반사용자 </td>
					<%} else{ %>
						<td>관리자 </td>
						<%} %>
					<%if(vo.getDelflag().equalsIgnoreCase("N")) {%>
							<td>활성화계정  </td>
					<%} else{ %>
						<td>비활성화 계정  </td>
						<%} %>
					<td><%=vo.getJoindate() %></td>
				</tr>
			<%} %>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7" style="text-align: center;">
						<button class="btn btn-primary" name="btnChk" value="toAuth">관리자로 변경 </button>
						<button class="btn btn-danger" name="btnChk"  value="toUser">일반유저로 변경 </button>
						<button class="btn btn-success" name="btnChk" value="inactiveUser">비활성화 </button>
						<button class="btn btn-info" name="btnChk" value="activeUser">재활성화 </button>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
</div>

</body>
</html>