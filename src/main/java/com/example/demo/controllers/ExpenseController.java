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
@CrossOrigin(origins = "https://ismailk.top")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ExpenseResponseDto addExpense(@RequestBody @Valid CreateExpenseDto expense){
        System.out.println("CALISTIII");
        return expenseService.saveExpense(expense);
    }

    @GetMapping("/all")
    public List<ExpenseResponseDto> getAllExpenses(){
        System.out.println("AUTO DEPLOY WORKED!");
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