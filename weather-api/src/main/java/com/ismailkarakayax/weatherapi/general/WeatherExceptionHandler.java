package com.ismailkarakayax.weatherapi.general;

import com.ismailkarakayax.weatherapi.exception.WeatherApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherExceptionHandler {

    @ExceptionHandler(WeatherApiException.class)
    public ResponseEntity<String> handleWeatherApiException(WeatherApiException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
