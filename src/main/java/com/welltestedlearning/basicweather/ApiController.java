package com.welltestedlearning.basicweather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RequestMapping("/api")
@RestController
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private final WeatherService weatherService;

    @Autowired
    public ApiController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/zip/{zip}")
    public ResponseEntity<WeatherResponse> findWeather(@PathVariable("zip") String zipCode) {
        return weatherService.current(zipCode);
    }

    @ExceptionHandler
    public ResponseEntity<WeatherResponse> exceptionHandler(RestClientException restClientException) {
        log.warn("Upstream exception", restClientException);
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new WeatherResponse());
    }

}
