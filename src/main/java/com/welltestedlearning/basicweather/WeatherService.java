package com.welltestedlearning.basicweather;

import org.springframework.http.ResponseEntity;

public interface WeatherService {
  ResponseEntity<WeatherResponse> current(String zipCode);
}
