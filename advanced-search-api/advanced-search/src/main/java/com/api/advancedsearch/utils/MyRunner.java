package com.api.advancedsearch.utils;

import com.api.advancedsearch.domain.Department;
import com.api.advancedsearch.domain.Employee;
import com.api.advancedsearch.dto.DepartmentDto;
import com.api.advancedsearch.dto.EmployeeDto;
import com.api.advancedsearch.dto.SalaryGradeDto;
import com.api.advancedsearch.service.DepartmentService;
import com.api.advancedsearch.service.EmployeeService;
import com.api.advancedsearch.service.SalaryGradeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SalaryGradeService salaryGradeService;

    @Override
    public void run(String... args) throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/department.json");
            log.info("Saving Department data");
            List<DepartmentDto> dept = objectMapper.readValue(inputStream, new TypeReference<List<DepartmentDto>>() {});
            dept.stream().forEach(x -> departmentService.addDepartment(x));
            log.info("Successfully save");

            inputStream = TypeReference.class.getResourceAsStream("/json/employee.json");
            log.info("Saving Employee data");
            List<EmployeeDto> empList = objectMapper.readValue(inputStream, new TypeReference<List<EmployeeDto>>() {});
            empList.stream().forEach(x -> employeeService.addEmployee(x));
            log.info("Successfully save");

            inputStream = TypeReference.class.getResourceAsStream("/json/salarygrade.json");
            log.info("Saving Salary grade data");
            List<SalaryGradeDto> salaryGrade = objectMapper.readValue(inputStream, new TypeReference<List<SalaryGradeDto>>() {});
            salaryGrade.stream().forEach(x -> salaryGradeService.addSalaryGrade(x));
            log.info("Successfully save");
        }
        catch(IOException e){
            log.error("Unable to save data" + e.getMessage());
        }
    };

}
