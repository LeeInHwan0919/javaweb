<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 리스트</title>
</head>
	<%@ include file="./header.jsp" %>
<body>
${paging}
	<div id="container" class="container">
	<form action="./memberListMAV.do" method="post" id="frmPaging">
		<input type="text" name="index" id="index" value="${paging.index}">
		<input type="text" name="pageNum" id="pageNum" value="${paging.pageNum}">
		<input type="text" name="listNum" id="listNum" value="${paging.listNum}">
		<div id="select">
		  <span>
		  	<select class="btn btn-primary" id="listCount" name="listCount" onchange="listCnt()">
		  		<option value="5">5</option>
		  		<option value="10">10</option>
		  		<option value="15">15</option>
		  	</select>
		  </span>
		</div>
		<div style="text-align: center;">
      	 <ul class="pagination pagination-sm">
      	 	<li><a href="#" onclick="pageFir()"><span class="glyphicon glyphicon-fast-backward"></span></a></li>
      	 	<li><a href="#" onclick="pagePre(${paging.pageNum}, ${paging.pageList})"><span class="glyphicon glyphicon-step-backward"></span></a></li>      	 	
			   <c:forEach var="i" begin="${paging.pageNum}" end="${paging.count}" step="1">
			   <li><a href="#" onclick="pageIdx(${i})">${i}</a></li>
			   </c:forEach>
      	 	<li><a href="#" onclick="pageNex(${paging.pageNum},${paging.total},${paging.listNum},${paging.pageList})"><span class="glyphicon glyphicon-step-forward"></span></a></li>
      	 	<li><a href="#" onclick="pageLa(${paging.pageNum},${paging.total},${paging.listNum},${paging.pageList})"><span class="glyphicon glyphicon-fast-forward"></span></a></li>    
		  </ul>
      </div>
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
		        <td><button class="btn btn-default">${user.delflag=="Y"?"복구":"탈퇴"}</button></td>
		      </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<div>
		  <input class="btn btn-warning btn-block btn-lg" type="button" value="돌아가기" onclick="history.back(-1)">
		</div>
		</form>
	</div>
	<script type="text/javascript">
	function pageFir(){
		console.log("처음 페이지로 이동");
		var index = document.getElementById("index");
		var pageNum = document.getElementById("pageNum");
		
		index.value = 0;
		pageNum.value = 1;
		pagingForm()
	}
	function pagePre(pNum, pageList){
		console.log("이전 그룹");
		if(0 < pNum - pageList){
			pNum -= pageList;
			var index = document.getElementById("index");
			var pageNum = document.getElementById("pageNum");
			
			index.value = pNum - 1;
			pageNum.value = pNum;
		}
		pagingForm()
		}
	function pageIdx(idx){
		console.log("입력 받은 index 값 : " + idx);
		var index = document.getElementById("index");
		index.value = idx - 1;
		pagingForm()
	}
	function pageNex(pNum,total,listNum,pageList){
		console.log("다음 페이지");
		var idx = Math.ceil(total/listNum); // 31/5 = 7
		var max = Math.ceil(idx/pageList); // 2 그룹
		
		if(max*pageList > pNum+pageList){
			pNum += pageList;
			
			var index = document.getElementById("index");
			var pageNum = document.getElementById("pageNum");
			
			index.value = pNum - 1;
			pageNum.value = pNum;
		}
		pagingForm()
	}
	function pageLa(pNum,total, listNum, pageList){
		console.log("마지막 페이지");
		var idx = Math.ceil(total/listNum); // 31/5 7 index
		var max = Math.ceil(idx/pageList); // 12345 | 67 => 2 묶음
		
		while(max*pageList > pNum+pageList){
			pNum += pageList;			
		}
			var index = document.getElementById("index");
			var pageNum = document.getElementById("pageNum");
			
			index.value = idx - 1;
			pageNum.value = pNum;
			pagingForm()
	}
	
	function pagingForm(){
		document.getElementById("frmPaging").submit();
	}
	
	function listCnt(){
		document.getElementById("index").value = 0;
		document.getElementById("pageNum").value = 1;
		document.getElementById("listNum").value = document.getElementById("listCount").value;
		pagingForm();
	}
	
	  window.onload = function(){
		  var buttons = document.getElementsByTagName("button");
		  console.log(buttons.length);

		  for(var i=0; i<buttons.length;i++){
			  console.log(buttons[i].innerHTML);
			  buttons[i].onclick = function(){
				 var id = this.parentNode.parentNode.childNodes[1].innerHTML;
				 // this 는 선택된 객체의 DOM
				 var tmp = this;
// 				  console.log(this.innerHTML);
// 				  console.log(this.parentNode.parentNode.childNodes[1].innerHTML)
// 				  console.log(this.parentNode.parentNode.childNodes[3].innerHTML)
				  console.log("tmp : " + tmp);
				  
// 				  var id = this.parentNode.parentNode.childNodes[1].innerHTML;
// 				  var delflag = this.parentNode.parentNode.childNodes[3].innerHTML;
				  
// 				  $.ajax({
// 					 url:"./changeUser.do",
// 					 method:"post",
// 					 data:{
// 						 id : id,
// 						 delflag : delflag
// 					 },
// 					 success:function(data){
// 						this.parentNode.parentNode.childNodes[3].innerHTML = 
// 					  	(this.parentNode.parentNode.childNodes[3].innerHTML == "Y") ? "N" : "Y";
				  
// 						  this.innerHTML = (this.innerHTML == "복구" ? "탈퇴" : "복구");
// 					 },
// 					 error:function(){
// 						 console.log("에러");
// 					 }
// 				  })

				$.ajax({
					// this 는 jquery 의 $ajax 자체를 의미
					url:"./changeUser.do",
					type:"post",
					data:{"id":id},
					success:function(msg){
						console.log(msg.isc);
						console.log(tmp);
						if(msg.isc){
							tmp.parentNode.parentNode.childNodes[3].innerHTML = 
		 					(tmp.parentNode.parentNode.childNodes[3].innerHTML == "Y") ? "N" : "Y";
						  
							tmp.innerHTML = (tmp.innerHTML == "복구" ? "탈퇴" : "복구");	
						}
					},
					error:function(){
						alert("잘못된 요청");
					}
				});
			  };
		  }
	  }
	  
	  $(document).ready(function(){
			var listNum = $("#listNum").val();
			
			$("#listCount option").each(function(){
				if(listNum == $(this).val()){
					$(this).prop("selected",true);
				}else{
					$(this).prop("selected",false);
				}
			})
		})
	  
	  
	</script>
</body>
</html>