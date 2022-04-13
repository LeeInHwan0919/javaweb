<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ page session="false"%> --%> 
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<fieldset>
		<legend>scope</legend>
		<div>
			scope 읽히는 순서, param은 scope가 아니라 안읽힘
			request = ${requestScope.homeValue}<br>
			session = ${sessionScope.homeValue}<br>
			application = ${applicationScope.homeValue}<br>
			parameter = ${param.homeValue}<br>
			
			로그인 session = ${sessionScope.loginVo.name}<br>
			
			<%= request.getRequestURL().toString().replace(request.getRequestURI(), "") %>
		</div>
		
		<select id="lang" onchange="langChange()">
			<option value="ko" ${param.lang == "ko"?"selected":""}>한국어</option>
			<option value="en" ${param.lang == "en"?"selected":""}>영어</option>
		</select>
		<script type="text/javascript">
			function langChange(){
				var lang = document.getElementById("lang");
				var choiceValue = lang.options[lang.selectedIndex].value;
				console.log("선택된 언어 : "+choiceValue);
				location.href="./main.do?lang="+choiceValue;
			}
		</script>
		<hr>
		
		<h1 id="title" align="center">
			☞ Spring Framework Workshop Book ☜<br>
			<spring:message code="label.title"/>
		</h1>
		
		<hr>
		<div>
			<a href="./socketOpen.do">채팅하기</a><br>
			<a href="./mailForm.do">이메일 보내기</a>
		</div>
		
		<hr>
		<div class="container">
			<form action="./login.do" method="post">
				<table class="table table-hover">
					<tr class="warning">
						<th><spring:message code="label.id"/> </th>
						<td>
							<input type="text" name="id" required="required">
						</td>
					</tr>
					<tr>
						<th><spring:message code="label.password"/> </th>
						<td>
							<input type="password" name="pw" required="required">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="btn btn-warning" type="submit" value='<spring:message code="label.login"/>'>
							<input class="btn btn-info" type="button" value="회원가입 Ajax" onclick="javascript:location.href='./registForm1.do'">
							<input class="btn btn-info" type="button" value="회원가입 FormValidation" onclick="location.href='./formValidation.do'">
						</td>					
					</tr>
				</table>
			</form>
		</div>
		
	</fieldset>
</body>
</html>
