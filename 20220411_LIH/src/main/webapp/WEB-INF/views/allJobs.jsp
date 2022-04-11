<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>직업 전체 보기</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>JOBS 테이블 전체 조회</h1>
<input type="button" onclick="location.href='./JobsInsert.do'" value="Jobs 등록하기 (Insert)">
<table class="table">
      <thead>
        <tr>
          <th>아이디</th>
          <th>제목</th>
          <th>최소급여</th>
          <th>최대급여</th>
          <th>UseAge</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="dto" items="${lists}" varStatus="vs">
            <tr>
                <td>${dto.job_id}</td>
                <td>${dto.job_title}</td>
                <td>${dto.min_salary}</td>
                <td>${dto.max_salary}</td>
                <td>${dto.useage}</td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
</div>
</body>
</html>