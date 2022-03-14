<%@page import="com.min.edu.dto.UserVO"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단 메뉴 바</title>
	<link rel="icon" href="./image/favicon.ico" type="image/x-icon">
<!-- 	<cdn><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></cdn> -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
	<link rel="stylesheet" href="./css/bootstrap.css">
	<link rel="stylesheet" href="./css/navbar.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
  	<script type="text/javascript" src="./js/answerBoard.js"></script>

	<style type="text/css">
		#container{
			width: 700px;
			height: 400px;
			margin: 80px auto;
		}
		
		header{
			background: #052937;
			height: 100px;
			color: #000000;
		}
		
		footer{
			background: #052052;
			height: 50px;
			text-align: center;
			line-height: 20px;
			color: orange;
		}
	</style>
</head>
	<%
// 		UserVO loginInfo = null;
		UserVO loginInfo = (UserVO)session.getAttribute("loginInfo");
	%>
<body>
	<header>
		<div>
			<h1 style="display: inline;"><a href="./main.do"><br>게시판 구현</a></h1>
			<% if(loginInfo == null){%>
				<div style="display: inline; float:right; margin:10px;">
					<button class="btn btn-warn" onclick="location.href='./boardLogin.do'">Sign in</button>
					<button class="btn btn-danger">Sign up</button>
				</div>
			<% }else{ %>
				<div style="display: inline; float:right; margin:10px;">
					<span style="color: orange; margin-right: 10px;">아이디<%=loginInfo.getId()%>(<%=loginInfo.getAuth().equalsIgnoreCase("A")?"관리자":"사용자"%>)</span>
					<button class="btn btn-warn">My Page</button>
					<button class="btn btn-danger" onclick="javascript:location.href='./logout.do'">LogOut</button>
				</div>	
			<% } %>
		</div>
		<nav role="navigation">
			<ul id="main-menu">
				<li><a href="./">Home</a></li>
				<li><a href="#">MENU</a>
				<ul id="sub-menu">
					<li><a href="#">게시판</a></li>
					<li><a href="#">글작성</a></li>
				</ul>
				</li>
				<li><a href="./">BTS</a></li>
				<li><a href="./">THE MONEY</a></li>
				<li><a href="./">Time is Gone</a></li>
				<li><a href="./">Poketmon</a></li>
				<li><a href="./">디지몬</a></li>
				<li><a href="./">Others</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>