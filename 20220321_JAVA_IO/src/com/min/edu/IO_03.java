package com.min.edu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO_03 {
	
	/*
	 * input 입력 / output 출력
	 */
	public static void main(String[] args) {
	  // 결과물 출력
	  int[] num = {1,44,-1,55};
	  byte[] b = {53,54,55,56,57};
	  
	  try {
		FileOutputStream fileOut = new FileOutputStream("out.txt");
		for (int i = 0; i < num.length; i++) {
			fileOut.write(num[i]);
		}
		for (int i = 0; i < b.length; i++) {
			fileOut.write(b[i]);
		}
		fileOut.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
	 System.out.println("밥상 엎어");
	  
	 // 위에서 파일에 저장한 int값과 byte값을 읽어 보자
	 try {
		FileInputStream fileIn = new FileInputStream("out.txt");
		int c= 0;
		while ((c=fileIn.read()) != -1) {
			System.out.print((int)c+" ");
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	} 
	 
	 System.out.println("밥상 엎어");
	 
	 // data의 타입에 맞춰서 표현해 보자\
	 try {
		DataOutputStream Out = new DataOutputStream(new FileOutputStream("dataType.txt"));
		Out.writeInt(128);
		Out.writeInt(-1);
		Out.writeBoolean(false);
		Out.writeDouble(3.14);
		Out.writeChar('V');
		Out.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	 
	 System.out.println("때리기");
	 
	 try {
		DataInputStream in = new DataInputStream(new FileInputStream("C:\\Goodee\\javaweb\\20220321_JAVA_IO\\dataType.txt"));
		System.out.println(in.readInt());
		System.out.println(in.readInt());
		System.out.println(in.readBoolean());
		System.out.println(in.readDouble());
		System.out.println(in.readChar());
	} catch (IOException e) {
		e.printStackTrace();
	}
	 
	 
  }
}
