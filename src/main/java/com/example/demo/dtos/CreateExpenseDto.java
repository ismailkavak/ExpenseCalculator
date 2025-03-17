package com.example.demo.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateExpenseDto {
    @NotNull(message = "Kullanıcı adı boş olamaz!")
    private String username;
    @NotNull(message = "Kategori alanı boş olamaz!")
    private String category;
    @NotNull(message = "Tutar alanı boş olamaz!")
    private Integer amount;
    @NotNull(message = "Tarih alanı boş girilemez!")
    private LocalDate date;
}