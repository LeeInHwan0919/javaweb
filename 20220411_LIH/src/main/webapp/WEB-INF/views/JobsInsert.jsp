<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Jobs 등록 폼</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <form action="./JobsInsert.do" method="post">
    <table class="table">
      <thead>
        <tr>
          <th>아이디 : </th>
          <th>제목 : </th>
          <th>최소 급여 : </th>
          <th>최대 급여 : </th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><input type="text" id="job_id" name="job_id" placeholder="아이디를 입력하세요."></td>
          <td><input type="text" id="job_title" name="job_title" placeholder="제목을 입력하세요."></td>
          <td><input type="text" id="min_salary" name="min_salary" placeholder="최소급여를 입력하세요."></td>
          <td><input type="text" id="max_salary" name="max_salary" placeholder="최대급여를 입력하세요."></td>
          <td><input class="btn btn-success" type="submit" value="등록하기"></td>
          <td><input class ="btn btn-danger"  type="button" value="취소"  onclick="javascript:history.back(-1)"></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
</body>
</html>