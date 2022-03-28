package com.min.edu.ctrl;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.CalBoardDaoImpl;
import com.min.edu.model.ICalBoardDao;
/**
 * 글을 삭제할 때 사용 
 */
public class DelController extends HttpServlet {

	private static final long serialVersionUID = -6375643503701051610L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		logger.info("글 삭제 doPost");
		
		String[] seqs = req.getParameterValues("chk");
		System.out.println(Arrays.toString(seqs));
		
		ICalBoardDao dao = new CalBoardDaoImpl();
		boolean isc = dao.multiDel(seqs);
		
		resp.sendRedirect("./calendar.jsp");
	}
}
