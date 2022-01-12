package com.intellius.classmate.handler;

import com.intellius.classmate.apiResponse.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Message> ExceptionTest(){

        System.out.println("GlobalExceptionHandler.ExceptionTest");

        Message message = new Message();
        message = Message.builder().data(null).message("id = 1은 요청불가").build();

        return new ResponseEntity<> (message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Message> NoUserException(){

        System.out.println("GlobalExceptionHandler.NoUserException");

        Message message = new Message();
        message = Message.builder().data(null).message("존재하지 않는 사용자").build();

        return new ResponseEntity<> (message, HttpStatus.OK);
    }
}
