package com.min.edu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_06 {
  public static void main(String[] args) throws IOException {
	System.out.println("입력 정보를 파일로 저장하기");
	InputStreamReader in = new InputStreamReader(System.in);
	//파일에 문자를 쓰는 객체
	FileWriter fileOut = new FileWriter("C:\\Goodee\\javaweb\\20220321_JAVA_IO\\inputValue.txt");
	
	//키보드로 입력 받은 InputStreamReader 객체를 byte단위로 읽어서 FileWriter로 써줌
	int c = 0;
	while ((c=in.read())!=-1) {
		fileOut.write(c);
	}
	//데이터를 전송을 했다면 데이터를 모두 전송하기 위해서 Flush
	fileOut.flush();
	
	fileOut.close();
	in.close();
	
  }
  
}
