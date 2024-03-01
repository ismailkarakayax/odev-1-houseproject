package com.ismailkarakayax.weatherapi.client;


import com.ismailkarakayax.weatherapi.model.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "weather", url = "https://weather.visualcrossing.com")
public interface WeatherClient {

    @GetMapping("/VisualCrossingWebServices/rest/services/timeline/{city}/{startDate}/{endDate}?key={apiKey}")
    ResponseEntity<Weather> getData(@PathVariable("city") String city,
                                    @PathVariable("startDate") String startDate,
                                    @PathVariable("endDate") String endDate,
                                    @PathVariable("apiKey") String apiKey);

}
