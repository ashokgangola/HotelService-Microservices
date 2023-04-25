package com.hprsense.user.service.entities;

import java.util.List;

import com.hprsense.user.service.dto.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	@Id
	private String userId;
	private String name;
	private String email;
	private String mobile;
	private String about;
	@Transient
	private List<Rating> ratings;
}
