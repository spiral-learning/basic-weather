package com.welltestedlearning.basicweather;

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
    ResponseEntity<WeatherStackResponse> weatherStackResponseEntity =
        restTemplate.getForEntity(WEATHER_STACK_URL, WeatherStackResponse.class, API_KEY, zipCode);

    if (weatherStackResponseEntity.getStatusCode().is2xxSuccessful()) {
      return weatherStackResponseEntity.getBody().toReponseEntity();
    }

    log.warn("Non-successful status code: {}", weatherStackResponseEntity.getStatusCode());
    log.warn("Headers: {}", weatherStackResponseEntity.getHeaders());

    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new WeatherResponse());
  }

  @ExceptionHandler
  public ResponseEntity<WeatherResponse> exceptionHandler(RestClientException restClientException) {
    log.warn("Upstream exception", restClientException);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new WeatherResponse());
  }

}
