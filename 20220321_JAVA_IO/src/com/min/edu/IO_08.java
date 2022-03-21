package com.min.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_08 {

	/*
	 * 버퍼를 이용한 파일 복사(파일 복사 할 때는  무조건 버퍼 이용)
	 */
	public static void main(String[] args) {
	  // 파일을 읽음
	  FileInputStream fis = null;
	  BufferedInputStream bis = null;
	  
	  //파일을 작성
	  FileOutputStream fos = null;
	  BufferedOutputStream bos = null;
	  
	  try {
		 //1.기존 파일을 읽는다
		fis = new FileInputStream("gartner_report.txt");
 		 //2. 버퍼 객체로 감싼다.
		bis = new BufferedInputStream(fis);
		
		 //3. 복사된 파일 객체를 생성한다.
		fos = new FileOutputStream("gartner_report_copy.txt");
		 //4. 버퍼 객체로 감싼다.
		bos = new BufferedOutputStream(fos);
		
		int c = 0;
		while((c=bis.read())!=-1) {
			bos.write(c);
		}
		
		bos.flush();
		bos.close();
		fos.close();
		bis.close();
		fis.close();
		
	} catch (IOException e) {
		e.printStackTrace();
		}
	  
	}
}
