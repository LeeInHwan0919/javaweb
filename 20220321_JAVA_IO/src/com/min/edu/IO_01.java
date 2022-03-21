package com.min.edu;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO_01 {

	/*
	 * java.io.*
	 * 1) java에서 데이터를 읽고 쓰고 하는 기능을 가지고 있는 package
	 * 2) java.io는 IOException이 필수다. 왜냐하면 읽고자 하는 위치 혹은 파일이 없으면 확인하고 진행해야 하기 때문에 <= checked exception
	 * 3) java는 스트림 객체
	 * 
	 *  JAVA의 스트림 이란
	 *   - java의 스트림은 입출력장치와 프로그램을 연결하여 이른 사이의 데이터를 처리하는 것
	 *   - 입력스트림 (InputStream) / 출력스트림(OutputStream)
	 *   - 기본크기 1byte(8bit)
	 *   - 연속적으로 전송하는 데이터의 크기를 보완 Buffer와 Filter <= 스트림을 도와 주는 객체
	 *   - 출력스트림(FIFO)
	 */
	
	public static void main(String[] args) {
		System.out.println("InputStreamReader");
//		Scanner scan = new Scanner(System.in);
//		scan.nextLine();
		InputStreamReader reader = new InputStreamReader(System.in);
		
		try {
			int n = reader.read();
			System.out.println(n);
			System.out.println((char)n);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
