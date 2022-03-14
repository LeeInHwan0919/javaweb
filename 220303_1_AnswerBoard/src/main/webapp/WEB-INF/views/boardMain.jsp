<%@page import="com.min.edu.dto.UserVO"%>
<%@page import="com.min.edu.dto.AnswerBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체보기</title>
</head>
<!-- 동적 -->
<%-- <jsp:include page="./header.jsp"> --%>
<%-- 	<jsp:param value="lists" name="lists"/> --%>
<%-- </jsp:include> --%>
<!-- 정적 -->

<%
	List<AnswerBoardDto> lists = (List<AnswerBoardDto>)request.getAttribute("lists");
%>
	<%@ include file="./header.jsp" %> 
	
	<!-- 위치는 합쳐지기 때문에 위치에 맞게 body와 head 사이에 작성 -->
	
	<jsp:useBean id="pb" class="com.min.edu.comm.PhotoBean" scope="page"/>
	<jsp:useBean id="dp" class="com.min.edu.comm.DatePatternBean" scope="page"/>
<body>
<img alt="답글" src="./image/reply.png">
	<div id="container"> 							
		<form action="./boardDelete.do" method="post" onsubmit="return chsSubmit()">
			<table class="table table-hover">
				<thead>
					<tr class="info">
						<th><input type="checkbox" id="allCheck" onclick="checkAll(this.checked)" class="allCheckBox"></th>
						<th>연번</th>
						<th>아이디</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<% if(lists.size() == 0){ %>
						<tr>
							<td colspan="5" style="color:red; text-align: center;">작성된 글이 존재하지 않습니다.</td>
						</tr>						
					<% }else{ 
							for(int i = 0; i < lists.size(); i++){
								%>
								<tr>
									<td><input type="checkbox" name="ch" class="ch" value="<%=lists.get(i).getSeq() %>"></td>
									<td><%=lists.size() - i%></td>
									<td><%=lists.get(i).getId() %></td>
										<%
											if(lists.get(i).getDelflag().equalsIgnoreCase("Y")) {
												%>												
													<td style="color: red; font-size:0.5em; text-align:center;">관리자에 의해 삭제된 글</td>
												<%
											}else{
												%>
													<td>
														<a href="./boardDetail.do?seq=<%=lists.get(i).getSeq() %>">
															<jsp:setProperty property="depth" name="pb" value="<%=lists.get(i).getDepth() %>"/>
															<jsp:getProperty property="photo" name="pb"/>
															<%=lists.get(i).getTitle() %>
														</a>
													</td>
												<% 
										}
										%>
							
									<td>
										<jsp:setProperty property="regdate" name="dp" value="<%=lists.get(i).getRegdate() %>"/> 
										<jsp:getProperty property="datePattern" name="dp"/>
									</td>
								</tr>
								<%	
							}
					   } %>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" style="text-align: certer;">
							<input class="btn btn-info btn-primary" type="submit" value="다중삭제">
							<input class="btn btn-info btn-danger" type="button" value="새글입력"
                           					onclick="location.href='./boardInsert.do'">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
	<%@ include file="./footer.jsp" %>
</html>



