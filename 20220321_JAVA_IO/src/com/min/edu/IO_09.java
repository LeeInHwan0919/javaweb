package com.min.edu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class IO_09 {
	/*
	 * 기존 파일 추가하기
	 */
	
	public static void main(String[] args) throws IOException {
	  // 문자를 입력할 때 PrintWriter를 해주면 자동으로 인코딩을 통해서 쓰여짐(따로 설정도 가능)
	  // 효과적으로 입력하기 위해서는 BufferedWriter 객체를 사용
	  // 기존의 작성 파일을 문자로 읽어오기 위해서 FileWriter
		
	   PrintWriter out = new PrintWriter( new BufferedWriter(new FileWriter("word.txt",Charset.forName("UTF-8"),true)));
	   
	   //입력 인터페이스인 키보드
	   System.out.println("글을 작성해 주세요.");
	   int c = 0;
	   InputStreamReader in = new InputStreamReader(System.in);
	   
	   // InputStreamReader의 객체 읽는 
	   while((c=in.read())!=-1) {
		   out.write(c);
	   }
	   		
	   out.flush();
	   out.close();
	   in.close();
  }
}
