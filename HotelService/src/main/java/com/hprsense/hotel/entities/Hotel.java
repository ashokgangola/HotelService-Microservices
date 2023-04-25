package com.hprsense.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="hotel")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	@Id
	private String hotelId;
	private String name;
	private String location;
	private String about;
}
