<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home 화면</title>
</head>
<body>
  <fieldset>
    <legend>처리방식에 따른 Controller 연습</legend>
    <ul>
      <li>home Get 방식 호출 <br>
        <a href="./home.do?name=banana">home Get호출</a>
      </li>
      <li>home Post방식 호출
        <form action="./home.do" method="post">
          <input type="text" name="name" value="tomato">
          <input type="submit" value="Post전송">
        </form>
      </li>
    </ul>
  </fieldset>
  <hr>
  <h3>전달값</h3>
    model 전달: ${requestScope.str}<br>
    request 전달: ${requestScope.req_str}<br>
    <hr>
    <a href="./selectBoard.do">게시글 전체보기</a>
</body>
</html>