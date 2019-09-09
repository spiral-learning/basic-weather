package com.welltestedlearning.basicweather;

import com.welltestedlearning.basicweather.provider.weatherstack.WeatherStackError;
import com.welltestedlearning.basicweather.provider.weatherstack.WeatherStackResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
@Slf4j
public class ApiController {

  private static final String WEATHER_STACK_URL = "http://api.weatherstack.com/current?access_key={apikey}&units=f&query={zip}";
  private final RestTemplate restTemplate = new RestTemplate();

  @Value("${weatherstack.api.key}")
  private String API_KEY;

  @GetMapping("/zip/{zip}")
  public ResponseEntity<WeatherResponse> findWeather(@PathVariable("zip") String zipCode) {
    WeatherStackResponse weatherStackResponse =
        restTemplate.getForObject(WEATHER_STACK_URL, WeatherStackResponse.class, API_KEY, zipCode);

    return toResponseEntity(weatherStackResponse);
  }

  private ResponseEntity<WeatherResponse> toResponseEntity(WeatherStackResponse weatherStackResponse) {
    ResponseEntity<WeatherResponse> responseEntity;
    if (weatherStackResponse.succeeded()) {
      WeatherResponse response = WeatherResponse.from(weatherStackResponse);
      responseEntity = ResponseEntity.ok(response);
    } else {
      responseEntity = createUnavailableResponse(weatherStackResponse);
    }
    return responseEntity;
  }

  private ResponseEntity<WeatherResponse> createUnavailableResponse(WeatherStackResponse weatherStackResponse) {
    WeatherStackError error = weatherStackResponse.getWeatherStackError();
    log.warn("WeatherStack error: code = {}, type = '{}', info = '{}'",
             error.getCode(),
             error.getType(),
             error.getInfo());
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new WeatherResponse());
  }

  @ExceptionHandler
  public ResponseEntity<WeatherResponse> exceptionHandler(RestClientException restClientException) {
    log.warn("Upstream exception", restClientException);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new WeatherResponse());
  }

}
