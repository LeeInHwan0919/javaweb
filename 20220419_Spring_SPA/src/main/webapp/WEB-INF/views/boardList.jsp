<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 페이지</title>
</head>
<%@ include file="./header.jsp" %>

<body>
  <div id="container" class="container">
    <form action="#" method="post" id="frm" onsubmit="return chkBox()">
      <div id="select">
      <!-- select listNum의 값을 변경 -->
      <c:if test="${mem2.auth eq 'A'}">
        <span><input type="submit" class="btn btn-danger" value="다중 삭제"></span>
      </c:if>
      </div>
      
      <table class="table table-bordered">
		<thead>
		  <tr>
		    <c:if test="${mem2.auth eq 'A'}">
		      <th><input type="checkbox" onclick="checkAll(this.checked)"></th>
		    </c:if>
		    <th>글번호</th>
		    <th>제목</th>
		    <th>작성자</th>
		    <th>조회수</th>
		    <c:if test="${mem2.auth eq 'A'}">
		      <th>삭제 여부</th>
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
      
<!--       <input type="hidden" name="index" id="index"> -->
<!--       <input type="hidden" name="pageNum" id="pageNum"> -->
<!--       <input type="hidden" name="listNum" id="listNum"> -->
      <input type="text" name="index" id="index" value="index : ${row.index}"> <!-- 한 페이지에서 시작번호 -->
      <input type="text" name="pageNum" id="pageNum" value="pageNum : ${row.pageNum}"> <!-- 그룹의 시작번호 -->
      <input type="text" name="listNum" id="listNum" value="listNum : ${row.listNum}"> <!-- 페이지 번호 -->
      
      <div style="text-align: center;">
        <ul class="pagination pagination-lg">
        <li><a href="#" onclick="pageFirst()"><span class="glyphicon glyphicon-fast-backward"></span></a></li>
        <li><a href="#" onclick="pagePrev()"><span class="glyphicon glyphicon-step-backward"></span></a></li>
        
        <c:forEach var="i" begin="${row.pageNum}" end="${row.count}" step="1">
		  <li><a href="#" onclick="pageIndex('${i}')">${i}</a></li>
		</c:forEach>
		
		<li><a href="#" onclick="pageNext()"><span class="glyphicon glyphicon-step-forward"></span></a></li>
        <li><a href="#" onclick="pageLast()"><span class="glyphicon glyphicon-fast-forward"></span></a></li>
		</ul>
      </div>
      
    </form>
  </div>
</body>
<script type="text/javascript">
$("a").on("click",function(){
	console.log("작동");
	var click = $(this).prop("href");
	var id = click.substring(click.lastIndexOf("#")+1);
	console.log("id 값:"+id);
	
	var contentRow = $(".panel-collapse");
	for (var i = 0; i < contentRow.length; i++) {
		if(id != contentRow[i].id){
			contentRow[i].className="panel-collapse collapse";
// 			contentRow.slideUp();
		}		
	}
});

</script>
</html>






