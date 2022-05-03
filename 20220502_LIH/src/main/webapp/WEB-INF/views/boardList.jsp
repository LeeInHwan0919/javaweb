<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지(게시판)</title>
</head>
<%@ include file="./header.jsp" %>
<body>
<section class="notice">
   
    <div id="board-list">
        <div class="container">
        <form action="#" method="post" id="frm" onsubmit="return chkBox()">
		        <div id="select">
		      	<c:if test="${member.auth eq 'A'}">
		          <span><input type="submit" class="btn btn-danger" value="다중삭제"></span>      
		      	</c:if>
		      </div>
            <table class="board-table">
                <thead>
                <tr>
                	<c:if test="${member.auth eq 'A'}">
		              <th>
		                <input type="checkbox" id="checkAll" onclick="checkAlls(this.checked)">
		              </th>
		            </c:if>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">작성자</th>
                    <th scope="col" class="th-content">제목</th>
                    <th scope="col" class="th-content">조회수</th>
                    <c:if test="${member.auth eq 'A'}">
                      <th scope="col" class="th-content">삭제여부</th>
                    </c:if>
                    <th scope="col" class="th-content">작성날짜</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lists}" var="list">
	 			<tr>
	 				 <c:if test="${member.auth eq 'A'}">
		               <td>
		                 <input type="checkbox" name="chk" value="${list.seq}">
		               </td>
		             </c:if>
	 				 <td>글번호</td>
	 			 	 <td>${list.id}</td>
	 			 	 <td><a href="./boardDetail.do?seq=${list.seq}">${list.title}</a>
	 			 	 <input type="hidden" name="seq" id="seq" value="${list.seq}"></td>
	 			 	 <td>${list.readcount}</td>
	 			 	 <c:if test="${member.auth eq 'A'}">
	 			 	   <td>${list.delflag}</td>
	 			 	 </c:if>
	 			 	 <td>${list.regdate}</td>
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
		      </form>
        </div>
    </div>

</section>
</body>
</html>