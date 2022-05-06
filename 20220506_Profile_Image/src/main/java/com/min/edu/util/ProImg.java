package com.min.edu.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ProImg {

	//상대 경로
	public static String attach_path="C:\\0420java\\eclipse\\0420javaweb\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20220506_Profile_Image\\resources\\proimg";
	
	public static String saveFile(MultipartFile file) {
		String saveName = file.getOriginalFilename();
		
		File f = new File(attach_path,saveName); 
		
		try {
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return saveName;
	}
}
