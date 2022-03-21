package com.min.edu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO_04 {
	
	/*
	 * 문자 스트림(Reader / Writer 로 끝남)
	 * 유니코드로 되어 있는 문자 입력 스트림
	 * -- 문자형식 만을 읽어냄 다른 데이터에서는 사용할 수 없는(이미지, 동영상, 음악...)
	 * Reader : 바이트로 문자를 읽음 / Writer : 문자를 바이트로 읽어서 인코딩해서 출력
	 * 
	 */
	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("C:\\Windows\\system.ini");
			int c = 0;
//			int c= in.read();
//			System.out.println(c);
			while (( c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
