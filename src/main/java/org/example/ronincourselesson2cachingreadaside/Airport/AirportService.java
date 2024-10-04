package org.example.ronincourselesson2cachingreadaside.Airport;

import com.google.common.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    private final List<Airport> airports = new ArrayList<>();
    private final Cache<String, Airport> airportCache;
    @Autowired
    public AirportService(Cache<String, Airport> airportCache) {
        this.airportCache = airportCache;
        airports.add(new Airport("JFK", "John F. Kennedy International Airport", "New York", "USA", "America/New_York", 40.6413, -73.7781, "Runway info", true));
        airports.add(new Airport("LAX", "Los Angeles International Airport", "Los Angeles", "USA", "America/Los_Angeles", 33.9416, -118.4085, "Runway info", true));
        airports.add(new Airport("ORD", "O'Hare International Airport", "Chicago", "USA", "America/Chicago", 41.9742, -87.9073, "Runway info", true));
    }

    //Read aside caching
    public Airport getAirportByCode(String code) {
        // Step1: Get the airport from the cache
        Airport airport = airportCache.getIfPresent(code);
        if (airport == null) {
            // Step2: If not in cache, fetch from the database
            airport = airports.stream()
                    .filter(a -> a.getCode().equals(code))
                    .findFirst()
                    .orElse(null);
            if (airport != null) {
                // Step 3: Store the fetched airport in the cache
                airportCache.put(code, airport);
            }
        }
        return airport;
    }

    public List<Airport> getAllAirports() {
        return airports;
    }
}