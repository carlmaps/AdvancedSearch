package com.api.advancedsearch.service;

import com.api.advancedsearch.dao.DepartmentRepository;
import com.api.advancedsearch.domain.Department;
import com.api.advancedsearch.dto.DepartmentDto;
import com.api.advancedsearch.mapper.DomainDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptRepository;

    public DepartmentDto addDepartment(DepartmentDto departmentDto){
        Department dept = DomainDtoMapper.getDepartment(departmentDto);
        return DomainDtoMapper.getDepartmentDto(deptRepository.saveAndFlush(dept));
    }
}
