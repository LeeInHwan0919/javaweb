package com.min.edu.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.min.edu.comm.Encrypt_AES;

public class EncryptTest {

	@Test
	public void test() {
		Encrypt_AES aes = new Encrypt_AES();
		String txt = "김우연";
		String cT1 = null;
		try {
			cT1 = aes.encrypt(txt);
		System.out.println("원래 김우연 : "+txt);
		System.out.println("암호화된 김우연 : "+cT1);
		System.out.println("복호화된 김우연 : "+aes.decrypt(cT1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
