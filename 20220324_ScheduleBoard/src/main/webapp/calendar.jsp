<%@page import="com.min.edu.dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.min.edu.util.CalendarUtil"%>
<%@page import="com.min.edu.model.CalBoardDaoImpl"%>
<%@page import="com.min.edu.model.ICalBoardDao"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 관리 게시판</title>
</head>
<%@ include file="./header.jsp" %>
<body>
    <h2>일정관리 게시판</h2>
    <%
        // 세션의 정보를 받는다
        String id = (String)session.getAttribute("id");
        System.out.println(id);
        
        //달력 로직
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        
        //전송된 parameter 처리
        String paramYear = request.getParameter("year");
        String paramMonth = request.getParameter("month");
        
        //요청을 판단하여 값이 현재값인지 판단 / 재입력
        if(paramYear!= null){
            year = Integer.parseInt(paramYear);
        }
        if(paramMonth!=null){
            month = Integer.parseInt(paramMonth);
        }
        
        //화면에 추력되는 값인 음수를 처리 해줘야함
        if(month>12){
            month=1;
            year++;
        }
        if(month<1){
            month=12;
            year--;
        }
        
        //요청하는 년 월로 Calendar를 세팅해 줌
        cal.set(year, month-1, 1);
        
        //요청받은 년도 월의 1일 요일
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //요청받은 년도 월의 최대일수
        int lasstDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        //이전달력
        cal.set(year, month-1-1, 1);
        int beforeLastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        //달력에 필요한 게시글의 정보를 가져오는 Dao 실행
        ICalBoardDao dao = new CalBoardDaoImpl();
        
        //필요한 입력 형태를 만들어줘야함
        //id, yyyymm
        String yyyymm = year+CalendarUtil.isTwoWord(month);
        System.out.printf("전달하는 parameter : %s %s : %s\n",year,month,yyyymm);
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        map.put("yyyymm",yyyymm);
        
        List<CalendarDto> cList = dao.getCalViewList(map);
        System.out.println(cList);
        %>
        
        <div id="container">
            <table id="calendar">
                <caption style="text-align: center; font-size: 17pt;">
                <a href="./calendar.jsp?year=<%=year-1 %>&month=<%=month%>">◁</a>
                <a href="./calendar.jsp?year=<%=year%> %&month=<%=month-1%>">◀</a>
                    <span class="y"><%=year%></span>년도&nbsp;
                    <span class="m"><%=month%></span>월
                <a href="./calendar.jsp?year=<%=year%>&month=<%=month+1%>">▶</a>
                <a href="./calendar.jsp?year=<%=year+1 %>&month=<%=month%>">▷</a>
                </caption>
                <thead>
                    <tr>
                        <th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
                    </tr>
                </thead>
    <tbody>
                <tr>
                    <%
                        //공백
                        for(int i=beforeLastDay-dayOfWeek+1+1;i<=beforeLastDay;i++){
                            out.print("<td style='color:#ccc'>"+i+"</td>");
                        }
                        //달력
                        for(int i=1; i<=lasstDay; i++){
                            %>
                            <td>
                                <!-- 날짜별 색표기 -->
                                <a href="./CalController.do?command=calList&year=<%=year%>&month=<%=month%>&date=<%=i%>"
                                   class="countView"
                                   style="color:<%=CalendarUtil.fontColor(i, dayOfWeek)%>">
                                <%=i%>
                                </a> 
                                
                                <div class="cPreview">5</div>
                                <!-- 글쓰기 버튼 -->
                                <a href="./CalController.do?command=insertForm&year=<%=year%>&month=<%=month%>&date=<%=i%>">
                                  <img alt="글작성" src="./image/pen.png">
                                </a>

                                <!-- 날짜별 작성 글 리스트 -->
                                <div class="clist">
                                    <%=CalendarUtil.getCalView(i,cList)%>
                                </div>

                            </td>
                            <%
                            if((dayOfWeek-1+i)%7==0){
                                out.print("</tr></tr>");
                            }
                        }
                        for(int i=0;i<(7-(dayOfWeek-1+lasstDay)%7)%7;i++){
                            out.print("<td style='color:#ccc;'>"+(i+1)+"</td>");
                        }
                    %>
                </tr>
            </tbody>
  </table>
</div>
	<div class="wrap-loading" style="display:none;">

    <div><img src="./image/loading1.gif" /></div>

</div>

</body>
</html>