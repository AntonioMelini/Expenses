package com.project.service;

import com.project.dto.request.ExpenseCategoryRequestDto;

import java.util.List;

public interface ExpenseCategoryService {
    String insert(ExpenseCategoryRequestDto expenseCategoryRequestDto);

    List<ExpenseCategoryRequestDto> getAll();

    ExpenseCategoryRequestDto getById(int id);

    ExpenseCategoryRequestDto getByName(String name);
}
