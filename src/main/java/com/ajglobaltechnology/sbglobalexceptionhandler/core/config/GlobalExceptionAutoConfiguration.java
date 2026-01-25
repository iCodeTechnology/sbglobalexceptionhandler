package com.ajglobaltechnology.sbglobalexceptionhandler.core.config;

import com.ajglobaltechnology.sbglobalexceptionhandler.core.exception.advice.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnMissingBean(GlobalExceptionHandler.class)
@Import(GlobalExceptionHandler.class)
public class GlobalExceptionAutoConfiguration {
}