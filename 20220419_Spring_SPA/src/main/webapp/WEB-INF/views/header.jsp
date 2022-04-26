<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<link rel="stylesheet" type="text/css" href="./css/common.css">
<link rel="stylesheet" type="text/css" href="./css/boardList.css">

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/boardList.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">LongMexicoSpagetti</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#">게시판</a></li>
        <c:if test="${mem2.auth eq 'U'}">
	        <li><a href="#">글 작성(user)</a></li>
        </c:if>
		<c:if test="${mem2.auth eq 'A'}">
	        <li><a href="./memberListMAV.do">회원리스트(admin)</a></li>
		</c:if>
<!--         <li class="dropdown"> -->
<!--           <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 </a><span class="caret"></span> -->
<!--           <ul class="dropdown-menu"> -->
<!--             <li><a href="#">Page 1-1</a></li> -->
<!--             <li><a href="#">Page 1-2</a></li> -->
<!--             <li><a href="#">Page 1-3</a></li> -->
<!--           </ul> -->
<!--         </li> -->

      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li>
      		<a href="#">${mem2.id}님 환영합니다! (${mem2.auth == 'U'?"사용자":"관리자"})</a>
      	
      	</li>
        <li><a href="#"><span class="glyphicon glyphicon-ice-lolly"></span> My Page</a></li>
        <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>