package com.example.demo.service.expense;

import com.example.demo.Mapper.BudgetMapper;
import com.example.demo.dtos.BudgetResponseDto;
import com.example.demo.dtos.CreateBudgetDto;
import com.example.demo.entities.BudgetEntity;
import com.example.demo.entities.ExpenseEntity;
import com.example.demo.repository.BudgetRepository;
import com.example.demo.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;

    public BudgetResponseDto saveBudget(CreateBudgetDto budgetDto) {
        // DTO -> Entity
        BudgetEntity budget = budgetMapper.toEntity(budgetDto);

        // Save Entity
        BudgetEntity savedBudget = budgetRepository.save(budget);

        // Entity -> ResponseDto
        return budgetMapper.toResponseDto(savedBudget);

    }

    public List<BudgetResponseDto> getBudgets(){
        List<BudgetEntity> allBudgets = budgetRepository.findAll();
        return budgetMapper.toResponseDtoList(allBudgets);
    }
}
