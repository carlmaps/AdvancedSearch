package com.api.advancedsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMP_ID")
    private Long empId;

    @Column(name = "EMP_LASTNM")
    private String emplastNm;

    @Column(name = "EMP_FIRSTNM")
    private String  empfirstNm;

    @Column(name = "JOB_NM")
    private String jobNm;

    @Column(name = "MGR_ID", nullable = true)
    private Long managerId;

    @Column(name = "HIREDT")
    private Date hireDt;

    @Column(name = "SALARY")
    private double salary;

    @Column(name = "COMMISSION", nullable = true)
    private double commission;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department department;

}
