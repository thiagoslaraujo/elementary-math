package com.elementaryMath.core.model.results;

import java.util.LinkedList;

public interface ElementaryMathResults {
    
    public Integer peek();

    public Integer pop();

    public void push(int n);

    public LinkedList<Integer> getValues();

}
