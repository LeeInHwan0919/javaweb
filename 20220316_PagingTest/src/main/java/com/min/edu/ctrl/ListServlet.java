package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.IPlayer;
import com.min.edu.dao.PlayerImpl;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.PlayerVo;

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 3273596914726263037L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=\"utf-8\"");
		
		IPlayer player = new PlayerImpl();
		PageVo pages = new PageVo();
		
		// 게시글의 총 갯수 설정
		pages.setTotal(player.count());
		int total = pages.getTotal();
		
		// 한 페이지에 표시할 게시글의 갯수 설정
		pages.setCntPerPage(10);
		int cntPerPage = pages.getCntPerPage();
		
		// 마지막 페이지 설정
		pages.calFinalPage(total, cntPerPage);
		int finalPage = pages.getFinalPage();
		
		// 현재 페이지 설정
		int nowPage = 0;
		if(req.getParameter("page")==null) {
			nowPage = 1;
		}else {
			nowPage = Integer.parseInt(req.getParameter("page"));
		}
		
		// 게시글의 시작 번호 설정
		pages.calStartNum(nowPage, cntPerPage);
//		pages.setStartNum((nowPage*cntPerPage)-(cntPerPage-1));
		int startNum = pages.getStartNum();
		
		// 게시글의 마지막 번호 설정
		pages.calEndNum(nowPage, cntPerPage);
//		pages.setEndNum(nowPage*cntPerPage);
		int endNum = pages.getEndNum();
		
		// 마지막 페이지 설정
		pages.calEndPage(nowPage, cntPerPage);
		int endPage = pages.getEndPage();
		
		// 시작 페이지 설정
		int startPage = endPage - cntPerPage + 1;
		
		// 게시글 출력
		List<PlayerVo> playerList = player.showView(startNum);
		
		System.out.println("게시글의 총 갯수 total : " + total);
		System.out.println("end : " + endNum + "start : " + startNum);
		
		req.setAttribute("total", total);
		req.setAttribute("cntPerPage", cntPerPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("startNum", startNum);
		req.setAttribute("endNum", endNum);
		req.setAttribute("endPage", endPage);
		req.setAttribute("startPage", startPage);
		req.setAttribute("finalPage", finalPage);
		req.setAttribute("playerList", playerList);
		
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}

}
