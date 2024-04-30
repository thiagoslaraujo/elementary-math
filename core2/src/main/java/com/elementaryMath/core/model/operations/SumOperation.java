package com.elementaryMath.core.model.operations;

import java.util.List;
import java.util.Map;

import com.elementaryMath.core.model.commons.CalculationMemory;
import com.elementaryMath.core.model.commons.ElementaryMathOperation;
import com.elementaryMath.core.model.commons.Number;
import com.elementaryMath.core.model.extras.SumExtras;
import com.elementaryMath.core.model.results.SumResult;
import com.elementaryMath.core.utils.ElementaryMathValidOperations;

public class SumOperation extends ElementaryMathOperation {
    
    public SumOperation(List<String> values, int step) {
        super( values, 
                new SumExtras(), 
                new SumResult(), 
                ElementaryMathValidOperations.SUM, 
                step
        );
    }

    public CalculationMemory execute() {
        int count = 1;
        int sum = 0;
        int totalOfItems = calculationMemory.getTotalOfItems();
        for(int i=totalOfItems-1; i >= 0; i--) {
            for (Map.Entry<String, Number> entry : calculationMemory.getNumbers().entrySet()) {
                //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue() + " peek() : " + calculationMemory.getExtras().peek());
                sum += entry.getValue().getItems().get(i);
            }

            sum += calculationMemory.getExtras().peek();

            calculationMemory.getExtras().push(normalizeNumberToArray(sum, 2).get(0));
            calculationMemory.getResults().push(normalizeNumberToArray(sum, 2).get(1));
            
            sum = 0;

            if(this.step == count) {
                return this.calculationMemory;
            }
            count++;
        }

        if(calculationMemory.getExtras().peek() > 0) {
            int n = calculationMemory.getResults().pop() + (calculationMemory.getExtras().peek() * 10);
            calculationMemory.getResults().push(n);
        }

        return this.calculationMemory;
    }

}
