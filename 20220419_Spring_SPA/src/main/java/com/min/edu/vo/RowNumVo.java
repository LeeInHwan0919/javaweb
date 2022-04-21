package com.min.edu.vo;

import java.io.Serializable;

public class RowNumVo implements Serializable {

   

   


private static final long serialVersionUID = -4952496656952478771L;
   
   private int pageList;//출력한 페이지의 번호 갯수 (페이지 그룹의 갯수) 
   private int index; //출력한 페이지의 번호 ?
   private int pageNum;//출력한 페이지의 시작번호 1, 6, 11...
   private int listNum;//출력한 리스트의 갯수 5
   private int total;//리스트의 총 갯수 123..
   
   {
      pageList = 5;
      index = 0; 
      pageNum=1;
      listNum=5;
   }
   
   public RowNumVo() {
   }
   /**
    * 화면에서 변경되는 값의 처리 null은 첫페이지 호출 시 값이 없음을 판단하기 쉬움
    */
   public RowNumVo(String index, String pageNum, String listNum) {
      if(index != null) {
         this.index =Integer.parseInt(index);
      }
      if(pageNum != null) {
         this.pageNum = Integer.parseInt(pageNum);
      }
      if(listNum != null) {
         this.listNum =Integer.parseInt(listNum);
      }
   }

   /**
    * 뭐리문에서 글의 rownum 번호를 만들어 냄
    * 1page라면 1 
    */
   public int getStart() {
   
      return index*listNum+1;
   }
   /**
    * 뭐리문에서 글의 끝 rownum 번호를 만들어 냄
    * ~ 1 
    */
   public int getLast() {
      return (index*listNum)+listNum;
   }

   
   public int getCount() {
      int count = 0;
      int temp = total -listNum*(pageNum-1); //35-5*(6-1)=10;
      int min = temp/listNum;// 10/5 = 2 남아있는 그룹의 갯수
      if(temp%listNum != 0) {
    	  min++;
      }
      
      if(temp <= listNum) { //남아 있는 글의 갯수가 1페이지 이다.
    	count = pageNum;
      }else if(min <= pageList){
    	count = min + pageNum -1;
      }else {
    	count = pageList + pageNum -1;
      }
      
      System.out.println("count(index 그룹의 끝 번호) ="+count);
      
      return count;
   }
   
   public RowNumVo(int pageList, int index, int pageNum, int listNum, int total) {
		this.pageList = pageList;
		this.index = index;
		this.pageNum = pageNum;
		this.listNum = listNum;
		this.total = total;
	}
   
   

}