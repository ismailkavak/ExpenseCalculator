package com.example.demo.Mapper;

import com.example.demo.dtos.BudgetResponseDto;
import com.example.demo.dtos.CreateBudgetDto;
import com.example.demo.entities.BudgetEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    // DTO -> Entity
    BudgetEntity toEntity(CreateBudgetDto budgetDto);

    // Entity -> ResponseDto
    BudgetResponseDto toResponseDto(BudgetEntity budget);

    // EntityList -> ResponseDtoList
    List<BudgetResponseDto> toResponseDtoList(List<BudgetEntity> budgets);
}