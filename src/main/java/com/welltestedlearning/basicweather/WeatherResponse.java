package com.welltestedlearning.basicweather;

import com.welltestedlearning.basicweather.provider.weatherstack.Current;
import com.welltestedlearning.basicweather.provider.weatherstack.WeatherStackResponse;
import lombok.Data;

@Data
public class WeatherResponse {
  private String location;
  private String updated;
  private Integer temp;
  private String condition;

  public static WeatherResponse from(WeatherStackResponse weatherStackResponse) {
    WeatherResponse weatherResponse = new WeatherResponse();
    weatherResponse.location = weatherStackResponse.getLocation().getName() + ", "
        + weatherStackResponse.getLocation().getRegion();

    Current current = weatherStackResponse.getCurrent();
    weatherResponse.updated = weatherStackResponse.getLocation().getLocaltime();
    weatherResponse.temp = current.getTemperature();
    weatherResponse.condition = String.join(", ", current.getWeatherDescriptions());
    return weatherResponse;
  }
}
