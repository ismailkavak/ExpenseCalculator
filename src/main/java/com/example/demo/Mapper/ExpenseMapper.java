package com.example.demo.Mapper;

import com.example.demo.dtos.CreateExpenseDto;
import com.example.demo.dtos.ExpenseResponseDto;
import com.example.demo.entities.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    // DTO -> Entity
    ExpenseEntity toEntity(CreateExpenseDto expenseDto);

    // Entity -> ResponseDto
    ExpenseResponseDto toResponseDto(ExpenseEntity expense);

    // EntityList -> ResponseDtoList
    List<ExpenseResponseDto> toResponseDtoList(List<ExpenseEntity> expenses);
}