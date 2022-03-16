<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL을 사용해보자</title>
</head>
<body>
	${fn:length(lists)}
	<br> ${lists[0]}
	<br>
	<hr>
	<h2>JSTL 문법 초간단 정리</h2>
	<table>
		<thead>
			<tr>
				<td>연번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
				<td>등급</td>
			</tr>
		</thead>
		<tbody>
			<c:set var="infos" value="${lists}"/>
			<c:forEach var="d" items="${infos}" varStatus="vs">
				<tr>
					<td>${fn:length(lists)-vs.index},${vs.index},${vs.count}</td>
					<td>
						<c:if test="${d.name eq '피츄1' }">
							<c:out value="첫번째 피츄"/>
							${d.name}
						</c:if>
						<c:choose>
							<c:when test="${d.name eq '피츄3' }">
								${d.name}님 환영합니다.
							</c:when>
							<c:when test="${d.name eq '피츄7' }">
								<c:out value="${d.name}님 반갑습니다."></c:out>
							</c:when>
							<c:otherwise>
								누구?
							</c:otherwise>
						</c:choose>
					</td>
					
					<td>${d.kor}</td>
					<td>${d.eng}</td>
					<td>${d.math}</td>
					
					<c:set var="total" value="${d.kor + d.eng + d.math}"/>
					<td>${total}</td>
					
					<td>${total/3}</td>
					
					<td>
						${total>200?"합격":"과락"}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach var="i" begin="1" end="9" step="1">
		${i}<br>
	</c:forEach>

<!-- DTO의 날짜가 java.util.Date 혹은 java.lang.String타입이거나  -->
<fmt:formatDate value="<%=new Date()%>" pattern="yyyy년 MM월 dd일"/>

<fmt:parseDate value="${inDate}" pattern="yyyy-MM-dd hh:mm:ss" var="inDate"/>

</body>
</html>
















