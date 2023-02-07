package com.pawfor.trainingApplication.controller;

import com.pawfor.trainingApplication.exceptions.TrainingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleTrainingNotFoundException(TrainingNotFoundException e) {
        return new ResponseEntity<>("Training with given id does not exist.", HttpStatus.BAD_REQUEST);
    }
}
