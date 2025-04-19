package com.example.demo.controllers;

import com.example.demo.dtos.CreateExpenseDto;
import com.example.demo.dtos.ExpenseResponseDto;
import com.example.demo.entities.ExpenseEntity;
import com.example.demo.service.expense.ExpenseService;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
@CrossOrigin
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ExpenseResponseDto addExpense(@RequestBody @Valid CreateExpenseDto expense){
//        return expenseService.saveExpense(expense);
    }

    @GetMapping("/all")
    public List<ExpenseResponseDto> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{username}")
    public List<ExpenseResponseDto> getUserExpenses(@PathVariable String username){
        return expenseService.getUserExpenses(username);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenseById(@PathVariable Long id){
        expenseService.deleteExpenseById(id);
    }
}