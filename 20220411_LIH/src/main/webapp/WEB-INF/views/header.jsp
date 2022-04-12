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


<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style type="text/css">
#container {
  width: 800px;
  height: 500px;
  margin: 40px auto;
}

header {
  background: #FFB6C1;
  height: 50px;
  color: #000000;
}

footer {
  background: #FFB6C1;
  height: 50px;
  text-align: center;
  line-height: 20px;
  padding-bottom: 20px; 
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
      
      <c:choose>
        <c:when test="${empty sessionScope.loginInfo}">
          <div style="display: inline; float: right; margin: 10px;">
            <button class="btn btn-info"
              onclick="location.href='./signIn.do'">Sign in</button>
            <button class="btn btn-primary"
              onclick="location.href='./signUp.do'">Sign up</button>
          </div>
        </c:when>
        <c:otherwise>
          <div style="display: inline; float: right; margin: 10px;">
            <span style="color: white; margin: 10px">아이디${sessionScope.loginInfo.email}(${fn:trim(sessionScope.loginInfo.auth) eq 'U'?'사용자':'관리자'})
            </span>
            <button class="btn btn-warn">My Page</button>
            <button class="btn btn-danger"
              onclick="location.href='./logout.do'">Logout</button>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </header>
</body>
</html>