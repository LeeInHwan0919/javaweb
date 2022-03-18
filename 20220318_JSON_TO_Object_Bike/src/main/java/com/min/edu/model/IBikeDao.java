package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.BikeDto;

public interface IBikeDao {
	public int bikeInsert(List<BikeDto> dtos);
	public int bikeDelete();
}
