<%@page import="com.min.edu.dto.UserVO"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
	<%
		UserVO loginInfo = (UserVO)session.getAttribute("loginInfo");
		List<AnswerBoardDto> lists = (List<AnswerBoardDto>)request.getAttribute("lists"); 
	%>
<body>
	<jsp:forward page="./main.do"/>
		
	<h2><a href="./main.do">글 목록보기</a></h2>
	<fieldset>
		<legend>scope Test</legend>
		<%
			if(loginInfo == null){
				%>
					<div style="color:orange;">로그인된 정보가 없습니다</div>
				<% 
			}else{
				%>
					**로그인 정보**<br>
					<ul>
						<li>아이디 : <%=loginInfo.getId() %></li>
						<li>성명 : <%=loginInfo.getName() %></li>
						<li>권한:<%=loginInfo.getAuth().equalsIgnoreCase("A")?"사용자":"관리자" %></li>
						<li><button onclick="location.href='./logout.do'">로그아웃</button></li>
					</ul>
					<div><%=lists == null?"request scope 전달 안됨":"request scope 전달 됨" %></div>
				<%
			}
		%>
	</fieldset>
</body>
</html>
