package com.java_backend.Finance_Tracker_Java_Springboot.dto;

import com.java_backend.Finance_Tracker_Java_Springboot.entity.EntryType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntryDto {
    private Long id;

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotNull(message = "Category is required")
    private String category;

    @NotNull(message = "Date is required")
    private LocalDate date;

    private String description;

    @NotNull(message = "Type is required")
    private EntryType type;
}
