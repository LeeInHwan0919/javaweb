<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form Validation</title>
</head>
<body>
  <form:form action="./regist.do" method="post" commandName="registvalidatedto">
    <table border="1">
      <tr>
        <th>아이디</th>
        <td>
        <form:input path="id" name="id" /> 
        <form:errors path="id" />
        </td>
      </tr>
      <tr>
        <th>성명</th>
        <td>
        <form:input path="name" />
        <form:errors path="name" /></td>
      </tr>
      <tr>
        <th>비밀번호</th>
        <td>
        <form:input path="pw" /> 
        <form:errors path="pw"/>
        </td>
      </tr>
      <tr>
        <th>비밀번호 확인</th>
        <td>
        <input type="password" id="passwordChk">
        </td>
      </tr>
      <tr>
        <th colspan="2">
        <input type="submit" value="가입"> 
        <input type="button" value="취소" onclick="javascript:history.back(-1)">
        </th>
      </tr>
    </table>
  </form:form>
</body>
</html>