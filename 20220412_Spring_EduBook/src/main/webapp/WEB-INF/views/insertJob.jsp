<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./insertJob.do" method="post">
		<table>
		
			<tr>
				<td>JOB_ID</td><td><input type="text" name="job_id"></td>
			</tr>
			<tr>
				<td>JOB_TITLE</td><td><input type="text" name="job_title"></td>
			</tr>
			<tr>
				<td>MIN_SALARY</td><td><input type="text" name="min_salary"></td>
			</tr>
			<tr>
				<td>MAX_SALARY</td><td><input type="text" name="max_salary"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>