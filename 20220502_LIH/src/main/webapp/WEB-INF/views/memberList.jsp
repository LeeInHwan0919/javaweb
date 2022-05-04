<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
</head>
<%@ include file="./header.jsp" %>
<body>
<section class="notice">
   
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">아이디</th>
                    <th scope="col" class="th-title">이름</th>
                    <th scope="col" class="th-content">이메일</th>
                    <th scope="col" class="th-content">권한</th>
                    <th scope="col" class="th-content">삭제여부</th>
                    <th scope="col" class="th-content">작성날짜</th>
                    <th scope="col" class="th-num">삭제/복구</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${memberLists}" var="list">
	 			<tr>
	 			 	 <td>${list.id}</td>
	 			 	 <td>${list.name}</td>
	 			 	 <td>${list.email}</td>
	 			 	 <td>${list.auth}</td>
	 			 	 <td>${list.delflag}</td>
	 			 	 <td>${list.regdate}</td>
	 			 	 <td><button>삭제/복구</button></td>
				</tr>
			</c:forEach>
                </tbody>
            </table>
              <input type="hidden" name="index" id="index" value="${row.index}">
		      <input type="hidden" name="pageNum" id="pageNum" value="${row.pageNum}">
		      <input type="hidden" name="listNum" id="listNum" value="${row.listNum}">
		      
		      <div style="text-align: center;">
		      	 <ul class="pagination pagination-lg">
		      	 	<li><a href="#" onclick="pageFirst()"><span class="glyphicon glyphicon-fast-backward"></span></a></li>
		      	 	<li><a href="#" onclick="pagePrev(${row.pageNum}, ${row.pageList})"><span class="glyphicon glyphicon-step-backward"></span></a></li>      	 	
		      	 	<c:forEach var="i" begin="${row.pageNum}" end="${row.count}" step="1">
					   <li ${(i-1) == row.index ? "class='active'" : ""}><a href="#" onclick="pageIndex('${i}')">${i}</a></li>
		      	 	</c:forEach>
		      	 	<li><a href="#" onclick="pageNext(${row.pageNum},${row.total},${row.listNum},${row.pageList})"><span class="glyphicon glyphicon-step-forward"></span></a></li>
		      	 	<li><a href="#" onclick="pageLast()"><span class="glyphicon glyphicon-fast-forward"></span></a></li>    
				  </ul>
		      </div>
        </div>
    </div>

</section>
</body>
</html>