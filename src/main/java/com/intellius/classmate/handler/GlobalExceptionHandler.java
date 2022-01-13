package com.intellius.classmate.handler;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponseMessage> NoUserException(){

        System.out.println("GlobalExceptionHandler.NoUserException");
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data(null).message("존재하지 않는 사용자").build();

        return new ResponseEntity<> (apiResponseMessage, HttpStatus.OK);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ApiResponseMessage> NoAuthException(){

        System.out.println();
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data(null).message("조회권한 없음").build();

        return new ResponseEntity<> (apiResponseMessage, HttpStatus.BAD_REQUEST);
    }
}
