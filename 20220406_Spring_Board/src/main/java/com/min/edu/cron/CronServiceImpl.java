package com.min.edu.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CronServiceImpl implements ICronService {

	@Autowired
	private ICronDao dao;
	
	@Override
	public void new_item() {
		System.out.println("& & & Cron Service 실행");
		dao.new_item();
	}

}
