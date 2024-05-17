package com.HotelBooking.repositories;

import com.HotelBooking.models.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel, Integer> {

    @Query(value = "SELECT * FROM \"hotel\"", nativeQuery = true)
    List<HotelModel> getAllHotels();

    @Query(value = "SELECT * FROM \"hotel\" WHERE name = ?1", nativeQuery = true)
    HotelModel getHotelByName(String hotelName);

}
