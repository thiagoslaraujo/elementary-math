package com.elementaryMath.core.controller.protocol;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

@ToString
public class ElementaryMathRequest {
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date requestDate = new Date();

    //private String userRequest;

    private String operation;
    private String step;
    private List<String> values;

    public ElementaryMathRequest(final String operation, final String step, final List<String> values) {
        this.operation = operation;
        this.step = step;
        this.values = values;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getStep() {
        return this.step;
    }

    public List<String> getValues() {
        return this.values;
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

}
