package com.hprsense.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hprsense.user.service.dto.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@GetMapping("/v1/ratings/users/{userId}")
	Rating[] getRatingOfUser(@PathVariable("userId") String userId);
}
