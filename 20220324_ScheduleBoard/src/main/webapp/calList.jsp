<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체글 조회</title>
</head>
<%@include file="./header.jsp" %>
<body>
<jsp:useBean id="dateUtil" class="com.min.edu.bean.DataPattern"/>
<h2>일정 목록 보기</h2>
<div id="container">
  <form action="./DelController.do" method="post" id="multiDelForm">
    <table class="table table-hover">
      <thead>
        <tr class="info">
          <th><input type="checkbox" onclick="allCheck(this.checked)"></th>
          <th>번호</th>
          <th>아이디</th>
          <th>제목</th>
          <th>내용</th>
          <th>일정</th>
          <th>등록일</th>
        </tr>
      </thead>
      <tbody>
        <c:choose>
          <c:when test="${empty lists}">
            <tr>
              <td colspan="7">-- 작성된 글이 없습니다 --</td>
            </tr>
          </c:when>
          
          <c:otherwise>
            <c:forEach var="dto" items="${lists}" varStatus="vs">
            <tr>
              <td><input type="checkbox" name="chk" value="${dto.seq}"></td>
              <td>${fn:length(lists)-vs.index}</td>
              <td>${dto.id}</td>
              <td>
                <a href="./CalController.do?command=detail&seq=${dto.seq}&yyyymmdd=${fn:substring(dto.mdate,0,8)}">${dto.title}</a>
              </td>
              <td>${dto.content}</td>
              <td>
              <jsp:setProperty property="toDate" name="dateUtil" value="${dto.mdate}"/> 
              <jsp:getProperty property="toDate" name="dateUtil"/>
              </td>
              <td>
                <fmt:parseDate var="sDate" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                <fmt:formatDate value="${sDate}" pattern="yyyy. MM. dd"/> 
              </td>
            </tr>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="7">
            <input class="btn btn-primary btn-block" type="submit" value="다중삭제">
          </td>
        </tr>
      </tfoot>
    </table>
  </form>
</div>
</body>
<script type="text/javascript">
  function allCheck(bool){
	  var chk = document.getElementsByName("chk");
	  for(var i=0;i<chk.length;i++){
		  chk[i].checked = bool;
	  }
  }
  
  $(function(){
	  console.log("jQuery로 체크 박스 여부 확인");
	  $("#multiDelForm").submit(function(){
		  if($("#multiDelForm input:checked").length == 0){
			  alert("한개 이상 체크해 주세요")
	       return false;
		  }
	  });
  });
  
</script>
</html>