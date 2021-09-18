package com.welltestedlearning.basicweather.provider.weatherstack;

import com.welltestedlearning.basicweather.WeatherResponse;
import com.welltestedlearning.basicweather.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class WeatherStackService implements WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherStackService.class);

    private static final String WEATHER_STACK_URL = "http://api.weatherstack.com/current?access_key={apikey}&units=f&query={zip}";
    private final RestTemplate restTemplate = new RestTemplate();

    private final String weatherStackApiKey;

    public WeatherStackService(@Value("${weatherstack.api.key}") String weatherStackApiKey) {
        this.weatherStackApiKey = weatherStackApiKey;
    }

    @Override
    public ResponseEntity<WeatherResponse> current(String zipCode) {

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }
        });
        ResponseEntity<WeatherStackResponse> weatherStackResponseEntity =
                restTemplate.getForEntity(WEATHER_STACK_URL, WeatherStackResponse.class, weatherStackApiKey, zipCode);

        if (weatherStackResponseEntity.getStatusCode().is2xxSuccessful()) {
            return weatherStackResponseEntity.getBody().toResponseEntity();
        }

        log.warn("Non-successful status code: {}", weatherStackResponseEntity.getStatusCode());
        log.warn("Headers: {}", weatherStackResponseEntity.getHeaders());

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new WeatherResponse());
    }
}
