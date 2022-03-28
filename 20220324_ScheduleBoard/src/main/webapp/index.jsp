<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력 처음 페이지</title>
</head>
<body>
  <form action="./CalController.do" method="post">
    <input type="hidden" name="command" value="calendar">
    <table>
      <tr>
        <th>아이디</th>
        <td>
          <input type="text" name="id" value="BD001">
        </td>
      </tr>
      <tr>
        <th>이름</th>
        <td>
          <input type="text" name="name" value="AI">
        </td>
      </tr>
      <tr>
        <th colspan="2">
          <input type="submit" value="달력을 봅시다">
        </th>
      </tr>
    </table>
  </form>
</body>
</html>