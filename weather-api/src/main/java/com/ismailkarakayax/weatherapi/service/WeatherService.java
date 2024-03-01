package com.ismailkarakayax.weatherapi.service;

import com.ismailkarakayax.weatherapi.client.WeatherClient;
import com.ismailkarakayax.weatherapi.model.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {


    private final WeatherClient weatherClient;


    public ResponseEntity<Weather> getWeatherData(String city, String startDate, String endDate, String apiKey) {
        return weatherClient.getData(city, startDate, endDate ,apiKey);
    }
}
