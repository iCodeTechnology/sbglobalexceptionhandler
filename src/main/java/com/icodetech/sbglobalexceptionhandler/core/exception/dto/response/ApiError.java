package com.icodetech.sbglobalexceptionhandler.core.exception.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiError<T> {

    private HttpStatus httpStatus;
    private Integer responseCode;
    private String responseMessage;
    private T errors;
}
