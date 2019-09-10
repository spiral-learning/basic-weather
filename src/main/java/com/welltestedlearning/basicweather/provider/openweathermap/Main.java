package com.welltestedlearning.basicweather.provider.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Main {

  private long humidity;
  private long pressure;
  private double temp;
  @JsonProperty("temp_max")
  private double tempMax;
  @JsonProperty("temp_min")
  private double tempMin;

}
