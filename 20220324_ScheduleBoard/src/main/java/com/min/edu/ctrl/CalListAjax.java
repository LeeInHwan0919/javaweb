package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.model.CalBoardDaoImpl;
import com.min.edu.model.ICalBoardDao;

import net.sf.json.JSONObject;

public class CalListAjax extends HttpServlet {
/**
 * 달력의 숫자에 마우스가 오버됐을때 해당 날의 게시글의 전체 갯수를 표현한다
 * Ajax를 통해서 결과(글갯수)를 반환하여 View에서 CSS를 통해서 해당 글자 위해서 표현한다
 */
	private static final long serialVersionUID = 1836152498942521990L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		logger.info("Ajax doPost");
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		String yyyymmdd = req.getParameter("yyyymmdd");
		System.out.printf("%s / %s",id, yyyymmdd);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("yyyymmdd", yyyymmdd);
		
		ICalBoardDao dao = new CalBoardDaoImpl();
		int cnt = dao.getCalCount(map);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//결과를 JSON 처리
		Map<String, Object> mapC = new HashMap<String, Object>();
		mapC.put("calCount", cnt);
		
		JSONObject obj = JSONObject.fromObject(mapC);
		System.out.println(obj.toString());	
		
		PrintWriter out = resp.getWriter();
		out.print(obj);
	}
}
