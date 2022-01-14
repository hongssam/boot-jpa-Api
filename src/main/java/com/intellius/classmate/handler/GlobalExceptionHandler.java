package com.intellius.classmate.handler;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;
import javax.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponseMessage> ValidationException(){
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data(null).message("validationException").build();

        return new ResponseEntity<> (apiResponseMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AuthException.class})
    public ResponseEntity<ApiResponseMessage> NoAuthException(){
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data(null).message("조회권한 없음").build();

        return new ResponseEntity<> (apiResponseMessage, HttpStatus.BAD_REQUEST);
    }
}
