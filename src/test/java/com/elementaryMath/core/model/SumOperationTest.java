package com.elementaryMath.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.elementaryMath.core.model.commons.CalculationMemory;
import com.elementaryMath.core.model.commons.ElementaryMathOperation;
import com.elementaryMath.core.model.extras.SumExtras;
import com.elementaryMath.core.model.operations.SumOperation;
import com.elementaryMath.core.model.results.SumResult;

public class SumOperationTest {
    
    List<String> values = new ArrayList<String>();
    
    public SumOperationTest() {}

    @Test
    public void testSum2Plus2WithStep1() {
        values = new ArrayList<String>();
        values.add("2");
        values.add("2");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);

        SumResult results = new SumResult();
        results.push(4);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum2Plus2WithStep2() {
        values = new ArrayList<String>();
        values.add("2");
        values.add("2");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);

        SumResult results = new SumResult();
        results.push(4);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum9Plus1WithStep1() {
        values = new ArrayList<String>();
        values.add("9");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);

        SumResult results = new SumResult();
        results.push(0);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum9Plus1WithStep2() {
        values = new ArrayList<String>();
        values.add("9");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);

        SumResult results = new SumResult();
        results.push(10);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum9Plus1WithStep3() {
        values = new ArrayList<String>();
        values.add("9");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 3);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);

        SumResult results = new SumResult();
        results.push(10);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum10Plus1WithStep1() {
        values = new ArrayList<String>();
        values.add("10");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);

        SumResult results = new SumResult();
        results.push(1);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum10Plus1WithStep2() {
        values = new ArrayList<String>();
        values.add("10");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(1);
        results.push(1);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum10Plus1WithStep3() {
        values = new ArrayList<String>();
        values.add("10");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 3);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(1);
        results.push(1);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum10Plus10WithStep1() {
        values = new ArrayList<String>();
        values.add("10");
        values.add("10");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);

        SumResult results = new SumResult();
        results.push(0);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum10Plus10WithStep2() {
        values = new ArrayList<String>();
        values.add("10");
        values.add("10");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(0);
        results.push(2);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum10Plus10WithStep3() {
        values = new ArrayList<String>();
        values.add("10");
        values.add("10");

        ElementaryMathOperation operation = new SumOperation(values, 3);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(0);
        results.push(2);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus99WithStep1() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("99");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);

        SumResult results = new SumResult();
        results.push(8);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus99WithStep2() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("99");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);
        extras.push(1);

        SumResult results = new SumResult();
        results.push(8);
        results.push(9);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus99WithStep3() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("99");

        ElementaryMathOperation operation = new SumOperation(values, 3);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);
        extras.push(1);

        SumResult results = new SumResult();
        results.push(8);
        results.push(19);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus99WithStep4() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("99");

        ElementaryMathOperation operation = new SumOperation(values, 4);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);
        extras.push(1);

        SumResult results = new SumResult();
        results.push(8);
        results.push(19);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus1WithStep1() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);

        SumResult results = new SumResult();
        results.push(0);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus1WithStep2() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);
        extras.push(1);

        SumResult results = new SumResult();
        results.push(0);
        results.push(0);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus1WithStep3() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 3);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);
        extras.push(1);

        SumResult results = new SumResult();
        results.push(0);
        results.push(10);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum99Plus1WithStep4() {
        values = new ArrayList<String>();
        values.add("99");
        values.add("1");

        ElementaryMathOperation operation = new SumOperation(values, 4);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(1);
        extras.push(1);

        SumResult results = new SumResult();
        results.push(0);
        results.push(10);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum123Plus321WithStep1() {
        values = new ArrayList<String>();
        values.add("123");
        values.add("321");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);

        SumResult results = new SumResult();
        results.push(4);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum123Plus321WithStep2() {
        values = new ArrayList<String>();
        values.add("123");
        values.add("321");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(4);
        results.push(4);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum123Plus321WithStep3() {
        values = new ArrayList<String>();
        values.add("123");
        values.add("321");

        ElementaryMathOperation operation = new SumOperation(values, 3);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(4);
        results.push(4);
        results.push(4);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void testSum123Plus321WithStep4() {
        values = new ArrayList<String>();
        values.add("123");
        values.add("321");

        ElementaryMathOperation operation = new SumOperation(values, 4);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(4);
        results.push(4);
        results.push(4);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void test100Plus0WithStep1() {
        values = new ArrayList<String>();
        values.add("100");
        values.add("0");

        ElementaryMathOperation operation = new SumOperation(values, 1);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);

        SumResult results = new SumResult();
        results.push(0);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void test100Plus0WithStep2() {
        values = new ArrayList<String>();
        values.add("100");
        values.add("0");

        ElementaryMathOperation operation = new SumOperation(values, 2);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(0);
        results.push(0);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void test100Plus0WithStep3() {
        values = new ArrayList<String>();
        values.add("100");
        values.add("0");

        ElementaryMathOperation operation = new SumOperation(values, 3);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(0);
        results.push(0);
        results.push(1);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

    @Test
    public void test100Plus0WithStep4() {
        values = new ArrayList<String>();
        values.add("100");
        values.add("0");

        ElementaryMathOperation operation = new SumOperation(values, 4);
        CalculationMemory memory = operation.execute();

        SumExtras extras = new SumExtras();
        extras.push(0);
        extras.push(0);
        extras.push(0);

        SumResult results = new SumResult();
        results.push(0);
        results.push(0);
        results.push(1);

        assertEquals(extras, memory.getExtras());
        assertEquals(results, memory.getResults());
    }

}
