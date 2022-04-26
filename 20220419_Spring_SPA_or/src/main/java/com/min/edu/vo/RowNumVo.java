package com.min.edu.vo;

import java.io.Serializable;

public class RowNumVo implements Serializable{

	private static final long serialVersionUID = -8202279230644955036L;

	//변수명을 제대로 인식하고 있어야 가능함
	private int pageList; // 출력할 페이지의 번호 갯수 (그룹)
	private int index; //출력할 페이지의 번호 (화면에서 받아옴)
	private int pageNum; //pageList 그룹에 있는 출력할 페이지의 시작번호 (그룹의 시작번호만 있으면 됨)
	private int listNum; //출력할 리스트의 갯수 (n개씩)
	private int total; //리스트의 총갯수
	
	//연산자블럭을 사용해서 넣어줄 것 default값을 넣어주고 시작해야함
	//session처리를 한다는 것
	{
		pageList = 5;
		index = 0;
		pageNum = 1;
		listNum = 5;
	}
	
	public RowNumVo() {
		
	}
	
	/**
	 * 화면에서 변경되는 값의 처리 null은 첫페이지의 값이 없음을 판단하기 쉬움
	 */
	public RowNumVo(String index, String pageNum, String listNum) {
		if(index!=null) {
			this.index = Integer.parseInt(index);
			
		}
		if(pageNum!=null) {
			this.pageNum = Integer.parseInt(pageNum);
			
		}
		if(listNum!=null) {
			this.listNum = Integer.parseInt(listNum);
			
		}
	}

	/**
	 * 쿼리문에서 글의 시작 rownum번호를 만들어 냄
	 * 1page라면 1~5 가 1 
	 */
	public int getStart() {
		return (index*listNum)+1; //index가 0일 때 시작rownum 은 (0*5)+1 = 1 
												//index가 1일 때 시작 rownum 은 (1*5)+1 = 6
	}

	/**
	 * 쿼리문에서 글의 끝 rownum번호를 만들어 냄
	 * ~5
	 */
	public int getLast() {
		return (index*listNum)+listNum; //index가 0일때 listNum 5 = (0*5)+5 = 5 index가 0 일때 마지막 글 rownum은 5 
														//index가 1일때 listNum (1*5)+5 = 10 index가 1일 때 마지막 글 rownum은 10
	}
	
	/**
	 * 
	 */
	public int getCount() {
		int count = 0; //내가보는 그룹의 마지막 페이지 번호
		int temp = total-listNum*(pageNum-1); //total이 35개일때 35-5*(6-1)=10 
		int min = temp/listNum; //temp 에서 1페이지에 출력되는 글의 갯수인 5를 나눠줌 = min = 페이지의 수 
		//남아있는 그룹의 갯수 temp가 10일때 10/5 = 2
		
		if(temp%listNum!=0) { //나머지가 0이 아니라면 
			min++; //min을 1씩 더해줌
		}
		
		if(temp<=listNum) { //남아있는 글의 갯수가 listNum보다 작은경우
			//1페이지 일 경우 : 남은 글 갯수가 listNum(5)보다 작거나 같으면
			count = pageNum; //시작번호
			
		}else if(min<=pageList) { //남아있는 갯수가 페이지 그룹갯수보다 작을경우 min갯수 만큼 index 그룹의 시작번호를 더해서 끝index값을 변경
			count = min+pageNum-1; //1,6,11이 나와야한다 pageNum = 6 : 6-1=5 -> 2+5 = 7
			
		}else{
			count = pageList+pageNum-1; //글의 갯수가 그룹의 총 글 갯수보다 큰 경우 index 그룹의 갯수를 더해줌
			//그룹갯수 + 페이지 시작번호 -1 
		}
		System.out.println("count = index 그룹의 끝번호 : " + count);
		
		return count;
	}

	public int getPageList() {
		return pageList;
	}

	public void setPageList(int pageList) {
		this.pageList = pageList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getListNum() {
		return listNum;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}













