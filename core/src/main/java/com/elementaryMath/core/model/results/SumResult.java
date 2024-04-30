package com.elementaryMath.core.model.results;

import java.util.LinkedList;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class SumResult implements ElementaryMathResults{
    
    private LinkedList<Integer> result = null;

    public SumResult() {
        this.result = new LinkedList<Integer>();
    }

    public Integer peek() {
        if (this.result.isEmpty()) {
            return 0;
        }
        return this.result.peek();
    }

    public Integer pop() {
        return this.result.pop();
    }

    public void push(int n) {
        this.result.addFirst(n);
    }

    public LinkedList<Integer> getValues() {
        return this.result;
    }

}
