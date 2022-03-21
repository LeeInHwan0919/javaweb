package com.min.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;

public class IO_07 {
	
  public static void main(String[] args) throws IOException {
	
	  OutputStream o = System.out;
	  for (int i = 48; i < 58; i++) {
		o.write(i);
	}
	  for (byte i = 48; i < 58; i++) {
		o.write(i);
	}
	  System.out.println();
	  String str = "구디아카데미";
	  byte[] b = str.getBytes();
	  System.out.println(Arrays.toString(b));
	  o.write(b);
	  o.flush();
	  
	  System.out.println("---------------------");
	  
	  //키보드로 입력 받을 때
//	  InputStreamReader in = new InputStreamReader(System.in);
//	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
	  BufferedOutputStream bOut = new BufferedOutputStream(System.out,4);
	  Date d = new Date();
	  long start = d.getTime();
	  System.out.println(start);
	  
	  FileReader fin = new FileReader("C:\\Goodee\\eclipse\\eclipse.txt");
	  int c = 0;
	  while ((c=fin.read())!=-1) {
		o.write((char)c);
	}
	  d= new Date();
	  long end = d.getTime();
	  System.out.println("\n\n 걸린시간: "+(end-start));
	  
//	  o.flush();
	  bOut.flush();
	  fin.close();
	  bOut.close();
  }
  
}
