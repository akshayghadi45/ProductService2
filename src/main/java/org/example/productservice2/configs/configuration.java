package org.example.productservice2.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class configuration {
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
