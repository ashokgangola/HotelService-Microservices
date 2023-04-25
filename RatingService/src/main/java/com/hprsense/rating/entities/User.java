package com.hprsense.rating.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String userId;
	private String name;
	private String email;
	private String mobile;
	private String about;
	private List<Rating> ratings;
}
