package com.HotelBooking.controllers;

import com.HotelBooking.models.RoomModel;
import com.HotelBooking.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/show")
    public ResponseEntity<List<RoomModel>> getAllRooms (@RequestParam(value = "hotelId") int hotelId) {
        List<RoomModel> rooms = roomService.getAllRooms(hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
