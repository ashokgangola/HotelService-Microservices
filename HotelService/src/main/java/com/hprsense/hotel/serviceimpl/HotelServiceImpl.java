package com.hprsense.hotel.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hprsense.hotel.appconstant.APPMSG;
import com.hprsense.hotel.dto.HotelDto;
import com.hprsense.hotel.entities.Hotel;
import com.hprsense.hotel.exception.ResourceNotFoundException;
import com.hprsense.hotel.payload.ApiResponse;
import com.hprsense.hotel.repositories.HotelRepository;
import com.hprsense.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public HotelDto create(HotelDto hotel) {
		hotel.setHotelId(UUID.randomUUID().toString());
		return mapperEntityToDto(hotelRepository.save(mapperDtoToEntity(hotel)));
	}

	@Override
	public List<HotelDto> getAll() {
		return hotelRepository.findAll().parallelStream().map(hotel -> modelMapper.map(hotel, HotelDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public HotelDto getHotel(String hotelId) {
		return mapperEntityToDto(hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException(APPMSG.HOTEL_NOT_FOUND)));
	}

	@Override
	public ApiResponse deleteHotel(String hotelId) {
		hotelRepository.deleteById(hotelId);
		return ApiResponse.builder().message(APPMSG.HOTEL_DELETED).success(true).status(HttpStatus.ACCEPTED).build();
	}

	@Override
	public HotelDto updateHotel(HotelDto hotel) {
		return mapperEntityToDto(hotelRepository.save(mapperDtoToEntity(hotel)));
	}

	private Hotel mapperDtoToEntity(HotelDto userDto) {
		return modelMapper.map(userDto, Hotel.class);
	}
	
	private HotelDto mapperEntityToDto(Hotel hotel) {
		return modelMapper.map(hotel, HotelDto.class);
	}
}
