<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">

<style>


.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
}
</style>

<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				  <form action="./signUp.do" method="post">
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="name">이름</label> 
							<input type="text" class="form-control" id="name" name="name" required>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="id">아이디</label> 
							<input type="text" class="form-control" id="id" name="id" required>
							<div class="invalid-feedback">아이디를 입력해주세요.</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="email">이메일</label> <input type="text"
							class="form-control" id="email" name="email" placeholder="aaaa@naver.com"
							required>
						<div class="invalid-feedback">이메일을 입력해주세요.</div>
					</div>
					<div class="mb-3">
						<label for="pw">비밀번호</label> <input type="text"
							class="form-control" id="pw" name="pw" placeholder="password" required>
						<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
					</div>
					<hr class="mb-4">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="aggrement"
							required> <label class="custom-control-label"
							for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
					</div>
					<div class="mb-4"></div>
					<input type="submit" class="btn btn-primary btn-lg btn-block" value="가입완료">
					  </form>
			</div>
		</div>
	</div>
	<script> 
	window.addEventListener('load', () => { const forms = document.getElementsByClassName('validation-form');
	Array.prototype.filter.call(forms, (form) => { form.addEventListener('submit', function (event) {
		if (form.checkValidity() === false) { 
			event.preventDefault(); event.stopPropagation(); 
		    } 
		  form.classList.add('was-validated'); 
		  },false); 
	  });
	
	},false); </script>
</body>

</html>