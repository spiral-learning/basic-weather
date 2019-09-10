package com.welltestedlearning.basicweather;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

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
    restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
      @Override
      public boolean hasError(ClientHttpResponse response) throws IOException {
        return false;
      }
    });
//    ResponseEntity<WeatherStackResponse> weatherStackResponseEntity =
//        restTemplate.getForEntity(WEATHER_STACK_URL, WeatherStackResponse.class, API_KEY, zipCode);
    ResponseEntity<String> responseEntity =
        restTemplate.getForEntity(WEATHER_STACK_URL, String.class, API_KEY, zipCode);
    log.warn("String response: {}", responseEntity.getBody());
    log.warn("Headers: {}", responseEntity.getHeaders());

//    if (weatherStackResponseEntity.getStatusCode().is2xxSuccessful()) {
//      return weatherStackResponseEntity.getBody().toReponseEntity();
//    }
//
//    log.warn("Non-successful status code: {}", weatherStackResponseEntity.getStatusCode());
//    log.warn("Headers: {}", weatherStackResponseEntity.getHeaders());

    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new WeatherResponse());
  }

  @ExceptionHandler
  public ResponseEntity<WeatherResponse> exceptionHandler(RestClientException restClientException) {
    log.warn("Upstream exception", restClientException);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new WeatherResponse());
  }

}
