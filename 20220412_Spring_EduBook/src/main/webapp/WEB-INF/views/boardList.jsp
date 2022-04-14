<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 페이지</title>
<style type="text/css">
  .main{
    width: 900px;
    border: 1px solid tomato;
  }
  
  .main-div{
    float: left;
    width: 200px;
    height: 100px;
    background-color: #ffff66;
  }
  
  .menu-content{
    float: right;
    width: 700px;
    height: 500px;
    border: 1px solid forestgreen;
  }
</style>
</head>
<body>
<div class="main">
  <div class="main-div">
    ${sessionScope.loginVo.name} 님 반갑습니다.
  </div>
  <c:if test="${loginVo.auth eq 'A'}">
    <div>[관리자 모드]</div>
  </c:if>
  
  <div>
    <a href="#">[게시판 보기]</a>
  </div>
  
  <div>
    <a href="./logout.do">[로그아웃]</a>
  </div>
  
  <div class="menu-content">
    <div class="contentArea">
      콘텐트 메뉴
      <ol>
        <li><a href="./sessionValue.do">HttpSession의 값을 사용해 보자</a></li>
      </ol>
    </div>
  </div>
  
</div>

</body>
</html>