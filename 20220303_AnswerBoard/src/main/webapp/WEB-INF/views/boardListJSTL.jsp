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
	<!-- 세팅 -->
	<c:set var="rows" value="${lists}" scope="page" />

	<jsp:useBean id="pb" class="com.min.edu.comm.PhotoBean" scope="page" />
	scope="page" />
	<img alt="답글" src="./image/reply2.png">

	<div id="container">
		<form action="./boardDelete.do" method="post"
			onsubmit="return chsSubmit()">
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
					<c:if test="${fn:length(rows) eq 0}">
						<tr>
							<td colspan="5" style="color: red; text-align: center;">-작성된
								글이 존재 하지 않습니다-</td>
						</tr>
					</c:if>
					<c:if test="${fn:length(rows) ne 0}">

						<c:forEach var="dto" items="${rows}" varStatus="v">
							<tr>
								<td><input type="checkbox" name="ch" class="ch"
									value="${dto.seq}"></td>
								<td>${fn:length(lists)-v.index}</td>
								<td>${dto.id}</td>
								<c:choose>
									<c:when test="${fn:trim(dto.delflag) eq 'Y'}">
										<td style="color: red; font-size: 0.5em; text-align: center;">-관리자에
											의해 삭제 되었습니다.</td>
									</c:when>

									<c:otherwise>
										<td>
										<a href="./boardDetail.do?seq=${dto.seq}">
										 <jsp:setProperty property="depth" name="pb" value="${dto.depth }" />
										  <jsp:getProperty property="photo" name="pb" />
													 <c:choose>
													<c:when test="${fn:length(dto.title)>8}">
														${fn:substring(dto.title,0,8)} ...
														</c:when>
													<c:otherwise>
														${dto.title}
														</c:otherwise>
												</c:choose>


										</a></td>
									</c:otherwise>
								</c:choose>

								<td><fmt:parseDate var="patternDate" value="${dto.regdate}"
										pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
										value="${patternDate}" pattern="yyyy년 MM월 dd일" /></td>
							</tr>
						</c:forEach>


					</c:if>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" style="text-align: center;"><input
							class="btn btn-info btn-primary" type="submit" value="다중삭제">
							<input class="btn btn-info btn-danger" type="button" value="새글입력"
							onclick="location.href='./boardInsert.do'"></td>
					</tr>
				</tfoot>
			</table>
		</form>
		<%-- <%=lists %> --%>
	</div>
</body>
<%@ include file="./footer.jsp"%>



</html>