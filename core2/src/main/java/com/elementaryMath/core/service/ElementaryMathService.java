package com.elementaryMath.core.service;

import org.springframework.stereotype.Service;

import com.elementaryMath.core.controller.protocol.ElementaryMathRequest;
import com.elementaryMath.core.controller.protocol.ElementaryMathResponse;
import com.elementaryMath.core.model.commons.CalculationMemory;
import com.elementaryMath.core.model.commons.ElementaryMathOperation;
import com.elementaryMath.core.model.operations.SumOperation;

@Service
public class ElementaryMathService {
    
    private ElementaryMathOperation elementaryMathOperation;

    public ElementaryMathService() {}

    public ElementaryMathResponse execute(ElementaryMathRequest request) {
        elementaryMathOperation = new SumOperation(request.getValues(), Integer.parseInt(request.getStep()));
        CalculationMemory calculationMemory = elementaryMathOperation.execute();
        return new ElementaryMathResponse(calculationMemory);
    }

}
