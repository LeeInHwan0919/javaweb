<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 체크</title>
<script type="text/javascript">

  function result01(){
	  console.log("HttpSession과 @SessionAttribute를 server Console에서 확인");
	  location.href="./result01.do";  
  }
  
  function result02(){
	  console.log("HttpSession만 확인");
	  location.href="./result02.do";  
  }
  
  function result03(){
	    console.log("HttpSession과 @SessionAttribute를 server Console에서 확인");
	    location.href="./result03.do";  
	  }
	  
	  function result04(){
	    console.log("HttpSession만 확인");
	    location.href="./result04.do";  
	  }
  
</script>
</head>
<body>
  <button onclick="javascript:location.href='./init.do'">모든 세션 추가</button>

  <h1>${sessionScope.sessionTest}</h1>
  <hr>
  <h1>${sessionScope.httpsessionTest}</h1>
  
  <div>
  <h3>같은 Controller 확인</h3>
    <ul>
      <li>
        <a href="./test01.do">test01.do : @SessionAttribute 삭제</a>
      </li>
      <li>
        <a href="./test02.do">test02.do : HttpSession 삭제</a>
      </li>
      <li>
        <button onclick="result01()">결과 확인 Result01</button>
      </li>
      <li>
        <button onclick="result02()">결과 확인 Result02</button>
      </li>
    </ul>
  </div>
  <hr>
  <hr>
  <div>
    <h3>다른 Controller 확인</h3>
    <ul>
      <li>
        <a href="./test03.do">test03.do : @SessionAttribute 삭제</a>
      </li>
      <li>
        <a href="./test04.do">test04.do : HttpSession 삭제</a>
      </li>
      <li>
        <button onclick="result03()">결과 확인 Result03</button>
      </li>
      <li>
        <button onclick="result04()">결과 확인 Result04</button>
      </li>
    </ul>
  </div>
</body>
</html>