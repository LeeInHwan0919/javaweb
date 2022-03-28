package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.CalendarDto;
import com.min.edu.model.CalBoardDaoImpl;
import com.min.edu.model.ICalBoardDao;

/**
 * doGet : calList, insertForm
 * doPost : session처리, insertCalBoard 
 */
public class CalController extends HttpServlet {

	private static final long serialVersionUID = 6483701772520000145L;
	private Logger logger = Logger.getLogger(CalController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  req.setCharacterEncoding("UTF-8");
	  resp.setContentType("text/html;charset=UTF-8");
	  
	  String command = req.getParameter("command");
	  
	  //TODO 02
	  if(command.trim().equalsIgnoreCase("sessionDel")){
		  
		  logger.info("세션 정보 삭제");
		  HttpSession session= req.getSession();
		  session.invalidate();
		  resp.sendRedirect("./index.jsp");
		  
	  }else if(command.trim().equalsIgnoreCase("calList")) {
		  String year = req.getParameter("year");
		  String month = String.format("%2s",req.getParameter("month")).replace(" ", "0");
		  String date = String.format("%2s",req.getParameter("date")).replace(" ", "0");
		  logger.info("전달받은 Parameter : "+year+"/"+month+"/"+date);
		  
		  HttpSession session = req.getSession();
		  String id = (String)session.getAttribute("id");
		  
		  Map<String, Object> map = new HashMap<String, Object>();
		  map.put("id", id);
		  map.put("yyyymmdd", year+month+date);
		  
		  ICalBoardDao dao = new CalBoardDaoImpl();
		  List<CalendarDto> lists = dao.getCalList(map);
		  logger.info(lists);
		  req.setAttribute("lists", lists);
		  req.getRequestDispatcher("./calList.jsp").forward(req, resp);
		  
	  }else if(command.trim().equalsIgnoreCase("detail")) {
		  String seq = req.getParameter("seq");
		  String yyyymmdd=req.getParameter("yyyymmdd");
		  HttpSession session = req.getSession();
		  String id = (String)session.getAttribute("id");
		  
		  Map<String, Object> map = new HashMap<String, Object>();
		  ICalBoardDao dao = new CalBoardDaoImpl();
		  map.put("id", id);
		  map.put("yyyymmdd", yyyymmdd);
		  map.put("seq", seq);
		  CalendarDto dto = dao.getCalDetail(map);
		  req.setAttribute("dto", dto);
		  req.getRequestDispatcher("./calDetail.jsp").forward(req, resp);
	  }else if(command.trim().equalsIgnoreCase("insertForm")) {
		  String year = req.getParameter("year");
		  String month = req.getParameter("month");
		  String date = req.getParameter("date");
		  
		  GregorianCalendar gCal = new GregorianCalendar();
		  gCal.set(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(date));
		  int lastDay = gCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		  int hour = gCal.get(Calendar.HOUR_OF_DAY);
		  int minute = gCal.get(Calendar.MINUTE);
		  
		  System.out.printf("%d %d %d",lastDay, hour, minute);
		  
		  req.setAttribute("lastDay", lastDay);
		  req.setAttribute("hour", hour);
		  req.setAttribute("minute", minute);
		  
		  req.getRequestDispatcher("./insertCalboard.jsp").forward(req, resp);
	  }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  req.setCharacterEncoding("UTF-8");
	  resp.setContentType("text/html;charset=UTF-8");
	  
	  
	  String command = req.getParameter("command");
	  logger.info("요청받은 command 값 : "+command);
	  
	//TODO 01
	  if(command.trim().equalsIgnoreCase("calendar")) {
		  String id = req.getParameter("id");
		  String name = req.getParameter("name");
		  
		  logger.info("전달 받은 parameter : "+id+"/"+name);
		  
		  HttpSession session = req.getSession();
		  session.setAttribute("id", id);
		  session.setAttribute("name", name);
		  
		  resp.sendRedirect("./calendar.jsp");		  
		  
	  }else if(command.trim().equalsIgnoreCase("insertCalBoard")) {
		  HttpSession session = req.getSession();
		  String id = (String)session.getAttribute("id");
		  String mdate = req.getParameter("year")+
				  String.format("%2s", req.getParameter("month")).replace(" ","0")+
				  String.format("%2s", req.getParameter("date")).replace(" ","0")+
				  String.format("%2s", req.getParameter("hour")).replace(" ","0")+
				  String.format("%2s", req.getParameter("minute")).replace(" ","0");
		  
		  CalendarDto dto = new CalendarDto(0,id,req.getParameter("title")
				                                ,req.getParameter("content")
				                                ,mdate,"");
		  System.out.println(dto);
		  ICalBoardDao dao = new CalBoardDaoImpl();
		  boolean isc =dao.insertCalBoard(dto);
		  resp.sendRedirect("./calendar.jsp");
	  }
	}
	
	
}
