package com.project.exception.expenseCategory;

public class ExpenseCategoryAlreadyCraeted extends RuntimeException{
    public ExpenseCategoryAlreadyCraeted(String msg){
        super(msg);
    }
}
