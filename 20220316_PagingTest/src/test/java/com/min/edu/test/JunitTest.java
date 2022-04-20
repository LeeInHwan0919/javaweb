package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.dao.IPlayer;
import com.min.edu.dao.PlayerImpl;
import com.min.edu.vo.PageVo;
import com.min.edu.vo.PlayerVo;

public class JunitTest {

	//@Test
	public void test() {
		IPlayer dao = new PlayerImpl();
		List<PlayerVo> lists = dao.showView(1);
		System.out.println(lists);
	}
	
	//@Test
	public void test2() {
		IPlayer dao = new PlayerImpl();
		int cnt = dao.count();
		System.out.println(cnt);
	}
	
	@Test
	public void test3() {
		PageVo vo = new PageVo();
//		int total = 481;
//		vo.calFinalPage(total, cntPerPage);
//		System.out.println(vo.getFinalPage());
		int cntPerPage = 10;
		int nowPage = 11;
		vo.setFinalPage(49);
//		vo.calStartNum(nowPage, cntPerPage);
//		vo.calEndNum(nowPage, cntPerPage);
//		System.out.println("시작번호 : "+vo.getStartNum());
//		System.out.println("마지막번호 : "+vo.getEndNum());
		vo.calEndPage(nowPage, cntPerPage);
		System.out.println("마지막 페이지 : " + vo.getEndPage());
		vo.calStartPage();
		System.out.println("시작 페이지 : " + vo.getStartPage());
	}

}
