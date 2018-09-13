package com.welltestedlearning.basicweather;

public class WeatherResponse {
  private String location;
  private String updated;
  private Float temp;
  private String condition;

  public static WeatherResponse from(ApixuWeather apixuWeather) {
    WeatherResponse weatherResponse = new WeatherResponse();
    weatherResponse.location = apixuWeather.getLocation().getName() + ", "
        + apixuWeather.getLocation().getRegion();

    Current current = apixuWeather.getCurrent();
    weatherResponse.updated = current.getLast_updated();
    weatherResponse.temp = current.getTemp_f();
    weatherResponse.condition = current.getCondition().getText();
    return weatherResponse;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public Float getTemp() {
    return temp;
  }

  public void setTemp(Float temp) {
    this.temp = temp;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

}
