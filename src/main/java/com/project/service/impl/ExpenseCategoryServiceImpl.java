package com.project.service.impl;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.repository.ExpenseCategoryRepository;
import com.project.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {
    private final ExpenseCategoryRepository expenseCatergoryRepository;
    @Autowired
    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository expenseCategoryRepository){
        this.expenseCatergoryRepository=expenseCategoryRepository;
    }
    @Override
    public String insert(ExpenseCategoryRequestDto expenseCategoryRequestDto) {
        Integer rowsAffected= expenseCatergoryRepository.insert(mapToExpenseCategory(expenseCategoryRequestDto));
        if(rowsAffected.equals(0)){
            return "No se creo nada, algo anda mal ";
        }
        return "Se creo perfectamente la categoria";
    }

    @Override
    public List<ExpenseCategoryRequestDto> getAll() {
        return expenseCatergoryRepository.getAll();
    }

    private ExpenseCategory mapToExpenseCategory(ExpenseCategoryRequestDto expenseCategoryRequestDto){
        ExpenseCategory expenseCategory=new ExpenseCategory();
        expenseCategory.setName(expenseCategoryRequestDto.getName());
        return expenseCategory;
    }
}
