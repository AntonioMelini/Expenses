package com.project.exception.expenseCategory;

public class NoExpenseCategoryFound extends RuntimeException{
    public NoExpenseCategoryFound(String msg){
        super(msg);
    }
}
