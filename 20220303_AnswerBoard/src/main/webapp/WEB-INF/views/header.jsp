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
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/answerboard.js"></script>

<style type="text/css">
	#container{
		width:800px;
		height: 450px;
		margin: 40px auto;
	}
	
	header{
	background: #051937;
	height: 100px;
	color: #000000;
	}
	
	footer{
	background: #051937;
	height: 50px;
	text-align: center;
	line-height: 20px; 
	}
</style>
</head>

<%
	
	 UserVo loginInfo = (UserVo) session.getAttribute("loginInfo");
	 out.print("");
%>
	<body>
		<header>
			<div>
				<h1 style="display: inline;"><a href="./main.do">게시판 구현</a></h1>
				<%if(loginInfo==null){%>
				<div style="display: inline; float: right; margin:10px;">
					<button class="btn btn-info" >Sign in</button>
					<button class="btn btn-primary">Sign up</button>
				</div>
			<%}else{%>
			
				<div style="display: inline; float: right; margin:10px;">
				<span style="color:white; margin:10px">아이디<%=loginInfo.getId() %>(<%=loginInfo.getAuth().equalsIgnoreCase("Y")?"사용자":"관리자"%>)</span>
					<button class="btn btn-warn">My Page</button>
					<button class="btn btn-danger" onclick="javascript:href='./login.do'">Logout</button>
				</div>
			<%}%>
			</div>
			<nav role="navigation">
				<ul id="main-menu">
					<li><a href="./">Home</a></li>
					<li><a href="./">MENU</a>
						<ul id="sub-menu">
							<li><a href="#">게시판</a></li>
							<li><a href="#">글작성</a></li>
						</ul>
					</li>
					<li><a href="./">BTS</a></li>
					<li><a href="./">The Money</a></li>
					<li><a href="./">Time Is Gold</a></li>
					<li><a href="./">Pokemon</a></li>
					<li><a href="./">디지몬</a></li>
					<li><a href="./">Others</a></li>
			</ul>
		</nav>
		</header>
	</body>
</html>