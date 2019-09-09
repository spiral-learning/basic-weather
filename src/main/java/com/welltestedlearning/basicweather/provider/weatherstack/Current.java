
package com.welltestedlearning.basicweather.provider.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class Current {

  private long cloudcover;
  private long feelslike;
  private long humidity;
  @JsonProperty("observation_time")
  private String observationTime;
  private long precip;
  private long pressure;
  @JsonProperty("temparature")
  private int temperature;
  @JsonProperty("uv_index")
  private long uvIndex;
  private long visibility;
  @JsonProperty("weather_code")
  private long weatherCode;
  @JsonProperty("weather_descriptions")
  private List<String> weatherDescriptions;
  @JsonProperty("weather_icons")
  private List<String> weatherIcons;
  @JsonProperty("wind_degree")
  private long windDegree;
  @JsonProperty("wind_dir")
  private String windDir;
  @JsonProperty("wind_speed")
  private long windSpeed;

}
