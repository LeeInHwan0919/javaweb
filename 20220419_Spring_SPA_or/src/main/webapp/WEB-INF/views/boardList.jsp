<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 페이지</title>
</head>
<%@include file="./header.jsp" %>
<body>

	<div id="container" class="container">
		<form action="#" method="post" id="frm" onsubmit="return chkBox()">
			<div id="select">
			<span>
				<select class="btn btn-primary" id="list" name="list" onchange="pageList()">
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
				</select>
			</span>
				<!-- select listNum (게시글의 갯수)을 변경하는 -->
				<c:if test="${mem2.auth eq 'A'}">
					<span><input type="submit" class="btn btn-danger" value="다중 삭제"></span>
				</c:if>
				<span></span>
			</div>

			
			<table class="table table-bordered">
					<thead>
						<tr>
							<c:if test="${mem2.auth eq 'A'}">
								<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
							</c:if>
							<th>글 번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<c:if test="${mem2.auth eq 'A'}">
								<th>삭제여부</th>
							</c:if>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<jsp:useBean id="boardList" class="com.min.edu.bean.ListBean" scope="page"/>
						<jsp:setProperty property="lists" name="boardList" value="${lists}"/>
						<jsp:setProperty property="mem" name="boardList" value="${mem2}"/>
						<jsp:getProperty property="listForm" name="boardList"/>
					</tbody>
			</table>
			
		<input type="text" name="index" id="index" value="${row.index}">
         <input type="text" name="pageNum" id="pageNum" value="${row.pageNum}">
         <input type="text" name="listNum" id="listNum" value="${row.listNum}">
			
			
			<div style="text-align: center;">
				<ul class="pagination">
            <li><a href="#" onclick="pageFirst()"><span class="glyphicon glyphicon-backward"></span></a></li>
            <li><a href="#" onclick="pagePrev(${row.pageNum},${row.pageList})"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
            <c:forEach var="i" begin="${row.pageNum}" end="${row.count}" step="1">
                <li ${(i-1) == row.index?"class='active'":""}><a href="#" onclick="pageIndex('${i}')">${i}</a></li>
            </c:forEach>
            <li><a href="#" onclick="pageNext(${row.pageNum},${row.total},${row.listNum},${row.pageList})"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
            <li><a href="#" onclick="pageLast()"><span class="glyphicon glyphicon-forward"></span></a></li>
           </ul>

			</div>
			
		</form>
	</div>
</body>
<script type="text/javascript">
		$('.collapse').on('show.bs.collapse',function(){
			   $('.collapse.in').collapse('hide');
			});
// 	$("a").on("click",function(){
// 		console.log("작동");
// 		var click = $(this).prop("href");
// 		var id = click.substring(click.lastIndexOf("#")+1);
// 		console.log("ID값", id);
		
// 		var contentRow = $(".panel-collapse");
// 		for (var i = 0; i < contentRow.length; i++) {
// 			if(id != contentRow[i].id){
// 				contentRow[i].className = "panel-collapse collapse";
				

// 			}
// 		}
// 	});
</script>
</html>








