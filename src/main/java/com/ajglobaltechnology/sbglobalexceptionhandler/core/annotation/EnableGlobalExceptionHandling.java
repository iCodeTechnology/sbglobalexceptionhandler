package com.ajglobaltechnology.sbglobalexceptionhandler.core.annotation;

import com.ajglobaltechnology.sbglobalexceptionhandler.core.config.GlobalExceptionAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(GlobalExceptionAutoConfiguration.class)
public @interface EnableGlobalExceptionHandling {
    // You can also add attributes here if you want to customize behavior
}
