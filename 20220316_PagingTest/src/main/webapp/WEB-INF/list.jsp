<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.min.edu.vo.PageVo"%>
<%@page import="com.min.edu.vo.PlayerVo"%>
<%@page import="java.util.List"%>
<%@page import="com.min.edu.dao.PlayerImpl"%>
<%@page import="com.min.edu.dao.IPlayer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
	th,td{
		text-align: center;
	}
</style>
</head>
<%
	PageVo pages = new PageVo();
	IPlayer player = new PlayerImpl();
	
	int total = (int)request.getAttribute("total");
	int cntPerPage = (int)request.getAttribute("cntPerPage");
	int nowPage = (int)request.getAttribute("nowPage");
	int startNum = (int)request.getAttribute("startNum");
	int endNum = (int)request.getAttribute("endNum");
	int endPage = (int)request.getAttribute("endPage");
	int startPage = (int)request.getAttribute("startPage");
	int finalPage = (int)request.getAttribute("finalPage");
	List<PlayerVo> playerList = (List<PlayerVo>)request.getAttribute("playerList");
// 	1 0    11 0    41   시작번호 -1 부터 끝번호 까지
// 	2 1    12 1         시작번호는 %10 -1 하면 될것 같은데
// 	3 2    13 2         끝번호를 모르겠네
// 	4 3    14 3
// 	5 4    15 4
// 	6 5
// 	7 6
// 	8 7
// 	9 8
// 	10 9   20 9
%>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>이름</th>
				<th>팀 번호</th>
				<th>포지션</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0;i<playerList.size();i++){ %>
			<tr>
				<td><%=playerList.get(i).getPlayer_name()%></td>
				<td><%=playerList.get(i).getTeam_id()%></td>
				<td><%=playerList.get(i).getPosition()%></td>
			</tr>
			<%} %>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">
				<%if(nowPage == 1){ %>
				 <ul class="pagination">
					<%for(int i=startPage; i<=endPage; i++){ 
					if(nowPage==i){%>
						<li class="active"><a><%=i %></a></li>
					<%}else{%>	
						<li><a href="./list.do?page=<%=i%>"><%=i%></a></li>
					<%}}%>
					<li><a onclick="location.href='./list.do?page=<%=nowPage+1%>'">&gt;</a></li>
					<li><a onclick="location.href='./list.do?page=<%=nowPage+10%>'">&gt;&gt;</a></li>
				</ul>
				<%}else if(nowPage > 1 && nowPage <=10){ %>
				<ul class="pagination">
					<li><a onclick="location.href='./list.do?page=<%=nowPage-1%>'">&lt;</a></li>
					<%for(int i=startPage; i<=endPage; i++){ 
					if(nowPage==i){%>
						<li class="active"><a><%=i %></a></li>
					<%}else{%>	
						<li><a href="./list.do?page=<%=i%>"><%=i%></a></li>
					<%}}%>
					<li><a onclick="location.href='./list.do?page=<%=nowPage+1%>'">&gt;</a></li>
					<li><a onclick="location.href='./list.do?page=<%=nowPage+10%>'">&gt;&gt;</a></li>
				</ul>
				<%}else if(nowPage == finalPage){ %>
				<ul class="pagination">
					<li><a onclick="location.href='./list.do?page=<%=nowPage-10%>'">&lt;&lt;</a></li>
					<li><a onclick="location.href='./list.do?page=<%=nowPage-1%>'">&lt;</a></li>
					<%for(int i=startPage; i<=endPage; i++){ 
					if(nowPage==i){%>
						<li class="active"><a><%=i %></a></li>
					<%}else{%>	
						<li><a href="./list.do?page=<%=i%>"><%=i%></a></li>
					<%}}%>
				</ul>
				<%}else if(nowPage < finalPage && nowPage >= ((finalPage/10)*10)-1) { %>
				<ul class="pagination">
					<li><a onclick="location.href='./list.do?page=<%=nowPage-10%>'">&lt;&lt;</a></li>
					<li><a onclick="location.href='./list.do?page=<%=nowPage-1%>'">&lt;</a></li>
					<%for(int i=startPage; i<=endPage; i++){ 
					if(nowPage==i){%>
						<li class="active"><a><%=i %></a></li>
					<%}else{%>	
						<li><a href="./list.do?page=<%=i%>"><%=i%></a></li>
					<%}}%>
					<li><a onclick="location.href='./list.do?page=<%=nowPage+1%>'">&gt;</a></li>
				</ul>
				<%}else{ %>
				<ul class="pagination">
					<li><a onclick="location.href='./list.do?page=<%=nowPage-10%>'">&lt;&lt;</a></li>
					<li><a onclick="location.href='./list.do?page=<%=nowPage-1%>'">&lt;</a></li>
					<%for(int i=startPage; i<=endPage; i++){ 
					if(nowPage==i){%>
						<li class="active"><a><%=i %></a></li>
					<%}else{%>	
						<li><a href="./list.do?page=<%=i%>"><%=i%></a></li>
					<%}}%>
					<li><a onclick="location.href='./list.do?page=<%=nowPage+1%>'">&gt;</a></li>
					<li><a onclick="location.href='./list.do?page=<%=nowPage+10%>'">&gt;&gt;</a></li>
				</ul>
				<%} %>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>