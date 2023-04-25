package com.hprsense.rating.controller;

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

import com.hprsense.rating.dto.RatingDto;
import com.hprsense.rating.services.RatingService;

@RestController
@RequestMapping("/v1/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("save")
	public ResponseEntity<RatingDto> createUser(@RequestBody RatingDto ratingDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(ratingDto));
	}
	
	@GetMapping("all")
	public ResponseEntity<List<RatingDto>> getAllUsers(){
		return ResponseEntity.ok(ratingService.getAll());
	}
	
	@GetMapping("users/{userId}")
	public ResponseEntity<List<RatingDto>> getRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("hotels/{hotelId}")
	public ResponseEntity<List<RatingDto>> getRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}
}
