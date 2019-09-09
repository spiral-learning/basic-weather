
package com.welltestedlearning.basicweather.provider.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class WeatherStackResponse {

  @JsonProperty("error")
  private WeatherStackError weatherStackError;
  private Current current;
  private Location location;
  private Request request;

  public boolean succeeded() {
    return weatherStackError == null;
  }
}
