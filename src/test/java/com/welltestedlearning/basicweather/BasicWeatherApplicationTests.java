package com.welltestedlearning.basicweather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "openweathermap_app_id=test",
        "weatherstack_api_key=test"
})
public class BasicWeatherApplicationTests {

    @Test
    public void contextLoads() {
    }

}
