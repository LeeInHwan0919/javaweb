package com.min.edu.vo;

import org.springframework.web.multipart.MultipartFile;


public class UploadFileVo {

	private String filename;
	private String desc;
	private MultipartFile file;
	public UploadFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UploadFileVo(String filename, String desc, MultipartFile file) {
		super();
		this.filename = filename;
		this.desc = desc;
		this.file = file;
	}
	@Override
	public String toString() {
		return "UploadFileVo [filename=" + filename + ", desc=" + desc + ", file=" + file + "]";
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFilename() {
		return filename;
	}
	
	
	
	
}
