package com.icodetech.sbglobalexceptionhandler.core.annotation;

import com.icodetech.sbglobalexceptionhandler.core.config.ExceptionHandlingConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ExceptionHandlingConfig.class)
public @interface EnableGlobalExceptionHandling {
    // You can also add attributes here if you want to customize behavior
}
