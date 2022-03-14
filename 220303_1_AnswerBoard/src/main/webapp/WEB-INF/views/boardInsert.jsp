<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성 폼</title>
</head>
<script type="text/javascript" src="./dist/js/service/HuskyEZCreator.js"
	charset="utf-8"></script>
<!-- naverEditor 사용 -->
<script type="text/javascript" src="./js/writeForm.js"></script>
<%@ include file="./header.jsp"%>
<body>
	<div id="container">
		<div>
			<a href="javascript:history.back(-1)">뒤로 가기</a>
		</div>
		<form name="wform" action="./boardInsert.do" method="post">
			<table class="table table-bordered form-group" style="width:1000px;">
				<thead>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id" id="id"
							value="<%=loginInfo.getId()%>" readonly class="form-control"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" id="title"
							class="form-control"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea cols="50" name="ir1" id="ir1"
								style="width: 800px" class="form-control"></textarea></td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<div id="convertView"></div>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" style="text-align: center"><input
							class="btn btn-primary active" type="button" value="새글 작성"
							onclick="validationForm()"> <input
							class="btn btn-success active" type="reset" value="다시작성">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<%@ include file="./footer.jsp"%>
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
		 oAppRef: oEditors,
		 elPlaceHolder: "ir1",
		 sSkinURI: "./dist/SmartEditor2Skin.html",
		 fCreator: "createSEditor2",
		 htParams : {
			 // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			 bUseToolbar : true,    
			 // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			 bUseVerticalResizer : false,  
			 // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)			
			 bUseModeChanger : false,
			 
			 fOnAppLoad:function() {
// 				$("iframe").css("width","100%").css("heigth","399px");		
			 }
		 }
		});
		
		
	</script>
</body>
</html>