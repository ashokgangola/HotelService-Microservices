package com.hprsense.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hprsense.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
