
package com.welltestedlearning.basicweather.provider.weatherstack;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Request {

  private String language;
  private String query;
  private String type;
  private String unit;

}
