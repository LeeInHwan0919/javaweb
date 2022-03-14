package com.min.edu.comm;

public class PhotoBean {
	
	private  int depth;

	public void setDepth(int depth) {
		this.depth = depth;
	}

	// Declaration을 통해서 JSP에 JAVA의 메소드를 작성 => useBean으로 변경하여 처리
	public String getphoto() {
		String str = "";
		String blank = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		String pic = "<img alt=\"답글\" src=\"./image/reply2.png\">";

		for (int i = 0; i < depth; i++) {
			str += blank;
		}
		return depth > 0 ? str + pic : str;
	}
}
