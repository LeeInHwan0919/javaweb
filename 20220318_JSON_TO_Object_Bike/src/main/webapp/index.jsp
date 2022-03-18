<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>주소</legend>
		<ul>
			<li>request.getContextPath(): <%=request.getContextPath() %></li>
			<li>request.getRequestURI(): <%=request.getRequestURI() %></li>
			<li>request.getRequestURL(): <%=request.getRequestURL() %></li>
		</ul>
	</fieldset>
	<h3><a href="./bikeCtrl.do?command=first">첫번째 방법</a></h3>
	<h3><a href="<%=request.getRequestURL()%>bikeCtrl.do?command=second">두번째 방법</a></h3>
</body>
</html>