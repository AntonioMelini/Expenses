package com.project.exception.expense;

public class NoExpenseFound extends RuntimeException {
    public NoExpenseFound(String msg){
        super(msg);
    }
}
