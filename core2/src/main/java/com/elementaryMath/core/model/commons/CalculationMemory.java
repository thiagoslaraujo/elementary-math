package com.elementaryMath.core.model.commons;

import java.util.Map;

import com.elementaryMath.core.model.extras.ElementaryMathExtras;
import com.elementaryMath.core.model.results.ElementaryMathResults;
import com.elementaryMath.core.utils.ElementaryMathValidOperations;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
@Getter
public class CalculationMemory {
    
    private ElementaryMathExtras extras;
    private Map<String, Number> numbers;
    private ElementaryMathResults results;
    private int step;
    private boolean done;
    private ElementaryMathValidOperations operation;

    public int getTotalOfItems() {
        return this.getNumbers().get("a").getItems().size();
    }

}
