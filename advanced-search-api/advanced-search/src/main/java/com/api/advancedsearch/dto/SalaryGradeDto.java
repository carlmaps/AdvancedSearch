package com.api.advancedsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryGradeDto {
    private Long grade;
    private double minSalary;
    private double maxSalary;
}
