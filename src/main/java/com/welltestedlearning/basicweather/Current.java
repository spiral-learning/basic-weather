package com.welltestedlearning.basicweather;

public class Current {

  private Integer last_updated_epoch;
  private String last_updated;
  private Float temp_f;
  private Condition condition;
  private Float wind_mph;
  private String wind_dir;
  private Float pressure_in;
  private Float precip_in;
  private Integer humidity;
  private Integer cloud;
  private Float feelslike_f;
  private Float vis_miles;

  public Integer getLast_updated_epoch() {
    return last_updated_epoch;
  }

  public void setLast_updated_epoch(Integer last_updated_epoch) {
    this.last_updated_epoch = last_updated_epoch;
  }

  public String getLast_updated() {
    return last_updated;
  }

  public void setLast_updated(String last_updated) {
    this.last_updated = last_updated;
  }

  public Float getTemp_f() {
    return temp_f;
  }

  public void setTemp_f(Float temp_f) {
    this.temp_f = temp_f;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  public Float getWind_mph() {
    return wind_mph;
  }

  public void setWind_mph(Float wind_mph) {
    this.wind_mph = wind_mph;
  }

  public String getWind_dir() {
    return wind_dir;
  }

  public void setWind_dir(String wind_dir) {
    this.wind_dir = wind_dir;
  }

  public Float getPressure_in() {
    return pressure_in;
  }

  public void setPressure_in(Float pressure_in) {
    this.pressure_in = pressure_in;
  }

  public Float getPrecip_in() {
    return precip_in;
  }

  public void setPrecip_in(Float precip_in) {
    this.precip_in = precip_in;
  }

  public Integer getHumidity() {
    return humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }

  public Integer getCloud() {
    return cloud;
  }

  public void setCloud(Integer cloud) {
    this.cloud = cloud;
  }

  public Float getFeelslike_f() {
    return feelslike_f;
  }

  public void setFeelslike_f(Float feelslike_f) {
    this.feelslike_f = feelslike_f;
  }

  public Float getVis_miles() {
    return vis_miles;
  }

  public void setVis_miles(Float vis_miles) {
    this.vis_miles = vis_miles;
  }
}
