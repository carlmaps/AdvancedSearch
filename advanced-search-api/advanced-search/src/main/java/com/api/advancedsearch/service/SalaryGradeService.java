package com.api.advancedsearch.service;

import com.api.advancedsearch.dao.SalaryGradeRepository;
import com.api.advancedsearch.domain.Employee;
import com.api.advancedsearch.domain.SalaryGrade;
import com.api.advancedsearch.dto.EmployeeDto;
import com.api.advancedsearch.dto.SalaryGradeDto;
import com.api.advancedsearch.mapper.DomainDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryGradeService {

    @Autowired
    private SalaryGradeRepository salaryGradeRepository;

    public SalaryGradeDto addSalaryGrade(SalaryGradeDto salaryGradeDtoDto){
        SalaryGrade salGrade = DomainDtoMapper.getSalaryGrade(salaryGradeDtoDto);
        return DomainDtoMapper.getSalaryGradeDto(salaryGradeRepository.saveAndFlush(salGrade));
    }
}
