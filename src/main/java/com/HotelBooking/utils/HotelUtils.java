package com.HotelBooking.utils;

import com.HotelBooking.models.HotelModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelUtils {

    // Radius of the Earth in kilometers
    private static final double EARTH_RADIUS = 6371;

    // Method to calculate the distance between two geolocation points using Haversine formula
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

        // Convert latitude and longitude from degrees to radians
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // Calculate the distance using Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }

    // Method to find hotels within a given radius from a center point
    public static List<HotelModel> findHotelsWithinRadius(double centerLat, double centerLon,
                                                          double radius, List<HotelModel> hotels) {
        List<HotelModel> hotelsWithinRadius = new ArrayList<>();

        for (HotelModel hotel : hotels) {
            double distance = calculateDistance(centerLat, centerLon, hotel.getLatitude(),
                                                hotel.getLongitude());
            if (distance <= radius) {
                hotelsWithinRadius.add(hotel);
            }
        }
        return hotelsWithinRadius;
    }

}
