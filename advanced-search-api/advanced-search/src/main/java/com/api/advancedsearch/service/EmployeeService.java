package com.api.advancedsearch.service;

import com.api.advancedsearch.dao.EmployeeRepository;
import com.api.advancedsearch.domain.Employee;
import com.api.advancedsearch.dto.EmployeeDto;
import com.api.advancedsearch.mapper.DomainDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    public EmployeeDto addEmployee(EmployeeDto employeeDto){
        Employee emp = DomainDtoMapper.getEmployee(employeeDto);
        return DomainDtoMapper.getEmployeeDto(empRepository.saveAndFlush(emp));
    }

    public List<Employee> findAllEmployee(){
        return empRepository.findAll();
    }

    public Page<Employee> findBySearchCriteria(Specification<Employee> spec, Pageable page){
        Page<Employee> searchResult = empRepository.findAll(spec, page);
        return searchResult;
    }
}
