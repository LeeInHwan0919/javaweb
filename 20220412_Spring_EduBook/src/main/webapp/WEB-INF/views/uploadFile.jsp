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
  <legend>파일다운로드</legend>
  <div>
    파일명 : ${fileObj.filename}<br>
    설명: ${fileObj.desc}<br>
  </div>
  <div>
    <img src = "${path.concat('\\').concat(fileObj.filename)}">
    <img src="./storage/${fileObj.filename}">
  </div>
  <div>
    <form action="./download.do" method="post">
      <input type="hidden" name="filename" value="${fileObj.filename}">
      <input type="submit" value="다운로드">
    </form>
  </div>
  <div>
    <ul>
      <li>
        <b>프로젝트의 path</b><br>
        request.getContextPath() : <%=request.getContextPath() %>
      </li>
      <li>
        <b>프로젝트의 Path + 페이지의 경로</b><br>
        request.getRequestURI() : <%=request.getRequestURI() %>
      </li>
      <li>
        <b>전체경로</b><br>
        request.getRequestURL() : <%=request.getRequestURL() %>
      </li>
      <li>
        <b>파일명</b><br>
        request.ServletPath() : <%=request.getServletPath() %></li>
      <li>
        <b>파일의 물리적인 주소(절대경로)</b><br>
        request.getRealPath() : <%=request.getRealPath("") %>
      </li>
    </ul>
  </div>
</fieldset>
</body>
</html>