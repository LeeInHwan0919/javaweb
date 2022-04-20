package com.min.edu.dao;

import java.util.List;

import com.min.edu.vo.PlayerVo;

public interface IPlayer {
	public List<PlayerVo> showView(int startNum);
	
	public Integer count();
}
