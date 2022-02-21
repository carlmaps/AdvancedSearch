package com.api.advancedsearch.controller;

import com.api.advancedsearch.advSearch.EmpSpecificationBuilder;
import com.api.advancedsearch.advSearch.EmployeeSearchDto;
import com.api.advancedsearch.advSearch.SearchCriteria;
import com.api.advancedsearch.domain.Employee;
import com.api.advancedsearch.service.EmployeeService;
import com.api.advancedsearch.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AdvSearchController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/employees")
    public ResponseEntity<APIResponse> getAllEmployees(){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setData(empService.findAllEmployee());
        apiResponse.setMessage("Employee record retrieved successfully");
        apiResponse.setResponseCode(HttpStatus.OK);
        return new ResponseEntity<>(apiResponse, apiResponse.getResponseCode());
    }

    @PostMapping("/search")
    public ResponseEntity<APIResponse> searchEmployees(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                                       @RequestBody EmployeeSearchDto employeeSearchDto){
        System.out.println("employeeSearchDto:" + employeeSearchDto);
        APIResponse apiResponse = new APIResponse();
        EmpSpecificationBuilder builder = new EmpSpecificationBuilder();
        List<SearchCriteria> criteriaList = employeeSearchDto.getSearchCriteriaList();
        if(criteriaList != null){
            criteriaList.forEach(x-> {x.setDataOption(employeeSearchDto.getDataOption());
                                        builder.with(x);
            });

        }

        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by("empfirstNm")
                                   .ascending().and(Sort.by("emplastNm"))
                                   .ascending().and(Sort.by("department")).ascending());

        Page<Employee> employeePage = empService.findBySearchCriteria(builder.build(), page);

        apiResponse.setData(employeePage.toList());
        apiResponse.setResponseCode(HttpStatus.OK);
        apiResponse.setMessage("Successfully retrieved employee record");

        return new ResponseEntity<>(apiResponse, apiResponse.getResponseCode());
    }

}
