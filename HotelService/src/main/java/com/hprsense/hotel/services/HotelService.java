package com.hprsense.hotel.services;

import java.util.List;

import com.hprsense.hotel.dto.HotelDto;
import com.hprsense.hotel.payload.ApiResponse;

public interface HotelService {

	HotelDto create(HotelDto hotel);
	
	List<HotelDto> getAll();
	
	HotelDto getHotel(String hotelId);
	
	ApiResponse deleteHotel(String hotelId);
	
	HotelDto updateHotel(HotelDto hotel);
}
