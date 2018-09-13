package com.welltestedlearning.basicweather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

  private static final String APIXU_URL = "https://api.apixu.com/v1/current.json?key=e4131fb33ec147b49a811446181309&q={zip}";
  private final RestTemplate restTemplate = new RestTemplate();

  @GetMapping("/api/weather/{zip}")
  public WeatherResponse findWeather(@PathVariable("zip") String zipCode) {
    ApixuWeather apixuWeather = restTemplate.getForObject(APIXU_URL, ApixuWeather.class, zipCode);

    if (apixuWeather != null) {
      return WeatherResponse.from(apixuWeather);
    }
    return new WeatherResponse();
  }

}
