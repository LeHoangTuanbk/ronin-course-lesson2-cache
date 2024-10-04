package org.example.ronincourselesson2cachingreadaside.Airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Airport {
    private String code;
    private String name;
    private String city;
    private String country;
    private String timezone;
    private double latitude;
    private double longitude;
    private String runwayDetails;
    private boolean isHub;
}