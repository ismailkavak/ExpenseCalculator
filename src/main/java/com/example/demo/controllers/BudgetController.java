package com.example.demo.controllers;

import com.example.demo.dtos.BudgetResponseDto;
import com.example.demo.dtos.CreateBudgetDto;
import com.example.demo.service.expense.BudgetService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
@CrossOrigin
public class BudgetController {
    private final BudgetService budgetService;

    @PostMapping
    public BudgetResponseDto saveBudget(@RequestBody @Valid CreateBudgetDto budgetDto){
        return budgetService.saveBudget(budgetDto);
    }

    @GetMapping
    public List<BudgetResponseDto> getBudgets(){
        return budgetService.getBudgets();
    }
}
