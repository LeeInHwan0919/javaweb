package com.min.edu.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePatternBean {

	private String regdate;
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	// REGDATE의 형태를 변경하여 출력하기 위해서 사용
	// REGDATE String 타입 -> java.util.Date로 변경 -> java.text.SimpleDatePattern을 통해 변경 
	//  -> 변환된 String 출력
	public String getDatePattern(){ 
		String str = "";
		Date cDate = null;
		Date now = null;
		SimpleDateFormat fmt2 = null;
		try {
			//문자열 날짜를 Date 타입으로 변경
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cDate = fmt.parse(regdate);
			now = new Date();
			fmt2 = new SimpleDateFormat("yyyy년MM월dd일");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//형태를 변환
		
		// 각 날짜의 형태를 맞춰서 문자열로 비교하여 ? 같은날 이라면 : 다른날 이라면
		return fmt2.format(cDate).compareTo(fmt2.format(now)) == 0 ?"오늘 작성":fmt2.format(cDate);
	}
}