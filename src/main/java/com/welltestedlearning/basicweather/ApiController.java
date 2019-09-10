package com.welltestedlearning.basicweather;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@RequestMapping("/api")
@RestController
@Slf4j
public class ApiController {

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
