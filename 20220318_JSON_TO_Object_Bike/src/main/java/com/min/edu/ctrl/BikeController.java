package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.min.edu.dto.BikeDto;
import com.min.edu.model.BikeDaoImpl;
import com.min.edu.model.IBikeDao;

public class BikeController extends HttpServlet {

	private static final long serialVersionUID = -8922292744560191295L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		logger.info("요청받은 command 값 :"+command);
			
		if(command.trim().equalsIgnoreCase("first")) {
			resp.sendRedirect("./bikeview/bike01.jsp");
		}else if(command.trim().equalsIgnoreCase("second")){
			req.getRequestDispatcher("./WEB-INF/views/bike/bike02.jsp").forward(req,resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String command = req.getParameter("command");
		System.out.println("요청받은 doPost값 : "+command);
		
		if(command.trim().equalsIgnoreCase("first_db")) {
			String[] bikeList = req.getParameterValues("bike");
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			for (int i = 0; i < bikeList.length; i++) {
				String[] temp = bikeList[i].split("/");
				int idx = 0;
				BikeDto dto = new BikeDto(temp[idx++],
						Integer.parseInt(temp[idx++]),
						temp[idx++],
						Double.parseDouble(temp[idx++]),
						Integer.parseInt(temp[idx++]),
						Double.parseDouble(temp[idx++]),
						temp[idx++]);
				dtos.add(dto);
			}
			
			logger.info(dtos.size());
			
			IBikeDao dao = new BikeDaoImpl();
			int cnt = dao.bikeInsert(dtos);
			if(cnt>0) {
				logger.info("DB 저장에 성공하였습니다.");
			}else {
				logger.info("DB 저장에 실패하였습니다.");
			}
		}else {
			logger.info("second_db 들어옴");
			
			String jsonObj = req.getParameter("obj");
			System.out.println(jsonObj);
			
			JsonElement element = JsonParser.parseString(jsonObj);
			int len = element.getAsJsonObject().get("DATA").getAsJsonArray().size();
			System.out.println("JSON의 갯수 :"+len);
			String new_addr = element.getAsJsonObject().get("DATA").getAsJsonArray().get(0).getAsJsonObject().get("NEW_ADDR").getAsString();
			System.out.println("JSON의 값 : "+new_addr);
		
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			for (int i = 0; i < len; i++) {
				JsonObject temp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				JsonElement t1 = temp.get("NEW_ADDR");
				JsonElement t2 = temp.get("CONTENT_ID");
				JsonElement t3 = temp.get("ADDR_GU");
				JsonElement t4 = temp.get("LONGITUDE");
				JsonElement t5 = temp.get("CRADLE_COUNT");
				JsonElement t6 = temp.get("LATITUDE");
				JsonElement t7 = temp.get("CONTENT_NM");
				
				BikeDto dto =
						new BikeDto(t1.getAsString(),t2.getAsInt(),t3.getAsString(),t4.getAsDouble(),t5.getAsInt(),t6.getAsDouble(),t7.getAsString());
				dtos.add(dto);
			}
			
			IBikeDao dao = new BikeDaoImpl();
			dao.bikeDelete();
			
			int n = dao.bikeInsert(dtos);
			if(n>0) {
				System.out.println("DB입력 성공");
			}else {
				System.out.println("DB입력 실패");
			}
			resp.getWriter().print(n);
			
			
		}
		
		
	}
}
