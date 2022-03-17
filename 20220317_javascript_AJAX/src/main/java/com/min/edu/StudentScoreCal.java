package com.min.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/scoreCal.do")
public class StudentScoreCal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax에서 값을 받았다고 생각하고 작성
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8;");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		System.out.printf("%s, %d, %d, %d \n",name, kor, eng, math);
		int sum = kor+eng+math;
		double avg = Math.round(sum/3d);
		
		
		
		//JSON 라이브러리를 사용하지 않으면 힘들어요.
//		StringBuffer sb = new StringBuffer();
//		sb.append("{");
//		sb.append("\"name\"");
//		sb.append(":");
//		sb.append("\""+name+"\",");
//		sb.append("\"sum\"");
//		sb.append(":");
//		sb.append("\""+sum+"\",");
//		sb.append("\"avg\"");
//		sb.append(":");
//		sb.append("\""+avg+"\",");
//		sb.append("}");
//		response.getWriter().print(sb.toString());
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", name);
		jsonObj.put("sum", sum);
		jsonObj.put("avg", avg);
		response.getWriter().print(jsonObj.toJSONString());
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax에서 값을 받았다고 생각하고 작성
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8;");
				
				String name = request.getParameter("name");
				int kor = Integer.parseInt(request.getParameter("kor"));
				int eng = Integer.parseInt(request.getParameter("eng"));
				int math = Integer.parseInt(request.getParameter("math"));
				System.out.printf("%s, %d, %d, %d \n",name, kor, eng, math);
				int sum = kor+eng+math;
				double avg = Math.round(sum/3d);
				
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("name", name);
				jsonObj.put("sum", sum);
				jsonObj.put("avg", avg);
				response.getWriter().print(jsonObj.toJSONString());
	}

}
