package com.HotelBooking.controllers;

import com.HotelBooking.models.GeoLocationModel;
import com.HotelBooking.models.HotelModel;
import com.HotelBooking.services.HotelService;
import com.HotelBooking.utils.HotelUtils;
import com.HotelBooking.utils.UserUtils;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelUtils hotelUtils;

    @Autowired
    private UserUtils userUtils;

    @CrossOrigin(origins = "*")
    @GetMapping("/get-hotels-within-radius")
    public List<HotelModel> getHotelsWithinRadius (@RequestParam(value = "userLat") double userLat,
            @RequestParam(value = "userLon") double userLon, @RequestParam(value = "radius") int radius)
                                                   throws IOException, GeoIp2Exception {

        // aducem toate hotelurile din db ToDo: gaseste o metoda mai eficienta
        List<HotelModel> allHotels = hotelService.getAllHotels();

        // aducem coordonatele user-ului
        GeoLocationModel geoLocationModel = new GeoLocationModel();
        geoLocationModel.setLatitude(userLat);
        geoLocationModel.setLongitude(userLon);

        List<HotelModel> hotelsWithinRadius = hotelUtils.findHotelsWithinRadius(
                geoLocationModel.getLatitude(), geoLocationModel.getLongitude(), radius, allHotels);
        return hotelsWithinRadius;
    }

    @GetMapping("/get-hotel-location")
    public ResponseEntity<HotelModel> getHotelLocationController(@RequestParam(value = "hotelName")
                                                                     String hotelName){
        HotelModel rawOutput = hotelService.getHotelLocation(hotelName);
        return new ResponseEntity<>(rawOutput, HttpStatus.OK);
    }
}
