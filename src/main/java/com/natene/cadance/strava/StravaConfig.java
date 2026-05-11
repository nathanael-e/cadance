package com.natene.cadance.strava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
class StravaConfig {

    @Bean
    RestClient stravaRestClient() {
        return RestClient.builder().baseUrl("https://www.strava.com/api/v3").build();
    }
}
