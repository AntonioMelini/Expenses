package com.project.service.impl;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.repository.ExpenseCategoryRepository;
import com.project.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {
    private final ExpenseCategoryRepository expenseCatergoryRepository;
    @Autowired
    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository expenseCategoryRepository){
        this.expenseCatergoryRepository=expenseCategoryRepository;
    }
    @Override
    public void insert(ExpenseCategoryRequestDto expenseCategoryRequestDto) {
        expenseCatergoryRepository.insert(mapToExpenseCategory(expenseCategoryRequestDto));

    }

    private ExpenseCategory mapToExpenseCategory(ExpenseCategoryRequestDto expenseCategoryRequestDto){
        ExpenseCategory expenseCategory=new ExpenseCategory();
        expenseCategory.setName(expenseCategoryRequestDto.getName());
        return expenseCategory;
    }
}
