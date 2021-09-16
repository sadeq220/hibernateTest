package com.sadeqtest.demo.centeralExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    ResourceBundle bundle = ResourceBundle.getBundle("error-messages");
    @org.springframework.web.bind.annotation.ExceptionHandler(value = NullPointerException.class)
    public void convertException(HttpServletResponse response) throws IOException {
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
         response.sendError(404,"dosn't access");
        //throw new ResponseStatusException(HttpStatus.NOT_FOUND,"dosn't access");
       // return ResponseEntity.ok("hello sadeq");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //return super.handleMethodArgumentNotValid(ex, headers, status, request);
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        Properties errors=new Properties();
        for (FieldError fe : fieldErrors){
            String message=bundle.getString(fe.getDefaultMessage());
            String fieldName=fe.getField();
            errors.put(fieldName,message);
        }
        return ResponseEntity.status(status).body(errors);
    }
}
