package com.HotelBooking.utils;

import com.HotelBooking.models.GeoLocationModel;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

@Component
public class UserUtils {

    public GeoLocationModel getUserLocation() throws IOException, GeoIp2Exception {
        /*String filePath = "C:/apps/Hotel Booking - Internship/HotelBooking/HotelBooking/src/" +
                "main/resources/maxmind/GeoLite2-City.mmdb";
        File database = new File(filePath);

        InetAddress ipAddress = InetAddress.getLocalHost();
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
        CityResponse response = dbReader.city(ipAddress);

        GeoLocationModel geoLocationModel = new GeoLocationModel();
        geoLocationModel.setLatitude(response.getLocation().getLatitude());
        geoLocationModel.setLongitude(response.getLocation().getLongitude());

        System.out.println("latitude = " + response.getLocation().getLatitude());
        System.out.println("longitude = " + response.getLocation().getLongitude());
        return geoLocationModel;
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter latitude: ");
        Double userLatitude = Double.valueOf(scanner.nextLine());

        System.out.println("enter longitude: ");
        Double userLongitude = Double.valueOf(scanner.nextLine());

        GeoLocationModel geoLocationModel = new GeoLocationModel();
        geoLocationModel.setLatitude(userLatitude);
        geoLocationModel.setLongitude(userLongitude);

        return geoLocationModel;
    }
}
