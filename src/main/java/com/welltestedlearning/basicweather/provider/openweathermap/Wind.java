package com.welltestedlearning.basicweather.provider.openweathermap;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Wind {

  private long deg;
  private double speed;

}
