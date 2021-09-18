package com.welltestedlearning.basicweather.provider.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.welltestedlearning.basicweather.WeatherResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

public class OpenWeatherMapResponse {

    private String base;
    private Clouds clouds;
    private long cod;
    private Coord coord;
    @JsonProperty("dt")
    private long dateTimeInEpochSeconds;
    private long id;
    private Main main;
    private String name;
    private Sys sys;
    private int timezone;
    private long visibility;
    private List<Weather> weather;
    private Wind wind;

    public ResponseEntity<WeatherResponse> toResponseEntity() {
        WeatherResponse weatherResponse = new WeatherResponse();

        weatherResponse.setCondition(extractCondition());
        weatherResponse.setTemp((int) main.getTemp());
        weatherResponse.setUpdated(extractUpdated());
        weatherResponse.setLocation(name);

        return ResponseEntity.ok(weatherResponse);
    }

    private String extractUpdated() {
        ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(timezone);
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(dateTimeInEpochSeconds, 0, zoneOffset);
        return dateTime.toString();
    }

    private String extractCondition() {
        return weather.stream()
                      .map(Weather::getDescription)
                      .collect(Collectors.joining(", "));
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public long getDateTimeInEpochSeconds() {
        return dateTimeInEpochSeconds;
    }

    public void setDateTimeInEpochSeconds(long dateTimeInEpochSeconds) {
        this.dateTimeInEpochSeconds = dateTimeInEpochSeconds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
