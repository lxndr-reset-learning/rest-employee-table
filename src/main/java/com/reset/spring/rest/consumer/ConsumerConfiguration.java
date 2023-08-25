package com.reset.spring.rest.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.reset.spring.rest.consumer")
public class ConsumerConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
