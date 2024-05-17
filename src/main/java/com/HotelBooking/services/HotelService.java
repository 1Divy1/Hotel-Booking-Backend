package com.HotelBooking.services;

import com.HotelBooking.models.HotelModel;
import com.HotelBooking.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<HotelModel> getAllHotels () {
        return hotelRepository.getAllHotels();
    }

    public HotelModel getHotelLocation(String hotelName) {
        return hotelRepository.getHotelByName(hotelName);
    }
}
