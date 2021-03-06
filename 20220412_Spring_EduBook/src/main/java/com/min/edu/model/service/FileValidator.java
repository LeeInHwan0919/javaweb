/**
 * 
 */
package com.min.edu.model.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.min.edu.vo.UploadFileVo;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFileVo file = (UploadFileVo)target;
		System.out.println(file.getFile().getSize());
		if(file.getFile().getSize()==0) {
			errors.rejectValue("file", "errorCode","파일을 선택해 주세요");
		}
	}

}
