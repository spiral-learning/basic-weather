package com.welltestedlearning.basicweather.provider.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    private long humidity;
    private long pressure;
    private double temp;
    @JsonProperty("temp_max")
    private double tempMax;
    @JsonProperty("temp_min")
    private double tempMin;

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }
}
