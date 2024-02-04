package com.fmatheus.app.config.properties;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    public Decoder decoder() {
        return new JacksonDecoder(List.of(new JavaTimeModule()));
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder(List.of(new JavaTimeModule()));
    }

}
