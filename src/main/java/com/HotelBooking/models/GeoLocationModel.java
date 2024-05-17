package com.HotelBooking.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class GeoLocationModel {

    private Double latitude;
    private Double longitude;
}
