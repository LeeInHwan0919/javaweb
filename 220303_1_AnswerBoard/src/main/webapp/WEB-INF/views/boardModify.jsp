<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 폼</title>
</head>
<script type="text/javascript" src="./dist/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<%
    AnswerBoardDto dto = (AnswerBoardDto)request.getAttribute("dto");
%>
<%@include file="./header.jsp" %>
<body>
<div id="container">
    <form action="./boardModify.do" method="post">
        <input type="hidden" value="<%= dto.getSeq()%>" name="seq">
        <table class="table">
        <tbody>
            <tr>
                <th class="info">아이디</th>
                <td><%=dto.getId()%></td>
            </tr>
            <tr>
                <th class="info">제목</th>
                <td><%=dto.getTitle() %></td>
            </tr>
            <tr>
                <th colspan="2" >내용</th>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="ir1" id="ir1" rows="10" cols="100"><%=dto.getContent() %></textarea>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <th colspan="2" style="text-align: center;">
                <input class="btn btn-success"  type="button" value="수정완료" onclick="save()" >
                <input class="btn btn-success" type="button" value="돌아가기" onclick="history.back(-1)">
                </th>
            </tr>
        </tfoot>
        </table>
    </form>
</div>
<%@include file="./footer.jsp" %>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "ir1",
 sSkinURI: "./dist/SmartEditor2Skin.html",
 fCreator: "createSEditor2"
});
function save() {
    oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
    document.forms[0].submit();
}
</script>
</body>
</html>