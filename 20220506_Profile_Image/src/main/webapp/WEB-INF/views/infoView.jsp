<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세 보기</title>
</head>
<body>
  <table>
    <tr>
      <td>프로필 이미지</td>
      <td><img src="./resources/proimg/${infoUser.proimg}" style="width:150;height:150px"></td>
    </tr>
    <tr>
      <td>${infoUser.id}</td>
      <td>${infoUser.email}</td>
    </tr>
  </table>
</body>
</html>