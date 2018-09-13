package com.welltestedlearning.basicweather;

public class Location {

  private String name;
  private String region;
  private String country;
  private Float lat;
  private Float lon;
  private String tzId;
  private Integer localtime_epoch;
  private String localtime;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Float getLat() {
    return lat;
  }

  public void setLat(Float lat) {
    this.lat = lat;
  }

  public Float getLon() {
    return lon;
  }

  public void setLon(Float lon) {
    this.lon = lon;
  }

  public String getTzId() {
    return tzId;
  }

  public void setTzId(String tzId) {
    this.tzId = tzId;
  }

  public Integer getLocaltime_epoch() {
    return localtime_epoch;
  }

  public void setLocaltime_epoch(Integer localtime_epoch) {
    this.localtime_epoch = localtime_epoch;
  }

  public String getLocaltime() {
    return localtime;
  }

  public void setLocaltime(String localtime) {
    this.localtime = localtime;
  }
}