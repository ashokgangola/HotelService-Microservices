package com.hprsense.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
	private String hotelId;
	private String name;
	private String location;
	private String about;
}
