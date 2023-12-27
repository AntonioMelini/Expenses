package com.project.service.impl;

import com.project.dto.request.ExpenseCategoryRequestDto;
import com.project.entity.ExpenseCategory;
import com.project.exception.expenseCategory.ExpenseCategoryNameError;
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
            return "No se creo la ExpenseCAtegory ";
        }
        return "Se creo perfectamente la ExpenseCategory";
    }

    @Override
    public List<ExpenseCategoryRequestDto> getAll() {
        return expenseCatergoryRepository.getAll();
    }

    @Override
    public ExpenseCategoryRequestDto getById(int id) {
        return expenseCatergoryRepository.getById(id);
    }

    @Override
    public ExpenseCategoryRequestDto getByName(String name) {

        return expenseCatergoryRepository.getByName(name);

    }

    private ExpenseCategory mapToExpenseCategory(ExpenseCategoryRequestDto expenseCategoryRequestDto){
        if (expenseCategoryRequestDto.getName().matches((".*[a-z].*"))) {
            ExpenseCategory expenseCategory = new ExpenseCategory();
            expenseCategory.setName(expenseCategoryRequestDto.getName());
            return expenseCategory;
        }
        throw new ExpenseCategoryNameError("Name must contain at least 1 letter!!");
    }
}
