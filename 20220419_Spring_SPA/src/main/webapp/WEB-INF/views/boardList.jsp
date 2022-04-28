<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 페이지</title>
</head>
<%@ include file="./header.jsp"%>
<body>
	<div id="container" class="container">
		<form action="#" method="post" id="frm" onsubmit="return chkBox()">
			<div id="select">
				<!-- select listNum 의 값을 변경 -->
				<span> <select class="btn btn-primary" id="list" name="list"
					onchange="pageList()">
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
				</select>
				</span>
				<c:if test="${mem2.auth eq 'A'}">
					<span><input type="submit" class="btn btn-danger"value="다중삭제"></span>
				</c:if>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<c:if test="${mem2.auth eq 'A'}">
							<th><input type="checkbox" id="checkAll" onclick="checkAlls(this.checked)"></th>
						</c:if>
						<th>글번호</th>
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
					<jsp:useBean id="boardList" class="com.min.edu.bean.ListBean" scope="page" />
					<jsp:setProperty property="lists" name="boardList" value="${lists}" />
					<jsp:setProperty property="mem" name="boardList" value="${mem2}" />
					<jsp:getProperty property="listForm" name="boardList" />
				</tbody>
			</table>

			<input type="text" name="index" id="index" value="${row.index}">
			<input type="text" name="pageNum" id="pageNum" value="${row.pageNum}">
			<input type="text" name="listNum" id="listNum" value="${row.listNum}">

			<div style="text-align: center;">
				<ul class="pagination pagination-lg">
					<li><a href="#" onclick="pageFirst()"><span
							class="glyphicon glyphicon-fast-backward"></span></a></li>
					<li><a href="#"
						onclick="pagePrev(${row.pageNum}, ${row.pageList})"><span
							class="glyphicon glyphicon-step-backward"></span></a></li>
					<c:forEach var="i" begin="${row.pageNum}" end="${row.count}"
						step="1">
						<li ${(i-1) == row.index ? "class='active'" : ""}><a href="#"
							onclick="pageIndex('${i}')">${i}</a></li>
					</c:forEach>
					<li><a href="#"
						onclick="pageNext(${row.pageNum},${row.total},${row.listNum},${row.pageList})"><span
							class="glyphicon glyphicon-step-forward"></span></a></li>
					<li><a href="#" onclick="pageLast()"><span
							class="glyphicon glyphicon-fast-forward"></span></a></li>
				</ul>
			</div>

		</form>
		<!-- 새글 쓰기 모달 -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#write">새글쓰기 모달</button>
		<div class="modal fade" id="write" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">게시글 입력</h4>
					</div>
					<div class="modal-body">
						<form method="post" id="frmWriter"></form>
						<p>Some text in the modal.</p>
					</div>
					<!--         <div class="modal-footer"> -->
					<!--           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
					<!--         </div> -->
				</div>
			</div>
		</div>
		<!-- 모달 영역 끝 -->


		<!-- 글 수정 모달 -->
<!-- 		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" -->
<!-- 			data-target="modify">글 수정 모달</button> -->
		<div class="modal fade" id="modify" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">게시글 수정</h4>
					</div>
					<div class="modal-body">
						<form method="post" id="frmModify">
  						  <input type="text">
						</form>
					</div>
<!-- 					        <div class="modal-footer"> -->
<!-- 					          <button type="button" class="btn btn-default" onclick="modalHide()">감취기</button> -->
<!-- 					        </div> -->
				</div>
			</div>
		</div>
		<!-- 모달 영역 끝 -->
		
		
		<!-- 답글 모달 -->
		<div class="modal fade" id="reply" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">답글 모달</h4>
					</div>
					<div class="modal-body">
						<form method="post" id="frmReply"></form>
					</div>
				</div>
			</div>
		</div>
		<!--  답글 모달 영역 끝 -->






	</div>
</body>
<script type="text/javascript">
	$('.collapse').on('show.bs.collapse', function(){
		$('.collapse.in').collapse('hide');
	})
</script>
</html>