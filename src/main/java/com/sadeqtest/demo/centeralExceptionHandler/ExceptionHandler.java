package com.sadeqtest.demo.centeralExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    public void convertException(HttpServletResponse response) throws IOException {
        response.sendError(404,"dosn't access");
        //throw new ResponseStatusException(HttpStatus.NOT_FOUND,"dosn't access");
       // return ResponseEntity.ok("hello sadeq");
    }
}
