<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글작성 폼</title>
</head>
<script type="text/javascript" src="./dist/js/HuskyEZCreator.js" charset="utf-8"></script> <!-- naver editor 사용 -->
<script type="text/javascript" src="./js/writeForm.js"></script>
<%@ include file="./header.jsp" %>
<body>
<div id="container">
	<div><a href="javascript:history.back(-1)">뒤로가기</a></div>
	<form name="wform" action="./boardInsert.do" method="post">
		<table class="table table-bordered form-group" >
			<thead>
				<tr>
					<th style="width:100px">아이디</th>
					<td><input type="text" name="id" id="id" class="form-control" value="${rows.id}" readonly="readonly"></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title" class="form-control"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea cols="50" name="ir1" id="ir1" class="form-control"></textarea>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<div id="convertView"></div>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" style="text-align: center">
						<input class="btn btn-primary active" type="button" value="새글작성" onclick="validationForm()">
						<input class="btn btn-primary active" type="reset" value="다시작성">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
</body>
<%@ include file="./footer.jsp" %>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "ir1",
 sSkinURI: "./dist/SmartEditor2Skin.html",
 fCreator: "createSEditor2",
	 htParams : {
		 //툴바 사용 여부
		 bUseToolbar : true,
		// 입력창 크기 조절바 사용 여부
		 bUseVerticalResizer : true,
		//모드 탭(Editor | HTML | TEXT) 사용 여부
		 bUseModeChanger : true
		 
	 }
});
</script>
</html>