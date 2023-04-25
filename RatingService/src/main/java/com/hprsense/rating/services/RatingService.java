package com.hprsense.rating.services;

import java.util.List;

import com.hprsense.rating.dto.RatingDto;
import com.hprsense.rating.payload.ApiResponse;

public interface RatingService {

	RatingDto create(RatingDto rating);
	
	List<RatingDto> getAll();
	
	RatingDto getHotel(String ratingId);
	
	ApiResponse deleteHotel(String ratingId);
	
	RatingDto updateHotel(RatingDto rating);
	
	List<RatingDto> getRatingByUserId(String userId);
	
	List<RatingDto> getRatingByHotelId(String hotelId);
}
