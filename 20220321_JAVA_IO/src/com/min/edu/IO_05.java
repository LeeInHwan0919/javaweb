package com.min.edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class IO_05 {

	public static void main(String[] args) throws IOException {
	  FileInputStream fin = new FileInputStream("word.txt");
	  InputStreamReader in = new InputStreamReader(fin,"UTF-8");
	  int c = 0;
	  while ((c=in.read())!=-1) {
		System.out.print((char)c);
	}
	 in.close();
	 fin.close();
  }
	
}
