<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info 화면</title>
</head>
<body>
<h2>이름 : ${infoname}</h2>
<h2>나이 : ${infoage}</h2>

<fieldset>
  <legend>인코딩 처리 하는 방법</legend>
  <ol>
    <li>각 요청되는 페이지 혹은 servlet에서 reqeust.setCharacterEncoding("UTF-8")</li>
    <li>web.xml에 &lt;filter&gt;를 통해서 서버를 통하는 모든 요청에 대한 코딩</li>
    <li>tomcat의 설정인 server.xml에 63번째 줄에 &lt;connector&gt;에 URIEncoding="UTF-8" 설정 </li> 
  </ol>
</fieldset>
</body>
</html>