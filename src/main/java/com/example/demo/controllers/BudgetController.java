package com.example.demo.controllers;

import com.example.demo.dtos.BudgetResponseDto;
import com.example.demo.dtos.CreateBudgetDto;
import com.example.demo.dtos.UpdateBudgetDto;
import com.example.demo.service.expense.BudgetService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://ismailk.top")
public class BudgetController {
    private final BudgetService budgetService;

    @PostMapping
    public BudgetResponseDto saveBudget(@RequestBody @Valid CreateBudgetDto budgetDto){
        return budgetService.saveBudget(budgetDto);
    }

    @GetMapping("/{id}")
    public BudgetResponseDto getBudgetById(@PathVariable Long id){
        return budgetService.getBudgetById(id);
    }

    @GetMapping
    public List<BudgetResponseDto> getBudgets(){
        return budgetService.getBudgets();
    }

    @PutMapping("/{id}")
    public BudgetResponseDto updateBudget(@PathVariable Long id, @RequestBody @Valid UpdateBudgetDto updateBudgetDto){
        return budgetService.updateBudget(id, updateBudgetDto);
    }
}