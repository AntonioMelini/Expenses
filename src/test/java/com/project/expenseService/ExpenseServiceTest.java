package com.project.expenseService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.project.dto.request.ExpenseRequestDto;
import com.project.dto.response.ExpenseResponseDto;
import com.project.entity.Expense;
import com.project.repository.ExpenseCategoryRepository;
import com.project.repository.ExpenseRepository;
import com.project.repository.impl.ExpenseCategoryRepositoryImpl;
import com.project.repository.impl.ExpenseRepositoryImpl;
import com.project.service.ExpenseService;
import com.project.service.impl.ExpenseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Test
    @DisplayName("test a getAllEXpenses donde verificamos que se obtengan correctamente los gastos añadidos")
    public void getAllExpensesTest(){
        ExpenseRepository expenseRepository=Mockito.mock(ExpenseRepository.class);
        ExpenseService expenseService= new ExpenseServiceImpl(expenseRepository);
        List<ExpenseResponseDto> expenseResponseDtos = new ArrayList<>();
        ExpenseResponseDto dto= new ExpenseResponseDto(99.99,("Food"),"burger hifri","hoy");
        expenseResponseDtos.add(dto);


        Mockito.when(expenseService.getAllExpenses()).thenReturn(expenseResponseDtos);
        Mockito.when(expenseRepository.getAll()).thenReturn(expenseResponseDtos);

        Assertions.assertEquals(expenseRepository.getAll(),expenseService.getAllExpenses());

        Mockito.verify(expenseRepository, times(2)).getAll();
    }
    @Test
    @DisplayName("test a getExpenseById donde verificamos que se obtenga correctamente el gasto solicitado")
    public void getExpenseByIdTest(){
        ExpenseRepository expenseRepository=Mockito.mock(ExpenseRepository.class);
        ExpenseService expenseService= new ExpenseServiceImpl(expenseRepository);
        Expense objeto= new Expense(1L,"burger hifri",99.99,1,"hoy");
        ExpenseResponseDto esperado = new ExpenseResponseDto(99.99,"Food","burger hifri","hoy");


        Mockito.when(expenseService.getExpenseById(1)).thenReturn(esperado);
        Mockito.when(expenseRepository.getById(1)).thenReturn(esperado);

        Assertions.assertEquals(esperado,expenseRepository.getById(1));
        Assertions.assertEquals(esperado,expenseService.getExpenseById(1));

        Mockito.verify(expenseRepository, times(2)).getById(1);



    }
}
