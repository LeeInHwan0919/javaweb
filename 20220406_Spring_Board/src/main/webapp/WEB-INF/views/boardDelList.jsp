<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<c:if test="${loginVo.id != null}">
			${sessionScope.loginVo.id} 님 환영합니다
			<input type="button" value="로그아웃" onclick="location.href='./logout.do'">
		</c:if>
			
		
			<c:set var="len" value="${fn:length(lists)}"/>
			TOTAL : ${len}
			<table style="margin: 20px;">
				<thead>
					<tr>
						<th>연번</th>
						<th>아이디</th>
						<th>제목</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dto" items="${lists}"  varStatus="vs">
						<tr>
							<td>${vs.count}</td>
							<td>${dto.id }</td>
							<td><a href="./restoreDetailBoard.do?seq=${dto.seq}">${dto.title}</a> </td>
							<td>
									<fmt:parseDate var='cDate' value="${dto.regdate}" pattern="yyyy-MM-dd"/>
									<fmt:formatDate value="${cDate }"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>