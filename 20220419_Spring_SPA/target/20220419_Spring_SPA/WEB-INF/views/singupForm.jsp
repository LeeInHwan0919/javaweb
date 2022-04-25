<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css"/>
<link rel="stylesheet" type="text/css" href="./css/common.css"> 

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<script type="text/javascript" src="./js/signup.js"></script>
</head>
<body>

	<div id="container">
	  <div id="title">
	    <img alt="logo" src="./images/logo.png">
	  </div>
	  
	  <input type="hidden" id="chkval" value="0">
	  
	  <form action="./signup.do" method="post" onsubmit="return check()">
	    <div id="info">
	      <div id="leftInfo">정보입력</div>
	      <div id="centerInfo">
			   <input type="text" id="id" name="id" placeholder="아이디" required="required" maxlength="20"><br>
			   <input type="text" id="name" name="name" placeholder="성명"><br>
			   <span id="result"></span>
			   <input type="password" id="password" name="pw" placeholder="비밀번호 입력" required="required"><br>
			   <input type="password" id="passOk" placeholder="비밀번호 확인" required="required"><br>
	      </div>
	      <div id="bottomInfo">
		      <div class="usm-agree">
		      <input type="checkbox" id="i_agree2" name="i_agree2" value="1">
		      <label for="i_agree2">개인정보 수집 및 이용 안내 
		      <strong> (필수)</strong>
		      </label>
		   </div>
			  <div class="usm-join-box">
		      <dl>
		        <dt><strong>개인정보보호법 제15조(개인정보의 수집·이용)에 의거 홈페이지 회원가입을 위한 개인정보를 다음과 같이 수집·이용하고자 합니다.</strong></dt>
		        <br>
		        <dt><strong>[개인정보의 수집 및 이용 목적]</strong></dt>
		        <dd>충청북도학교통합홈페이지는 다음과 같은 목적을 위하여 개인정보를 수집, 이용합니다.</dd>
		        <dd>- 충청북도학교통합홈페이지 통합 회원관리</dd>
		        <dd>- 제한적 본인 확인제에 따른 본인확인, 비밀번호 분실 시 본인확인 등</dd>
		        <dd>- 개인식별, 부정이용 방지, 비인가 사용방지, 가입의사 확인</dd>
		        <dd>- 만14세 미만 회원의 법정 대리인 동의여부 확인</dd>
		        <dd>- 불만처리 등 민원처리, 공지사항 전달</dd>
	
		        <dt><strong>[개인정보 수집에 관한 사항]</strong></dt>
		        <dd>① 필수항목 : 이름, 아이디, 비밀번호, 학년반(학생), 본인확인인증정보, 14세미만 법정대리인 인증정보</dd>
		        <dd>② 선택항목 : 생년월일, 졸업년도(졸업생)</dd>
	
		        <dt><strong>[개인정보 보유 및 이용기간]</strong></dt>
		        <dd class="usm-clr-blue">귀하께서 입력하신 개인정보는 2년간 보유되며, 가입 후 매 2년이 되는 시점에 회원의 동의에 의해 그 기간은 연장되며, 회원 탈퇴시 개인정보는 그 즉시 삭제됩니다.</dd>
		        <dd class="usm-clr-blue">삭제 요청 및 홈페이지 탈퇴 시 까지의 개인정보는 회원으로 가입 한 학교와 충청북도교육연구정보원 개인정보처리방침에 의거 보유 및 이용됩니다.</dd>
		        <dd class="usm-clr-blue">다만, 탈퇴자의 아이디는 동일한 아이디의 중복 가입을 방지하기 위해 보존하며, 기타 관계법령의 규정에 의하여 보존할 필요가 있는 경우 관계법령에 따릅니다.</dd>
		        
		        <dt><strong>[개인정보 수집·이용에 대한 동의를 거부할 권리]</strong></dt>
		        <dd>귀하께서는 상기의 개인정보 수집 및 이용에 대하여 동의를 거부할 수 있습니다.</dd>
		        <dd>필수항목의 경우 회원 가입 시 필요한 항목으로 동의 거부 시 회원가입이 제한되며, 선택 항목은 동의하지 않아도 회원가입 및 서비스 거부를 하지 않습니다.(선택항목에 대하여 차후에 회원정보수정을 통하여 정보를 입력할 수 있으며 입력된 항목은 동의를 한 것으로 간주 합니다.)</dd>
		      </dl>
			</div>
	      </div>
	      <br>
	      <div id="bottom">
	        <input class="btn btn-success" type="submit" value="동의하고 회원가입">
	        <input class="btn btn-primary" type="button" value="돌아가기" onclick="javascript:history.back(-1)">
	      </div>
	    </div>
	  </form>
	</div>
</body>
</html>