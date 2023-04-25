package com.hprsense.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hprsense.rating.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	List<Rating> findAllByUserId(String userId);

	List<Rating> findAllByHotelId(String hotelId);

}
