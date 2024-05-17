package com.HotelBooking.services;

import com.HotelBooking.models.RoomModel;
import com.HotelBooking.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public List<RoomModel> getAllRooms(int hotelId) {
        return roomRepository.getRoomsByHotelId(hotelId);
    }
}
