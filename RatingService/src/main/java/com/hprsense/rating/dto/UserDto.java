package com.hprsense.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String userId;
	private String name;
	private String email;
	private String mobile;
	private String about;
}
