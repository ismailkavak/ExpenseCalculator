package com.example.demo.repository;

import com.example.demo.entities.BudgetEntity;
import com.example.demo.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<BudgetEntity, Long> {}