package com.example.demo.service.expense;

import com.example.demo.Mapper.ExpenseMapper;
import com.example.demo.dtos.CreateExpenseDto;
import com.example.demo.dtos.ExpenseResponseDto;
import com.example.demo.entities.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseResponseDto saveExpense(CreateExpenseDto expenseDto) {
        // DTO -> Entity
        ExpenseEntity expense = expenseMapper.toEntity(expenseDto);
        // Save Entity
        ExpenseEntity savedExpense = expenseRepository.save(expense);
        // Entity -> ResponseDTO
        return expenseMapper.toResponseDto(savedExpense);
    }

    public  List<ExpenseResponseDto> getAllExpenses(){
        List<ExpenseEntity> allExpenses = expenseRepository.findAll();
        return expenseMapper.toResponseDtoList(allExpenses);
    }

    public List<ExpenseResponseDto> getUserExpenses(String username){
        List<ExpenseEntity> expenses = expenseRepository.findByUsername(username);
        return expenseMapper.toResponseDtoList(expenses);
    }

    public void deleteExpenseById(Long id){
        expenseRepository.deleteById(id);
    }
}