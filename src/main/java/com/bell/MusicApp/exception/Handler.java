package com.bell.MusicApp.exception;

import com.bell.MusicApp.helpers.CODE;
import com.bell.MusicApp.responses.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.bell.MusicApp"})
@Slf4j
public class Handler {

    @ExceptionHandler({UserNotFoundException.class,PasswrodIncorrectException.class}) // exception handled
    public ResponseEntity<Response<?>> handleUserNotFoundException(
            Exception e
    ) {

        HttpStatus status = HttpStatus.BAD_REQUEST; // 400



        Response<Object> response = Response.builder()
                .message(e.getMessage())
                .code(CODE.BAD_REQUEST.getId())
                .success(false)
                .build();
        return new ResponseEntity<>(response, new HttpHeaders(), status);


    }


    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<Response<?>> handleExceptions(
            Exception e
    ) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500



        Response<Object> response = Response.builder()
                .message(e.getMessage())
                .code(CODE.INTERNAL_SERVER_ERROR.getId())
                .success(false)
                .build();
        return new ResponseEntity<>(response, new HttpHeaders(),status);


    }

}
