<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	List<UserVo> userLists = (List<UserVo>)request.getAttribute("userList");
%>
<%@ include file="./header.jsp" %>
<body>
<div id="container">
<%=userLists %>
</div>
</body>
<%@ include file="./footer.jsp" %>
</html>