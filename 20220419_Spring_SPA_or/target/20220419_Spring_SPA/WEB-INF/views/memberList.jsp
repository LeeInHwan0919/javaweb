<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원전체리스트</title>
</head>
<%@ include file="./header.jsp" %>

<body>
  <div id="container" class="container">
    <table class="table table-hover">
      <thead>
        <tr class="warning">
          <th>연번</th>
          <th>아이디</th>
          <th>이름</th>
          <th>삭제여부</th>
          <th>권한</th>
          <th>등록일</th>
          <th>회원삭제</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="user" items="${mLists}" varStatus="vs">
          <tr><td>${vs.count}</td><td>${user.id}</td><td>${user.name}</td><td>${user.delflag}</td>
            <td>${user.auth == "U"?"사용자":"관리자"}</td>
            <td>${user.regdate}</td>
            <td><button type="submit" class="btn btn-default">${user.delflag == "Y"?"복구":"탈퇴"}</button></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div>
      <input class="btn btn-warning btn-block btn-lg" type="button" value="돌아가기" onclick="history.back(-1)">
    </div>
  </div>
  <script type="text/javascript">
    window.onload = function(){
      var buttons = document.getElementsByTagName("button");
      console.log(buttons.length);
      for (var i = 0; i < buttons.length; i++) {
			buttons[i].onclick=function(){
			console.log(this.innerHTML);
			console.log(this.parentNode.parentNode.childNodes[1].innerHTML);
			console.log(this.parentNode.parentNode.childNodes[3].innerHTML);
			var id = this.parentNode.parentNode.childNodes[1].innerHTML;
			// this 선택된 객체의 DOM
			var tmp = this;
			
			$.ajax({
				//this는 jquery의 $.ajax 자체를 이야기 함 
				url:"./changeUser.do",
				type:"post",
				data:{"id":id},
				success:function(msg){
					console.log(msg.isc);
					console.log(tmp);
					if(msg.isc){
					tmp.parentNode.parentNode.childNodes[3].innerHTML
					= (tmp.parentNode.parentNode.childNodes[3].innerHTML=="Y")?"N":"Y";
					tmp.innerHTML = (tmp.innerHTML == "복구")?"탈퇴":"복구";
					alert("기모띠");
					}
					
				},
				error:function(){
					alert("잘못된 요청입니다.");
				}
			});
			
			
			
			}
      }
      
    }
  
  
  </script>
</body>
</html>