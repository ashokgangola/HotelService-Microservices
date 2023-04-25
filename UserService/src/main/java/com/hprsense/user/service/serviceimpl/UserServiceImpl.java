package com.hprsense.user.service.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hprsense.user.service.appconstant.APPMSG;
import com.hprsense.user.service.appconstant.SERVICE;
import com.hprsense.user.service.dto.Hotel;
import com.hprsense.user.service.dto.Rating;
import com.hprsense.user.service.dto.UserDto;
import com.hprsense.user.service.entities.User;
import com.hprsense.user.service.exception.ResourceNotFoundException;
import com.hprsense.user.service.external.service.HotelService;
import com.hprsense.user.service.external.service.RatingService;
import com.hprsense.user.service.repositories.UserRepository;
import com.hprsense.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto saveUser(UserDto user) {
		user.setUserId(UUID.randomUUID().toString());
		return mapperEntityToDto(userRepository.save(mapperDtoToEntity(user)));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<UserDto> users = userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class))
		.collect(Collectors.toList());
		users = users.stream().map(user -> {
			return getUserRatingAndHotel(user);
		}).collect(Collectors.toList());
		return users;
	}

	@Override
	public UserDto getUser(String userId) {
		UserDto userDto = mapperEntityToDto(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(APPMSG.USER_NOT_FOUND)));
		return getUserRatingAndHotel(userDto);
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public UserDto updateUser(UserDto user) {
		return mapperEntityToDto(userRepository.save(mapperDtoToEntity(user)));
	}
	
	private UserDto getUserRatingAndHotel(UserDto user) {
		Rating[] userRating = restTemplate.getForObject("http://"+SERVICE.RATING_SERVICE.label+"/v1/ratings/users/"+user.getUserId(), Rating[].class);
		//Rating[] userRating = ratingService.getRatingOfUser(user.getUserId());
		List<Rating> ratings = Arrays.stream(userRating).toList().stream().map(rating ->{
			ResponseEntity<Hotel> response = restTemplate.getForEntity("http://"+SERVICE.HOTEL_SERVICE.label+"/v1/hotels/"+rating.getHotelId(), Hotel.class);
			//Hotel hotel = hotelService.getHotelById(rating.getHotelId());
			rating.setHotel(response.getBody());
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratings);
		return user;
	}
	
	private User mapperDtoToEntity(UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}
	
	private UserDto mapperEntityToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}
}
