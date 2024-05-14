package com.elementaryMath.core.model.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Number {
    
    private int number = 0;
    private List<Integer> items = null;

    public Number(String number) {
        //this.number = Integer.parseInt(number);
        this.items = new ArrayList<Integer>();
        for(String s : new ArrayList<String>(Arrays.asList(number.split("")))) {
            this.items.add(Integer.parseInt(s));
        }
    }

    public List<Integer> getItems() {
        return this.items;
    }

    public int size() {
        return this.items.size();
    }
    
}
