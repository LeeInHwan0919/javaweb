package com.min.edu.vo;

public class PageVo {
	// 전체 게시글의 갯수
	private int total;
	// 한페이지에 출력할 게시물의 갯수
	private int cntPerPage;
	// 현재 페이지
	private int nowPage;
	// 마지막 페이지
	private int endPage;
	// 시작 페이지
	private int startPage;
	// 최종 페이지
	private int finalPage;
	// 게시글 마지막 번호
	private int endNum;
	// 게시글 시작 번호
	private int startNum;
	
	// 최종 페이지 계산
	public void calFinalPage(int total, int cntPerPage) {
		setFinalPage((int)Math.ceil((double)total/(double)cntPerPage));
	}
	
	// 게시글 시작 번호 계산
	public void calStartNum(int nowPage, int cntPerPage) {
		setStartNum((nowPage*cntPerPage)-(cntPerPage-1));
	}
	
	// 게시글 마지막 번호 계산
	public void calEndNum(int nowPage, int cntPerPage) {
		setEndNum(nowPage*cntPerPage);
		if(nowPage==finalPage) {
			setEndNum(getTotal());
		}
	}
	
	// 마지막 페이지 계산
	public void calEndPage(int nowPage, int cntPerPage) {
		setEndPage(((int)Math.ceil((double)nowPage/cntPerPage))*10);
		if(getFinalPage()<getEndPage()) {
			setEndPage(getFinalPage());
		}
	}
	
	// 시작 페이지 계산
	public void calStartPage() {
		setStartPage(getEndPage()-getCntPerPage()+1);
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getTotal() {
		return total;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getFinalPage() {
		return finalPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	
	@Override
	public String toString() {
		return "PageVo [total=" + total + ", cntPerPage=" + cntPerPage + ", nowPage=" + nowPage + ", endPage=" + endPage
				+ ", finalPage=" + finalPage + ", startNum=" + startNum + ", endNum=" + endNum + "]";
	}
	
	
}
