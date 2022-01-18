package com.intellius.classmate.handler;

import com.google.protobuf.Api;
import com.intellius.classmate.apiResponse.ApiResponse;
import com.intellius.classmate.apiResponse.ApiResponseMessage;
import com.intellius.classmate.apiResponse.ErrorCode;
import com.intellius.classmate.user.service.impl.NotFoundUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;
import javax.validation.ValidationException;

@RestControllerAdvice
@Slf4j
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

    @ExceptionHandler(NotFoundUserException.class)
    public ApiResponse eee (Throwable e) {

        log.warn("NotFoundUserException :: {}", e.getMessage());
        log.info("");
        return ApiResponse.fail(ErrorCode.NOT_FOUND_USER);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse error500 (Throwable e) {
        return ApiResponse.fail(ErrorCode.FAIL);
    }
}
