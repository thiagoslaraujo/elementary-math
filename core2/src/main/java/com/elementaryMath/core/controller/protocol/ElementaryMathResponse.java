package com.elementaryMath.core.controller.protocol;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.elementaryMath.core.model.commons.CalculationMemory;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

@ToString
public class ElementaryMathResponse {
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date responseDate = new Date();
    
    private Map<String, Object> data;

    public ElementaryMathResponse(CalculationMemory calculationMemory) {
        this.data = new HashMap<String, Object>();
        this.data.put("extras", calculationMemory.getExtras());
        this.data.put("values", calculationMemory.getNumbers());
        this.data.put("result", calculationMemory.getResults());
        this.data.put("step", calculationMemory.getStep());
        this.data.put("operation", calculationMemory.getOperation());
    }

    public Set<Entry<String, Object>> getData() {
        return this.data.entrySet();
    }

}
