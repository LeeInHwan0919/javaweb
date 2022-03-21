package com.min.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class IO_Exam {
	public static void main(String[] args) throws IOException{
	  //파일을 불러오기
		File csv = new File("DatFile.csv");
		BufferedReader br = new BufferedReader(new FileReader(csv));
		String line = "";
		
		//라인 카운트를 저장하는 map
		Map<String, Integer> map = new HashMap<String, Integer>();
		long totalCnt = 0;
		
		//파일을 읽어 오면서 map에 카운트로 저장
		while ((line=br.readLine())!=null) {
			int cnt = map.get(line)==null ? 0:map.get(line);
			map.put(line, cnt+1);
			totalCnt++;
//			System.out.println(line+":"+map.get(line));
//			break;
		}
		System.out.println("총 라인의 수 : "+totalCnt+"건");
		//총 라인의 수 : 3000001건
		
		PrintWriter pw = new PrintWriter("result.txt");
		
		long duplicate = 0;
		int breakcount = 0;
		for (String key : map.keySet()) {
			//Map은 중복된 key를 가질 수 없다, 따라서 keySet()을 통해서 파일에 저장하면 중복되지 않은 값을 담을 수 있다.
			pw.write(key);
			//중복된 행 카운트
			if(map.get(key)>1) {
				duplicate += map.get(key)-1;
			}
			if(breakcount++ == 500) {
				break;
			}
		}
		System.out.println("중복된 라인의 수 : "+duplicate+"건");
		System.out.println(totalCnt-duplicate+"원본의 갯수");
		pw.close();
		br.close();
		
	}
	
}
