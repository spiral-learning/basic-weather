package com.welltestedlearning.basicweather.provider.openweathermap;

import com.welltestedlearning.basicweather.WeatherResponse;
import com.welltestedlearning.basicweather.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Primary
@Service
public class OpenWeatherMapService implements WeatherService {

    private static final String ZIP_API_URL = "https://api.openweathermap.org/data/2.5/weather?zip={zip}&units=imperial&appid={appid}";

    private final String openWeatherMapAppId;
    private final RestTemplate restTemplate = new RestTemplate();

    public OpenWeatherMapService(@Value("${openweathermap.app.id}") String openWeatherMapAppId) {
        this.openWeatherMapAppId = openWeatherMapAppId;
    }

    @Override
    public ResponseEntity<WeatherResponse> current(String zipCode) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("zip", zipCode);
        uriVariables.put("appid", openWeatherMapAppId);

        ResponseEntity<OpenWeatherMapResponse> weatherStackResponseEntity =
                restTemplate.getForEntity(ZIP_API_URL,
                                          OpenWeatherMapResponse.class,
                                          uriVariables);

        return weatherStackResponseEntity.getBody().toResponseEntity();
    }
}
