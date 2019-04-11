package com.example.swaggerdemo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class SpringExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleConstraintViolationException(ConstraintViolationException exception) {

        System.out.println(exception.getMessage());
        System.out.println(exception.getLocalizedMessage());
        String message = exception.getMessage();
        String[] strings = message.split("\\.");
        if (strings.length == 2){
            System.out.println(strings[1]);
            message = strings[1];
        }
        String[] strings1 = message.split(":");
        if (strings1.length == 2) {
            return Collections.singletonMap(strings1[0], strings1[1].trim());
        }
        List<String> messages = exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

        System.out.println(messages);
        return Collections.singletonList(messages);
//        return error(exception.getConstraintViolations()
//                .stream()
//                .map(ConstraintViolation::getMessage)
//                .collect(Collectors.toList()));
    }

//    private Map error(Object message) {
//        return Collections.singletonMap("error", message);
//    }
}
