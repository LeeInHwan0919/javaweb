package com.min.edu.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoBean {
	
	private int depth;
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	// Declaration을 통해서 JSP에 java의 메소드를 작성 => useBean으로 변경하여 처리
	// 제목에 각 글의 답글의 그림을 표기 하기 위해서 사용
	public String getPhoto(){
		String str ="";
		String blank = "&nbsp;&nbsp;&nbsp;&nbsp;";
		String pic = "<img alt=\"답글\" src=\"./image/reply.png\">";
		for(int i = 0; i < depth; i++){
			str += blank;
		}
		return depth>0?str+pic:str;
	}
//	
//	// REGDATE의 형태를 변경하여 출력하기 위해서 사용
//	// REGDATE String 타입 -> java.util.Date로 변경 -> java.text.SimpleDatePattern을 통해 변경 
//	//  -> 변환된 String 출력
//	public String datePattern(String regdate) throws Exception{ 
//		String str = "";
//		//문자열 날짜를 Date 타입으로 변경
//		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date cDate = fmt.parse(regdate);
//		
//		Date now = new Date();
//		//형태를 변환
//		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy년MM월dd일");
//		
//		// 각 날짜의 형태를 맞춰서 문자열로 비교하여 ? 같은날 이라면 : 다른날 이라면
//		return fmt2.format(cDate).compareTo(fmt2.format(now)) == 0 ?"오늘 작성":fmt2.format(cDate);
//	}
}
