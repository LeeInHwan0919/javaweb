<%@page import="org.springframework.web.context.request.RequestContextHolder"%>
<%@page import="org.springframework.web.context.request.ServletWebRequest"%>
<%@page import="com.min.edu.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체글 조회</title>

<script type="text/javascript">
  function chkbox(){
	  var chks = document.getElementsByName("chkVal");
	  var cnt = 0;
	  for(let c of chks){
		  if(c.checked){
			  cnt++;
		  }
	  }
	  
	  if(cnt==0){
		  alert("한개 이상의 글을 반드시 선택하세요.");
		  return false;
	  }
	  
  }
  
  function allValue(bool){
	  var chks = document.getElementsByName("chkVal");
	  for(let c of chks){
		  c.checked = bool;
	  }
  }
</script>

<style type="text/css">
  table, th, td{
    border: 1px solid #ccc;
    border-collapse: collapse;
    padding: 5px;
  }

  a{
    text-decoration: none;
    font-weight: bold;
    color:orange;
  }
</style>
<%
ServletWebRequest servletContainer = (ServletWebRequest)RequestContextHolder.getRequestAttributes();
HttpServletRequest req = servletContainer.getRequest();

String step = req.getParameter("step");
int stepCnt = Integer.parseInt(step);
System.out.println(step+"step의 값");
String str = "";
String blank="&nbsp;";
for (int i = 0; i < stepCnt; i++) {
  str+=blank;
}
// req.setAttribute("str",str);
%>
</head>
<body>
<div>
<form action="./logout.do" method="get">
  <c:if test="${loginVo.id != null}">
    ${sessionScope.loginVo.id} 님 환영합니다.
    <input type="button" value="로그아웃" onclick="location.href='./logout.do'">
  </c:if>
  <c:if test="${loginVo.auth=='A'}">
    <input type="button" value="회원관리" onclick="location.href='./managementUser.do'">
  </c:if>
</form>
  <form action="./multiDel.do" method="post" id="frm" name="frm" onsubmit="return chkbox()">
    <input type="submit" value="다중삭제">
    <input type="button" value="새글입력" onclick="location.href='./insertBoard.do'"> 
    </form>
    <c:set var="len" value="${fn:length(lists)}"/>
    Total : ${len}
    <form action="./boardList.do" method="get">
    <table style="margin:20px">
      <thead>
        <tr>
          <th><input type="checkbox" onclick="allValue(this.checked)"></th>
          <th>연번</th>
          <th>아이디</th>
          <th>제목</th>
          <th>등록일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="dto" items="${lists}" varStatus="vs">
        
            <tr>
            <td><input type="hidden" value="${dto.step}" id="step" name="step" ></td>
                <td><input type="checkbox" name="chkVal" value="${dto.seq}"> </td>
                <td>${vs.count}</td>
                <td>${dto.id}</td>
                <td><a href="./detailBoard.do?seq=${dto.seq}"><%=str%>${dto.title}</a></td>
                <td>
                    <fmt:parseDate var="cDate" value="${dto.regdate}" pattern="yyyy-MM-dd"/>
                    <fmt:formatDate value="${cDate}"/>
                </td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
  </form>

</div>
</body>
</html>