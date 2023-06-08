package com.museri.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(getInterceptors());
        return restTemplate;
    }

    private List<ClientHttpRequestInterceptor> getInterceptors() {
        return Collections.singletonList(new LoggingInterceptor());
    }
}