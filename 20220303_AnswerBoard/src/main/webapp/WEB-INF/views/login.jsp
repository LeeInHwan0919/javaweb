<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<%@include file="./header.jsp" %>
<body>
<form action="login.do" method="post">
	<table style="margin: 100px auto; text-align: center">
	  <tbody>
		<tr>
			<th>아이디 : </th>
			<td><input type="text" name="id" id="id" readonly="readonly" > </td>
		</tr>
		<tr>
			<th></th>
			<td><input type="password" name="password" id="password" required></td>
		</tr>
	  </tbody>
	  <tfoot>
	  	<tr>
	  		<td colspan="2">
	  			<input type="submit" class="btn" value="로그인">
	  			<input type="reset" class="btn" value="취소" onclick="javascript:history.back(-1)">
	  		</td>
	  	</tr>
	  </tfoot>
	</table>
</form>

</body>
<%@include file="./footer.jsp" %>
</html>