
package com.welltestedlearning.basicweather.provider.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.welltestedlearning.basicweather.WeatherResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Slf4j
@SuppressWarnings("unused")
public class WeatherStackResponse {

  @JsonProperty("error")
  private WeatherStackError weatherStackError;
  private Current current;
  private Location location;
  private Request request;

  private boolean succeeded() {
    return weatherStackError == null;
  }

  public ResponseEntity<WeatherResponse> toResponseEntity() {
    ResponseEntity<WeatherResponse> responseEntity;
    if (succeeded()) {
      WeatherResponse response = toResponse();
      responseEntity = ResponseEntity.ok(response);
    } else {
      responseEntity = createUnavailableResponse();
    }
    return responseEntity;
  }

  private WeatherResponse toResponse() {
    WeatherResponse weatherResponse = new WeatherResponse();
    weatherResponse.setLocation(getLocation().getName() + ", " + getLocation().getRegion());
    weatherResponse.setUpdated(getLocation().getLocaltime());
    weatherResponse.setTemp(getCurrent().getTemperature());
    weatherResponse.setCondition(String.join(", ", getCurrent().getWeatherDescriptions()));
    return weatherResponse;
  }

  private ResponseEntity<WeatherResponse> createUnavailableResponse() {
    WeatherStackError error = getWeatherStackError();
    log.warn("WeatherStack error: code = {}, type = '{}', info = '{}'",
             error.getCode(),
             error.getType(),
             error.getInfo());
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new WeatherResponse());
  }

}
