package com.hprsense.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
