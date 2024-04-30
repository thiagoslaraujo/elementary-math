package com.elementaryMath.core.model.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.elementaryMath.core.model.extras.ElementaryMathExtras;
import com.elementaryMath.core.model.results.ElementaryMathResults;
import com.elementaryMath.core.utils.ElementaryMathValidOperations;

public abstract class ElementaryMathOperation {

    protected int step = 0;
    protected char letter = 'a';
    protected CalculationMemory calculationMemory = null;

    public ElementaryMathOperation( List<String> values, 
                                    ElementaryMathExtras extras, 
                                    ElementaryMathResults results, 
                                    ElementaryMathValidOperations operation,
                                    int step
    ) {
        this.step = step;
        this.calculationMemory =   CalculationMemory.builder()
                                                    .numbers(new HashMap<String, Number>())
                                                    .extras(extras)
                                                    .results(results)
                                                    .step(step)
                                                    .operation(operation)
                                                    .build();
        
        for(String s : normalizeNumbersInArray(values)) {
            this.calculationMemory.getNumbers().put(String.valueOf(letter++), new Number(s));
        }
    }

    public abstract CalculationMemory execute();

    /* retorna o tamanho em caractéres do número */
    private int getMaxLengthOfValues (List<String> values) {
        int n = 0;
        for(String s : values) {
            if(s.length() > n) {
                n = s.length();
            }
        }
        return n;
    }
    
    /* retorna um List<String> com os números formatados com zeros adicionados */
    private List<String> normalizeNumbersInArray(List<String> values) {
        List<String> newValues = new ArrayList<String>();
        for(String s : values) {
            newValues.add(String.format("%0" + getMaxLengthOfValues(values) + "d", Integer.parseInt(s)));
        }
        return newValues;
    }

    protected List<Integer> normalizeNumberToArray(int num, int zeros) {
        List<Integer> numbers = new ArrayList<Integer>();
        String numberFormatted = String.format("%0" + zeros + "d", num);
        for(String s : new ArrayList<String>(Arrays.asList(String.valueOf(numberFormatted).split("")))) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

}
