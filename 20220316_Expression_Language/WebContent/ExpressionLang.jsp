<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language의 기본 문법</title>
</head>

<%!//declaration 선언 java의 메소드를 선언하는 영역
	int x = 0;

	public int val() {
		return x;
	}%>

<%
// scriptlet 연산 문법 작성하는 영역
int y = 0;
request.setAttribute("yy", y);
request.setAttribute("xx", val());
%>
<body>
	<fieldset>
		<legend>Scriptlet의 구성요소에 따른 메모리의 사용 영역</legend>
		<p>
			declaration:<%=x++%><br>
			scriptlet:<%=y++%><br>
		</p>
		
		<p>
			declaration 의 scope에 담은 값:${xx}<br>
			scriptlet의 scope에 담은 값:${yy}<br>
		</p>
		<p>
			이전에 scope처리
			request.getAttribute("xx");
			<%= request.getAttribute("xx") %>
		</p>
	</fieldset>
	<h1 style="margin-top:50px">EL 설명</h1>
	<fieldset>
		<ul>
			<li>scope(page, request, session application)객체를 자동으로 호출</li>
			<li>scope란? 값을 전달 할 수 있는 객체</li>
			<li>문법의 특징? scriptlet으로 했을 경우 만약에 키(name)이 없다면 null로 처리</li>
			<li>절대 null이아닌 ""값을 출력</li>
		</ul>
		<div>
			scriptlet 처리 : <%=request.getAttribute("name") %><br>
			EL처리 : ${name} <br>
		</div>
		
		<table border="1">
		<col width="300px"><col width=500px">
			<thead>
				<tr>
					<th>EL Expression</th><th>Result</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td>\${1+10}</td>
					<td>${1+10}</td>
				</tr>
				<tr>
					<td>\${"A"=="A" }</td>
					<td>${"A"=="A" }</td>
				</tr>
				<tr>
					<td>\${"A"eq"A" }</td>
					<td>${"A"eq"A" }</td>
				</tr>
				<tr>
<!-- 					<td>\${"A"ne"A" }</td> -->
<%-- 					<td>${"A"ne"A" }</td> --%>
				</tr>
				<tr>
					<td>\${10 mod 3 }</td>
					<td>${10 mod 3}</td>
				</tr>
				<tr>
					<td>\${empty""}</td>
					<td>${empty""}</td>
				</tr>
				<tr>
					<td>\${empty null}</td>
					<td>${empty null}</td>
				</tr>
			</tbody>
		</table>
	</fieldset>
</body>
</html>