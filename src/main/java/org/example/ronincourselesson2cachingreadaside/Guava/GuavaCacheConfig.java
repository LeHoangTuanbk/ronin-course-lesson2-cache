package org.example.ronincourselesson2cachingreadaside.Guava;

import com.google.common.cache.CacheBuilder;
import org.example.ronincourselesson2cachingreadaside.Airport.Airport;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.google.common.cache.Cache;

import java.util.concurrent.TimeUnit;

@Configuration
public class GuavaCacheConfig {
    @Bean
    public Cache<String, Airport> airportCache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(1000)
                .build();
    }
}
