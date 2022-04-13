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

<form action="./signIn.do" method="post">
	<table style="margin: 100px auto; text-align: center">
	  <tbody>
		<tr>
			<th>E-Mail : </th>
			<td><input type="email" name="email" id="email" required> </td>
		</tr>
		<tr>
			<th>Password</th>
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