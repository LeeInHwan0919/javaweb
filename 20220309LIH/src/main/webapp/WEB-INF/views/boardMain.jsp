<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.min.edu.dto.UserVo"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글전체보기</title>
</head>

<%@include file="./header.jsp"%>
<body>

	<jsp:useBean id="pb" class="com.min.edu.comm.PhotoBean" scope="page" />
	<jsp:useBean id="dp" class="com.min.edu.comm.DatePatternBean"
		scope="page" />

	<div id="container">
		<form action="./boardDelete.do" method="post"
			onsubmit="return chsSubmit()"
			style="border: 2px solid navy; padding: 10px;">
			<div style="width: 100%; height: 300px; overflow: auto;">
				<table class="table table-hover">
					<thead>
						<tr class="info">
							<th><input type="checkbox" id="allCheck" class="allCheckBox">
							</th>
							<th>연번</th>
							<th>아이디</th>
							<th>제목</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (lists.size() == 0) {
						%>
						<tr>
							<td colspan="5" style="color: red; text-align: center;">-작성된
								글이 존재 하지 않습니다-</td>
						</tr>
						<%
							} else {
						for (int i = 0; i < lists.size(); i++) {
						%>
						<tr>
							<td><input type="checkbox" name="ch" class="ch"
								value="<%=lists.get(i).getSeq()%>"></td>
							<td><%=lists.size() - i%></td>
							<td><%=lists.get(i).getId()%></td>

							<td><a
								href="./boardDetail.do?seq=<%=lists.get(i).getSeq()%>"> <jsp:setProperty
										property="depth" name="pb"
										value="<%=lists.get(i).getDepth()%>" /> <jsp:getProperty
										property="photo" name="pb" /> <%=lists.get(i).getTitle()%>

							</a></td>

							<td><jsp:setProperty property="regdate" name="dp"
									value="<%=lists.get(i).getRegdate()%>" /> <jsp:getProperty
									property="datePattern" name="dp" /></td>
						</tr>

						<%
							}

						}
						%>
					</tbody>
				</table>
			</div>
			<div colspan="5" style="text-align: center;">
				<input class="btn btn-info btn-primary" type="submit" value="다중삭제">
				<input class="btn btn-info btn-danger" type="button" value="새글입력"
					onclick="location.href='./boardInsert.do'">
			</div>
		</form>
		<%-- <%=lists %> --%>
	</div>
</body>
<%@ include file="./footer.jsp"%>



</html>