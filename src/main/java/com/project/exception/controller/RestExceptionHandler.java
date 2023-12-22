package com.project.exception.controller;

import com.project.exception.expense.NoExpenseFound;
import com.project.exception.api.ApiError;
import com.project.exception.expenseCategory.NoExpenseCategoryFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;


@RestController
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {NoExpenseFound.class})
    public ResponseEntity<ApiError> handleNoExpenseFoundException(NoExpenseFound e){
        ApiError error= new ApiError(400,e.getMessage(),LocalDateTime.now(ZoneId.of("GMT-3")).withNano(0));

        return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NoExpenseCategoryFound.class)
    public ResponseEntity<ApiError> handleNoExpenseCategoryFoundException(NoExpenseCategoryFound e){
        ApiError error= new ApiError(400,e.getMessage(),LocalDateTime.now(ZoneId.of("GMT-3")).withNano(0));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
