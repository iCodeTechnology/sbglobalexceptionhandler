package com.icodetech.sbglobalexceptionhandler.core.config;

import com.icodetech.sbglobalexceptionhandler.core.exception.advice.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionHandlingConfig {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
