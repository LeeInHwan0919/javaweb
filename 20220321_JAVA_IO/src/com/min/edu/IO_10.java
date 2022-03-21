package com.min.edu;

import java.io.File;
import java.text.Format;
import java.util.Date;

public class IO_10 {

	/*
	 * 파일(File) 클래스 활용
	 * 파일 클래스를 통해서 파일의 타입, 크기, 디렉토리, 파일 이름
	 */
	public static void main(String[] args) {
		File f1 = new File("C:\\Windows\\system.ini");
		File f2 = new File("C:\\Goodee\\eclipse\\temp\\temp");
		File f3 = new File("C:\\Goodee\\eclipse");
		
		//파일 여부 판단
		String res="";
		if(f1.isFile()) {
			res = "파일 입니다.";
		}else {
			res ="파일이 아닙니다.";
		}
		System.out.println(res);
		
		//폴더 생성하기
		if(!f2.exists()) {//폴더가 있는지
			if(!f2.mkdirs()) {
				System.out.println("디렉토리 생성에 실패 하였습니다.");
			}else {
				System.out.println("디렉토리 생성에 성공 하였습니다.");
			}
		}else {
			System.out.println("디렉토리가 존재 합니다.");
		}
		
		
		//폴더 이름을 변경
		f2.renameTo(new File("C:\\Goodee\\eclipse\\tmp"));
		
		//정보 확인
		String[] filenames = f3.list();
		for (String s : filenames) {
//			System.out.println(s);
			File f = new File(f3,s);
			long t = f.lastModified();
			long ㅣ = f.length();
			String n = f.getName();
			
			System.out.println("마지막 수정 일자 : "+t);
			System.out.println("파일의 크기 : "+ㅣ);
			System.out.println("파일의 이름 : "+n);
			System.out.println("--------------------------");
			
			System.out.printf("수정시간 : %tb %td %ts %tT\n",t,t,t,t);
			Date date = new Date(t);
			System.out.println(date.toString());
			System.out.println("--------------------------");
		}
	}
	
}
