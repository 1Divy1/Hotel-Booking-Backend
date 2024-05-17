package com.HotelBooking.repositories;

import com.HotelBooking.models.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Integer> {

    @Query(value = "SELECT * FROM rooms WHERE hotel_id = ?1 AND is_available = true", nativeQuery = true)
    List<RoomModel> getRoomsByHotelId(int hotelId);

}
