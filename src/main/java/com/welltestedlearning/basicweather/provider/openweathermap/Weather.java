package com.welltestedlearning.basicweather.provider.openweathermap;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Weather {

  private String description;
  private String icon;
  private long id;
  private String main;

}
