<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원전체조회</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
${lists}
<div class="container">
	<h3>회원 전체조회</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var ="dto" items="${lists}" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td><a href="./userSelectOne.do?id=${dto.id}">${dto.id}</a></td>
					<td>${dto.name}</td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div>

	<fieldset>
		<legend>회원검색</legend>
		<form name="search-frm" autocomplete="off">
			<select name="type" id="type">
				<option selected value="null">선택</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
			</select>
				<input type="text" name="keyword" placeholder="키워드를 입력해주세요">
				<input type="button" value="검색" onclick="getSearchUser()">
		</form>
	</fieldset>
</div>
<script type="text/javascript">
function getSearchUser() {
	console.log("작동");
	
	var opt = $('#type option:selected').val();
	var keyword = $('input[name=keyword]').val();
	console.log(opt);
	console.log(keyword);
	
	$.ajax({
		url: "./getSearchUser.do",
		method:"post",
		data:{"opt":opt, "keyword":keyword},
		dataType:"json",
		success:function(msg){
			console.log(msg); //  JSONArray [{"id":"value", "name":"value"},{"id":"value", "name":"value"}]
			// dataType : text //  JSON.parser(msg)
			
			var jArray = msg;
			jArray.forEach(function(key, data));
			
			Object.keys(jArray).forEach(function(key){
				console.log(key, jArray[key])
			});
			
			for(var key in jArray){
				console.log(key, jArray[key].name)
			}
			
			
			var html="";
			$.each(msg, function(key, value){
				html +="<tr>";
				html +="<td>"+(key+1)+"</td>";
				html +="<td><a href='./userSelectOne.do?id='"+value.id+">"+value.id+"</a></td>";
				html +="<td>"+value.name+"</td>";
				html +="</tr>";
				
			});
			$("tbody").html(html);
		},
		error:function(){
			console.log("실패");
		}
	})
}


</script>
</body>
</html>