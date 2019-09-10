package com.welltestedlearning.basicweather.provider.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.welltestedlearning.basicweather.WeatherResponse;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Data
@SuppressWarnings("unused")
public class OpenWeatherMapResponse {

  private String base;
  private Clouds clouds;
  private long cod;
  private Coord coord;
  @JsonProperty("dt")
  private long dateTimeInEpochSeconds;
  private long id;
  private Main main;
  private String name;
  private Sys sys;
  private int timezone;
  private long visibility;
  private List<Weather> weather;
  private Wind wind;

  public ResponseEntity<WeatherResponse> toResponseEntity() {
    WeatherResponse weatherResponse = new WeatherResponse();

    weatherResponse.setCondition(extractCondition());
    weatherResponse.setTemp((int) main.getTemp());
    weatherResponse.setUpdated(extractUpdated());
    weatherResponse.setLocation(name);

    return ResponseEntity.ok(weatherResponse);
  }

  private String extractUpdated() {
    ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(timezone);
    LocalDateTime dateTime = LocalDateTime.ofEpochSecond(dateTimeInEpochSeconds, 0, zoneOffset);
    return dateTime.toString();
  }

  private String extractCondition() {
    return weather.stream()
                  .map(Weather::getDescription)
                  .collect(Collectors.joining(", "));
  }
}
