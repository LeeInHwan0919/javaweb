package com.min.edu.cron;

public interface ICronDao {

  /**
   * Cron을 통해서 6초에 한번씩 자동으로 실행되는 Dao
   */
	public void test();
	
	/**
	 * service ☞ dao ☞ mabatis 결과를 출력하는 Cron메소드
	 */
	public void new_item();
}
