package org.example.ronincourselesson2cachingreadaside.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AirportController {

    private final AirportService airportService;
    @Autowired
    AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/airports/{code}")
    public Airport getAirportByCode(@PathVariable String code) {
        return airportService.getAirportByCode(code);
    }
}
