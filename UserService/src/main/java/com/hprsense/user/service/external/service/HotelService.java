package com.hprsense.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hprsense.user.service.dto.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/v1/hotels/{hotelId}")
	Hotel getHotelById(@PathVariable("hotelId") String hotelId);
}
