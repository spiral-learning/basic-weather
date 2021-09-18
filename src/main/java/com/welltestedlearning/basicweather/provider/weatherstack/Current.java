package com.welltestedlearning.basicweather.provider.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Current {

    private long cloudcover;
    private long feelslike;
    private long humidity;
    @JsonProperty("observation_time")
    private String observationTime;
    private long precip;
    private long pressure;
    private int temperature;
    @JsonProperty("uv_index")
    private long uvIndex;
    private long visibility;
    @JsonProperty("weather_code")
    private long weatherCode;
    @JsonProperty("weather_descriptions")
    private List<String> weatherDescriptions;
    @JsonProperty("weather_icons")
    private List<String> weatherIcons;
    @JsonProperty("wind_degree")
    private long windDegree;
    @JsonProperty("wind_dir")
    private String windDir;
    @JsonProperty("wind_speed")
    private long windSpeed;

    public long getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(long cloudcover) {
        this.cloudcover = cloudcover;
    }

    public long getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(long feelslike) {
        this.feelslike = feelslike;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public long getPrecip() {
        return precip;
    }

    public void setPrecip(long precip) {
        this.precip = precip;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public long getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(long uvIndex) {
        this.uvIndex = uvIndex;
    }

    public long getVisibility() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    public long getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(long weatherCode) {
        this.weatherCode = weatherCode;
    }

    public List<String> getWeatherDescriptions() {
        return weatherDescriptions;
    }

    public void setWeatherDescriptions(List<String> weatherDescriptions) {
        this.weatherDescriptions = weatherDescriptions;
    }

    public List<String> getWeatherIcons() {
        return weatherIcons;
    }

    public void setWeatherIcons(List<String> weatherIcons) {
        this.weatherIcons = weatherIcons;
    }

    public long getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(long windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public long getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(long windSpeed) {
        this.windSpeed = windSpeed;
    }
}
