<%@page import="com.min.edu.model.AnswerBoardDaoImpl"%>
<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단 메뉴바</title>
<link rel="icon" href="./image/favicon.ico" type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<link rel="stylesheet" href="./css/navbar.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/answerboard.js"></script>

<style type="text/css">
	#container{
		width:800px;
		height: 450px;
		margin: 40px auto;
	}
	
	header{
	background: #8FBC8F;
	height: 70px;
	color: 	#3CB371;
	}
	
	footer{
	background: #8FBC8F;
	height: 50px;
	text-align: center;
	line-height: 20px; 
	}
</style>
</head>

<%
	List<AnswerBoardDto> lists = (List<AnswerBoardDto>) request.getAttribute("lists");
	 UserVo loginInfo = (UserVo) session.getAttribute("loginInfo");
%>
	<body>
		<header>
			<div style=" text-align: center;">
				<h1 style="display: inline; color: white;">게시판 구현</h1>
				<%if(loginInfo==null){%>
				<div style="display: inline; float: right; margin:10px;">
					<!-- <button class="btn btn-info" onclick="location.href='./index.jsp'">Sign in</button> -->
					<button class="btn btn-info" onclick="location.href='./index.jsp'">Sign in</button>
					<button class="btn btn-primary" onclick="location.href='./signUp.do'">Sign up</button>
				</div>
			<%}else{%>
			
				<div style="display: inline; float: right; margin:10px;">
				<span style="color:white; margin:10px">아이디<%=loginInfo.getId() %>(<%=loginInfo.getAuth().equalsIgnoreCase("U")?"사용자":"관리자"%>)</span>
					<button class="btn btn-warn">My Page</button>
					<button class="btn btn-danger" onclick="location.href='./logout.do'">Logout</button>
				</div>
			<%}%>
			</div>
			
		</header>

	</body>
</html>