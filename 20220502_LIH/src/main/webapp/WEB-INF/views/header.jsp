<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<link rel="stylesheet" type="text/css" href="./css/boardList.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/chkDel.js"></script>
<script type="text/javascript" src="./js/boardList.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TEST</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#">Home</a></li>
		<li><a href="/boardList.do">게시판</a></li>
		  <c:if test="${member.auth eq 'U'}">
        	<li><a href="#">글작성</a></li>		  
		  </c:if>
		  <c:if test="${member.auth eq 'A'}">
        	<li><a href="./memberList.do">회원리스트</a></li>		  
		  </c:if>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li>
      	  <a href="#">${member.id}님 환영합니다 (${member.auth == 'U' ? "사용자" : "관리자"})</a>
      	</li>
        <li><a href="#"><span class="glyphicon glyphicon-home"></span>Mypage</a></li>
        <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>