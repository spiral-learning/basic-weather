package com.welltestedlearning.basicweather.provider.openweathermap;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Sys {

  private String country;
  private long id;
  private double message;
  private long sunrise;
  private long sunset;
  private long type;

}
