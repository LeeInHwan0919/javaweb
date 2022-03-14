package com.min.edu.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePatternBean {
	
	private String regdate;
	
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public String getDatePattern() {
		//문자열 날짜를 Date타입으로 변경
		Date cDate = null;
		Date now = null;
		//형태를 변환
		SimpleDateFormat fmt2 = null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cDate = fmt.parse(regdate);
			now = new Date();	
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		fmt2 = new SimpleDateFormat("yyyy년MM월dd일");
		//각 날짜의 형태를 맞춰서 문자열로 비교하여 ?같은날이라면 : 다른날 이라면
		return fmt2.format(cDate).compareTo(fmt2.format(now)) == 0?"오늘작성":fmt2.format(cDate);
	}
}
