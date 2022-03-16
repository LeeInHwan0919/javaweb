<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글작성 폼</title>
</head>

<%!
	public String formatDate(Date d){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy년도 MM월 dd일");
	return fmt.format(d);
}
%>

<%
	AnswerBoardDto dto = (AnswerBoardDto)request.getAttribute("dto");
%>
<%@ include file="./header.jsp" %>
<body>
<div id="container">
	<form action="./boardAnswer.do" method="post" onsubmit="return checkCon();">
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td class="form-group">
						<input class="form-control" name="id" value="${rows.id}" readonly>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td class="form-group">
						<input type="text" class="form-control" name="title" required>
					</td>
				</tr>
				<tr>
					<th id="contxt">내용<br>(원본)</th>
					<td class="form-group">
						<input type="hidden" value="Y" id="chkContent">
						<input type="hidden" value="<%=dto.getContent()%>" id="hideContent">
						<textarea class="form-control" rows="5" name="content" required id="txtArea" onclick="contentCheck()">원본글&gt;<%=dto.getContent()%></textarea>
					</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td class="form-group">
						<%=formatDate(new Date()) %>
					</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td class="form-group"  id="nowDate">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input class="btn btn-primary btn-sm btn-block" type="submit" value="답글작성">
						<input class="btn btn-info btn-sm btn-block" type="reset" onclick="resetValue()" value="입력 초기화">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
<%@ include file="./footer.jsp" %>
</body>
<%-- <script type="text/javascript">
<% if(loginInfo==null){%>
		window.onload=function(){
			alert("로그인을 먼저 해주세요");
			location.href="./boardLogin.do"
		}
		<%}else{%>
		window.onload=function(){
			document.getElementById("info").textContent = <%=loginInfo.getId()%>;
		}
		<%}%>
</script> --%>
<script type="text/javascript">
setInterval(nowDate,1000)

function nowDate(){
const date = new Date();
document.getElementById("nowDate").innerHTML = date.toLocaleString();
	
}


</script>
</html>