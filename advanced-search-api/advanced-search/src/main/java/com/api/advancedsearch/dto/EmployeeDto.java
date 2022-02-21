package com.api.advancedsearch.dto;

import com.api.advancedsearch.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long empId;
    private String emplastNm;
    private String empfirstNm;
    private String jobNm;
    private Long managerId;
    private Date hireDt;
    private double salary;
    private double commission;
    private Department department;
}
