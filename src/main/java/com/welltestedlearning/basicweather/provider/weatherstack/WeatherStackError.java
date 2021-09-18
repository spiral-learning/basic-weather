package com.welltestedlearning.basicweather.provider.weatherstack;

public class WeatherStackError {

    private long code;
    private String info;
    private String type;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
