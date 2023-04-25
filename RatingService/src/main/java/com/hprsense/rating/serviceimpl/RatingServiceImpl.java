package com.hprsense.rating.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hprsense.rating.appconstant.APPMSG;
import com.hprsense.rating.dto.RatingDto;
import com.hprsense.rating.entities.Rating;
import com.hprsense.rating.exception.ResourceNotFoundException;
import com.hprsense.rating.payload.ApiResponse;
import com.hprsense.rating.repositories.RatingRepository;
import com.hprsense.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public RatingDto create(RatingDto rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return mapperEntityToDto(ratingRepository.save(mapperDtoToEntity(rating)));
	}

	@Override
	public List<RatingDto> getAll() {
		return ratingRepository.findAll().parallelStream().map(rating -> modelMapper.map(rating, RatingDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public RatingDto getHotel(String ratingId) {
		return mapperEntityToDto(ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException(APPMSG.RATING_NOT_FOUND)));
	}

	@Override
	public ApiResponse deleteHotel(String ratingId) {
		ratingRepository.deleteById(ratingId);
		return ApiResponse.builder().message(APPMSG.RATING_DELETED).success(true).status(HttpStatus.ACCEPTED).build();
	}

	@Override
	public RatingDto updateHotel(RatingDto hotel) {
		return mapperEntityToDto(ratingRepository.save(mapperDtoToEntity(hotel)));
	}

	@Override
	public List<RatingDto> getRatingByUserId(String userId) {
		return ratingRepository.findAllByUserId(userId).parallelStream().map(rating -> modelMapper.map(rating, RatingDto.class))
		.collect(Collectors.toList());
	}

	@Override
	public List<RatingDto> getRatingByHotelId(String hotelId) {
		return ratingRepository.findAllByHotelId(hotelId).parallelStream().map(rating -> modelMapper.map(rating, RatingDto.class))
				.collect(Collectors.toList());
	}
	
	private Rating mapperDtoToEntity(RatingDto ratingDto) {
		return modelMapper.map(ratingDto, Rating.class);
	}
	
	private RatingDto mapperEntityToDto(Rating rating) {
		return modelMapper.map(rating, RatingDto.class);
	}

	
}
