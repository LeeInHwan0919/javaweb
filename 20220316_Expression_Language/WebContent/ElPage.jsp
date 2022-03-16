<%@page import="com.min.edu.dto.ScoreDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ELPage</title>
</head>
<!-- ElController에서 request와 session scope로 값을 담아서 전달 해줌 -->
<body>
<%
	ScoreDto v1 = (ScoreDto)request.getAttribute("vo");
	ScoreDto v2 = (ScoreDto)session.getAttribute("vo");
%>	
	<fieldset>
		<legend>scope와 parameter</legend>
		<p>
			요청형태를 key / value 의 형태로 되어 있다.scope객체던 parameter던 <br>
			주소를 전달하는애를 (qureyString)<br>
			https://search.naver.com/search.naver?query=코로나<br>
			query=코로나 => 쿼리스트링 parameter
		</p>
			<ul>
				<li>name과 값이 있는 경우 : name에 맞는 value</li>
				<li>name만 있는 경우 : ""</li>
				<li>name이 없는 경우 : null</li>
			</ul>
			<ul>
				<li>request Scope는 요청한 페이지에서만 사용가능한 객체</li>
				<li>session은 redirect이던 forward던 상관없이 객체를 유지하고 있다.</li>
			</ul>
	</fieldset>
	<hr>
	<h3>request scriptlet방식 : <%=v1%>, 이름 : <%=v1.getName()%></h3>
	<h3>session scriptlet방식 : <%=v2%>, 이름 : <%=v2.getName()%></h3>
	<h3>view => servlet forward => ElPage.jsp 로 전송된 Parameter: <%=request.getParameter("command") %></h3>
	
	<hr>
	<fieldset>
		<legend>EL(Expression Language를 통한 값 처리)</legend>
	<p>
		scriptlet을 통한 방법 : scope 객체를 선언하여 호출하면 Object객체 이기 때문에 Casting을 해주어야 함<br>
		선언된 값을 사용하기 위해서는 expression이라는 문법을 사용하여 화면에 출력해주어야된다<br>
		하지만 EL을 통해서 사용하면 자동으로 scope객체를 호출 및 사용이 가능
	</p>
	<ol>
		<li>각 scope는 우선순위에 의해서 호출</li>
		<li>prefix를 통해서 각 객체를 선택적으로 호출</li>
	</ol>
	</fieldset>
	<h3>같은 이름의 우선순위 : ${vo}</h3>
	<h3>prefix를 통한 명확한 호출 : ${requestScope.vo.name} / ${sessionScope.vo}</h3>
	
	<h3>scope의 get메소드 호출:${requestScope.vo.firstName} / ${sessionScope.vo.firstName}</h3>
	<h3>파라미터 호출 : ${param.command}</h3>
	
	<button style="width:200px; background-color: lime">Session삭제</button>
	<script type="text/javascript">
		var btn = document.getElementsByTagName("button")[0];
		btn.onclick=function(){
			location.href="./ctrlSession.do";
		}
	</script>
</body>
</html>

























