package com.java_backend.Finance_Tracker_Java_Springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SummaryDto {
    private Double totalIncome;
    private Double totalExpense;
    private Double balance;

    public SummaryDto() {}

    public SummaryDto(Double totalIncome, Double totalExpense, Double balance) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
    }
}

