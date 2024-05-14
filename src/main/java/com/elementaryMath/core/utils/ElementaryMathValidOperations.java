package com.elementaryMath.core.utils;

import lombok.ToString;

@ToString
public enum ElementaryMathValidOperations {
    
    SUM("sum"), 
    SUBTRACTION("subtraction"), 
    MULTIPLICATION("multiplication"), 
    DIVISION("division");
 
    private final String operation;
 
    ElementaryMathValidOperations(final String operation) {
        this.operation = operation;
    }
 
    public String getOperation() {
        return operation;
    }

}
