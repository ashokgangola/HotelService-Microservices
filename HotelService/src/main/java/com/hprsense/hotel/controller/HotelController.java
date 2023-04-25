package com.hprsense.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hprsense.hotel.dto.HotelDto;
import com.hprsense.hotel.services.HotelService;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("save")
	public ResponseEntity<HotelDto> createUser(@RequestBody HotelDto hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	@GetMapping("all")
	public ResponseEntity<List<HotelDto>> getAllUsers(){
		return ResponseEntity.ok(hotelService.getAll());
	}
	
	@GetMapping("{hotelId}")
	public ResponseEntity<HotelDto> getUser(@PathVariable String hotelId){
		return ResponseEntity.ok(hotelService.getHotel(hotelId));
	}
}
