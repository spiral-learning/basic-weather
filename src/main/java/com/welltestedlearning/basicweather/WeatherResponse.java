package com.welltestedlearning.basicweather;

import lombok.Data;

@Data
public class WeatherResponse {
  private String location;
  private String updated;
  private Integer temp;
  private String condition;
}
