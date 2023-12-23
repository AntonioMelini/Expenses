package com.project.exception.controller;

import com.project.exception.expense.NoExpenseFound;
import com.project.exception.api.ApiError;
import com.project.exception.expenseCategory.NoExpenseCategoryFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;


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


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException e){

        Map<String, String> error= new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((err)-> {
           String fieldName= ((FieldError)err).getField();
           String errorMessage= err.getDefaultMessage();
            error.put(fieldName,errorMessage);
        });
        return error;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Map<String, String> handleValidationException(HttpMessageNotReadableException e){

        Map<String, String> error= new HashMap<>();
        error.put("amount","amount Have To Be Numeric!!!!");
        return error;
    }







}
