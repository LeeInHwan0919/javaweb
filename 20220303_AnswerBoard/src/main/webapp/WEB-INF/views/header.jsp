<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
#container {
	width: 800px;
	height: 500px;
	margin: 40px auto;
}

header {
	background: #051937;
	height: 100px;
	color: #000000;
}

footer {
	background: #051937;
	height: 50px;
	text-align: center;
	line-height: 20px;
}
</style>
</head>

<!-- 세팅 -->
<c:set var="rows1" value="${loginInfo}" scope="page" />
<!-- 세팅 -->
<c:set var="rows" value="${lists}" scope="page" />
<body>
	<header>
		<div>
			<h1 style="display: inline;">
				<a href="./main.do">게시판 구현</a>
			</h1>
			<c:choose>
				<c:when test="${empty sessionScope.loginInfo}">
					<div style="display: inline; float: right; margin: 10px;">
						<button class="btn btn-info"
							onclick="location.href='./boardLogin.do'">Sign in</button>
						<button class="btn btn-primary"
							onclick="location.href='./sign.do'">Sign up</button>
					</div>
				</c:when>
				<c:otherwise>
					<div style="display: inline; float: right; margin: 10px;">
						<span style="color: white; margin: 10px">아이디${sessionScope.loginInfo.id}(${fn:trim(sessionScope.loginInfo.auth) eq 'U'?'사용자':'관리자'})
						</span>
						<button class="btn btn-warn">My Page</button>
						<button class="btn btn-danger"
							onclick="location.href='./logout.do'">Logout</button>
					</div>


				</c:otherwise>
			</c:choose>

		</div>
		
		
		<nav role="navigation">
			<ul id="main-menu">
				<li><a href="./">Home</a></li>
				<li><a href="./">MENU</a>
					<ul id="sub-menu">
						<li><a href="#">게시판</a></li>
						<li><a href="#">글작성</a></li>
					</ul></li>

				<li><a href="./userInfo.do">BTS</a></li>
				<li><a href="#">The Money</a></li>
				<li><a href="#">Time Is Gold</a></li>
				<li><a href="./">Pokemon</a></li>
				<li><a href="./">디지몬</a></li>
				<li><a href="./">Others</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>