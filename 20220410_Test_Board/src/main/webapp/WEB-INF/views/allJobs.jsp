<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 출력</title>
</head>
<body>
<table>
<thead>
<tr>
  <th>아이디</th>
  <th>제목</th>
  <th>최소 급여</th>
  <th>최대 급여</th>
</tr>
</thead>
<c:forEach var="dto" items="${lists}" varStatus="vs">
<tbody>
<tr>
<td>${dto.job_id}</td>
<td>${dto.job_title}</td>
<td>${dto.min_salary}</td>
<td>${dto.max_salary}</td>
</tr>
</tbody>
</c:forEach>
</table>
</body>
</html>