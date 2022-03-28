<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 일정 등록</title>
</head>
<%@ include file="./header.jsp" %>
<body>
<%
  int lastDay = (Integer)request.getAttribute("lastDay");
  int hour = (Integer)request.getAttribute("hour");
  int minute = (Integer)request.getAttribute("minute");
  
  int year = Integer.parseInt(request.getParameter("year"));
  int month = Integer.parseInt(request.getParameter("month"));
  int date = Integer.parseInt(request.getParameter("date"));
  
%>
</body>
<div id="container">
  <form action="./CalController.do" method="post">
    <input type="hidden" value="insertCalBoard" name="command">
    <table class="table">
      <tbody>
        <tr>
          <th>아이디</th>
          <td>${sessionScope.id}</td>
        </tr>
        <tr>
          <th>일정</th>
          <td>
            <select name="year">
              <%
                for(int i=(year-2);i<(year+2);i++){
                  %>
                    <option value="<%=i%>" <%=(i==year)?"selected":""%>><%=i%></option>
                  <%
                }
              %>
            </select> 년도
            <select name="month">
             <%
                for(int i=1;i<=12;i++){
                  %>
                    <option value="<%=i%>" <%=(i==month)?"selected":""%>><%=i%></option>
                  <%
                }
              %>
            </select> 월
            <select name="date">
              <%
                for(int i=1;i<=lastDay;i++){
                  %>
                    <option value="<%=i%>" <%=(i==date)?"selected":""%>><%=i%></option>
                  <%
                }
              %>
            </select> 일
            <select name="hour">
              <%
                for(int i=0;i<=23;i++){
                  %>
                    <option value="<%=i%>" <%=(i==hour)?"selected":""%>><%=i%></option>
                  <%
                }
              %>
            </select> 시
            <select name="minute">
              <%
                for(int i=0;i<=59;i++){
                  %>
                    <option value="<%=i%>" <%=(i==minute)?"selected":""%>><%=i%></option>
                  <%
                }
              %>
            </select> 분
          </td>
        </tr>
        
        <tr>
          <th>제목</th>
          <td>
            <input class="form-control" type="text" name="title">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea class="form-control" rows="10" cols="50" name="content"></textarea>
          </td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <th colspan="2">
            <input class="btn btn-info btn-block" type="submit" value="일정 등록">
          </th>
        </tr>
      </tfoot>
    </table>
  </form>
</div>
</html>