package com.example.demo.dtos;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CreateBudgetDto {
    @Min(0)
    private Integer budget;
}
