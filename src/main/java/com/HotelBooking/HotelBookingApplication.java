package com.HotelBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.HotelBooking.controllers", "com.HotelBooking.models",
"com.HotelBooking.repositories", "com.HotelBooking.services", "com.HotelBooking.utils"})
public class HotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

}
