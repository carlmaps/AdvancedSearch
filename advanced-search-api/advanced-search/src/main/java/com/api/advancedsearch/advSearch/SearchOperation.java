package com.api.advancedsearch.advSearch;

public enum SearchOperation {

    CONTAINS, DOES_NOT_CONTAIN, EQUAL, NOT_EQUAL, BEGINS_WITH, DOES_NOT_BEGIN_WITH, ENDS_WITH,
    DOES_NOT_END_WITH, NUL, NOT_NULL, GREATER_THAN, GREATER_THAN_EQUAL, LESS_THAN, LESS_THAN_EQUAL,
    ANY, ALL;

    public static final String[] SIMPLE_OPERATION_SET = {"cn", "nc", "eq", "ne", "bw", "bn", "ew",
                                                         "en", "nu", "nn", "gt", "ge", "lt", "le"};

    public static SearchOperation getDataOption(final String dataOption){
        switch(dataOption){
            case "all": return ALL;
            case "any": return ANY;
            default: return null;
        }
    }

    public static SearchOperation getSimpleOperation(final String input) {
        switch (input){
            case "cn": return CONTAINS;
            case "nc": return DOES_NOT_CONTAIN;
            case "eq": return EQUAL;
            case "ne": return NOT_EQUAL;
            case "bw": return BEGINS_WITH;
            case "bn": return DOES_NOT_BEGIN_WITH;
            case "ew": return ENDS_WITH;
            case "en": return DOES_NOT_END_WITH;
            case "nu": return NUL;
            case "nn": return NOT_NULL;
            case "gt": return GREATER_THAN;
            case "ge": return GREATER_THAN_EQUAL;
            case "lt": return LESS_THAN;
            case "le": return LESS_THAN_EQUAL;

            default: return null;
        }
    }

}
