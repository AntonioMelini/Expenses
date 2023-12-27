package com.project.exception.expenseCategory;

public class ExpenseCategoryNameError extends RuntimeException{
    public ExpenseCategoryNameError (String msg){
        super(msg);
    }
}
