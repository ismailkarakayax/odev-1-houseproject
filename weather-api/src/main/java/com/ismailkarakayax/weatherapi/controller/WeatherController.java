package com.ismailkarakayax.weatherapi.controller;

import com.ismailkarakayax.weatherapi.model.Weather;
import com.ismailkarakayax.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;



    @GetMapping()
    public String hello(){
        return "hello";
    }

    @GetMapping("/{city}/{startDate}/{endDate}")
    public ResponseEntity<Weather> getWeatherData(@PathVariable("city") String city,
                                                  @PathVariable("startDate") String startDate,
                                                  @PathVariable("endDate") String endDate,
                                                  @RequestParam("key") String apiKey) {
        return weatherService.getWeatherData(city, startDate,endDate, apiKey);
    }
}
