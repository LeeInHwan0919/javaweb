package com.min.edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO_02 {

	public static void main(String[] args) {
	  /*
	   * InputStream 데이터를 읽어 오는 객체
	   * 파일 읽어 옴
	   * ByteStream 바이트 단위로 바이너리 값을 읽는 스트림
	   * 
	   * InputStrem
	   *  - FileInputStream 파일을 읽어옴
	   *  - DataInputStream
	   *  
	   *  -- 실습 --
	   *  물리적인 주소 java에서 문법오류가 발생하기 때문에 Escape 문자를 통해서 작성해야 한다.
	   *  C:\\Goodee\\eclipse\\eclipse.txt
	   *  => 절대경로 : 고정값의 주소로 변하지 않는 주소를 가지고 있음(주소가 고정되어 있는 것)
	   *     상대경로 : 주소가 계속해서 변경되어 사용되는 것(c:\\ ./);
	   *  절대경로에 있는 local의 파일을 읽어서 console 출력해 보자
	   */
		
		try {
			FileInputStream file = new FileInputStream("C:\\Goodee\\eclipse\\eclipse.txt");
			// InputStream을 읽어 오면 byte 데이터를 하나씩 읽어서 문자형을 변환
			// 읽는 메소드는 read()
			int v = 0;
//			int r = file.read();
//			System.out.println((char)r);
			while ((v = file.read()) != -1) {
				System.out.print((char)v);
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
