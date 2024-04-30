package com.elementaryMath.core.model.extras;

import java.util.LinkedList;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class SumExtras implements ElementaryMathExtras {
    
    private LinkedList<Integer> extras = null;

    public SumExtras() {
        this.extras = new LinkedList<Integer>();
    }

    public Integer peek() {
        if (this.extras.isEmpty()) {
            return 0;
        }
        return this.extras.peek();
    }

    public Integer pop() {
        return this.extras.pop();
    }

    public void push(int n) {
        this.extras.addFirst(n);
    }

    public LinkedList<Integer> getValues() {
        return this.extras;
    }

}
