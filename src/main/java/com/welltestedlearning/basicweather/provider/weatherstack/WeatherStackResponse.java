package com.welltestedlearning.basicweather.provider.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.welltestedlearning.basicweather.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WeatherStackResponse {
    private static final Logger log = LoggerFactory.getLogger(WeatherStackResponse.class);

    @JsonProperty("error")
    private WeatherStackError weatherStackError;
    private Current current;
    private Location location;
    private Request request;

    private boolean succeeded() {
        return weatherStackError == null;
    }

    public ResponseEntity<WeatherResponse> toResponseEntity() {
        ResponseEntity<WeatherResponse> responseEntity;
        if (succeeded()) {
            WeatherResponse response = toResponse();
            responseEntity = ResponseEntity.ok(response);
        } else {
            responseEntity = createUnavailableResponse();
        }
        return responseEntity;
    }

    private WeatherResponse toResponse() {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setLocation(getLocation().getName() + ", " + getLocation().getRegion());
        weatherResponse.setUpdated(getLocation().getLocaltime());
        weatherResponse.setTemp(getCurrent().getTemperature());
        weatherResponse.setCondition(String.join(", ", getCurrent().getWeatherDescriptions()));
        return weatherResponse;
    }

    private ResponseEntity<WeatherResponse> createUnavailableResponse() {
        WeatherStackError error = getWeatherStackError();
        log.warn("WeatherStack error: code = {}, type = '{}', info = '{}'",
                 error.getCode(),
                 error.getType(),
                 error.getInfo());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new WeatherResponse());
    }

    public WeatherStackError getWeatherStackError() {
        return weatherStackError;
    }

    public void setWeatherStackError(
            WeatherStackError weatherStackError) {
        this.weatherStackError = weatherStackError;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
