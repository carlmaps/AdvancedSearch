package com.api.advancedsearch.advSearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchDto {

    private List<SearchCriteria> searchCriteriaList;
    private String dataOption;

}
