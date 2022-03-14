<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>

</head>

<%
 AnswerBoardDto dto = (AnswerBoardDto)request.getAttribute("dto");
%>
<%@ include file ="./header.jsp" %>
<body>
<div id = "container" >
<table class="table table-condensed">
	<tr>
		<th class="info">아이디</th><td><%=dto.getId() %></td>
	</tr>
	
	<tr>
		<th class="info">제목</th><td><%=dto.getTitle() %></td>
	</tr>
	
	<tr>
		<th class="info">내용</th><td><%=dto.getContent() %></td>
	</tr>
	
	<tr>
		<th class="info">등록일</th><td><%=dto.getRegdate() %></td>
	</tr>
	</table>
<form class="btn-group btn-group-justified">
            <%if(loginInfo !=null && dto.getId().equalsIgnoreCase(loginInfo.getId())){%>
                 <div class="btn-group">
                    <button type="button" class="btn btn-danger" onclick="location.href='./boardModify.do'">수정</button>
                  </div>
            <%}if(loginInfo !=null){%>
                  <div class="btn-group">
                    <button type="button" class="btn btn-success" onclick="location.href='./boardAnswer.do'" >답글</button>
                  </div>
                  <%}%>
    </form>




</div>
</body>
<%@ include file ="./footer.jsp" %>
</html>