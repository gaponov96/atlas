package com.gaponov.externalIntegration;

import org.apache.commons.httpclient.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public HttpClient restClient() {
        HttpClient httpClient = new HttpClient();
        /*
            настройка клиента
         */
        return httpClient ;
    }
}
