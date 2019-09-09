
package com.welltestedlearning.basicweather.provider.weatherstack;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class WeatherStackError {

  private long code;
  private String info;
  private String type;

}
