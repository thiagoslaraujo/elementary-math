package com.elementaryMath.core.controller.api;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.CoreMatchers.is;

//import com.elementaryMath.core.service.ElementaryMathService;

@WebMvcTest(ElementaryMathController.class)
public class ElementaryMathControllerTest {

    @Autowired
    private MockMvc mvc;

    //@MockBean
    //private ElementaryMathService service;

    //List<String> values = new ArrayList<String>();
    
    @Test
    public void testWithoutAnyParameters() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithOnlyOperationParameter_withoutValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithJustOperationParameter_withInvalidValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=abc")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['operation.error']", is("the operation parameter has an invalid value")));
    }

    @Test
    public void testWithOnlyOperationParameter_withLowerCase() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(2)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")));
    }

    @Test
    public void testWithOnlyOperationParameter_withUpperCase() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=Sum")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(2)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")));
    }

    @Test
    public void testWithOnlyStepParameter_withoutValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?step=")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithJustStepParameter_withInvalidValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?step=abc")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.error']", is("step parameter has an invalid value")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithOnlyStepParameter_withValidValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?step=1")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(2)))
            .andExpect(jsonPath("$.errors.[0].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithJustStepParameter_withZeroValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?step=0")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.error']", is("step parameter must be greater than zero")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithOnlyValuesParameter_withoutValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?values=")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['values.missing']", is("values parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithJustValuesParameter_withInvalidValue() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?values=abc")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['operation.missing']", is("operation parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['values.error']", is("values parameter must have at least two values")));
    }

    @Test
    public void testWithOnlyOperationParameter_withOneParameter() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?values=1")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['operation.missing']", is("operation parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['values.error']", is("values parameter must have at least two values")));
    }

    @Test
    public void testWithOnlyOperationParameter_withTwoParameters() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?values=1,2")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(2)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['operation.missing']", is("operation parameter is missing")));
    }

    @Test
    public void testWithOnlyOperationParameter_withTwoParametersAndOneWithError() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?values=1,2a")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors").isNotEmpty())
            .andExpect(jsonPath("$.errors").isArray())
            .andExpect(jsonPath("$.errors", hasSize(3)))
            .andExpect(jsonPath("$.errors.[0].['step.missing']", is("step parameter is missing")))
            .andExpect(jsonPath("$.errors.[1].['operation.missing']", is("operation parameter is missing")))
            .andExpect(jsonPath("$.errors.[2].['values.error.2a']", is("'2a' is an invalid value inside values parameter")));
    }

    @Test
    public void testSum123Plus123_withStep1() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=1&values=123,123")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(6))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(0))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(1)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
    }

    @Test
    public void testSum123Plus123_withStep2() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=2&values=123,123")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(4,6))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(0,0))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(2)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
    }

    @Test
    public void testSum123Plus123_withStep3() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=3&values=123,123")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(2,4,6))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(0,0,0))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(3)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
    }

    @Test
    public void testSum123Plus123_withStep4() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=4&values=123,123")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(2,4,6))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(1,2,3))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(0,0,0))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(4)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
    }

    @Test
    public void testSum999Plus999_withStep1() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=1&values=999,999")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(8))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(1))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(1)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
    }

    @Test
    public void testSum999Plus999_withStep2() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=2&values=999,999")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(9,8))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(1,1))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(2)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
    }

    @Test
    public void testSum999Plus999_withStep3() throws Exception {
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=3&values=999,999")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(9,9,8))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(1,1,1))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(3)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
    }

    @Test
    public void testSum999Plus999_withStep4() throws Exception {
      /*
        mvc.perform(MockMvcRequestBuilders
  			.get("/elementary-math/?operation=sum&step=4&values=999,999")
  			.accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.errors").doesNotExist())
            .andExpect(jsonPath("$.data").exists())
            .andExpect(jsonPath("$.data").isArray())
            .andExpect(jsonPath("$.data", hasSize(5)))
            .andExpect(jsonPath("$.data[0].result").exists())
            .andExpect(jsonPath("$.data[0].result.values", is(Arrays.asList(19,9,8))))
            .andExpect(jsonPath("$.data[1].values").exists())
            .andExpect(jsonPath("$.data[1].values.a.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[1].values.b.items", is(Arrays.asList(9,9,9))))
            .andExpect(jsonPath("$.data[2].extras").exists())
            .andExpect(jsonPath("$.data[2].extras.values", is(Arrays.asList(1,1,1))))
            .andExpect(jsonPath("$.data[3].step").exists())
            .andExpect(jsonPath("$.data[3].step", is(4)))
            .andExpect(jsonPath("$.data[4].operation").exists())
            .andExpect(jsonPath("$.data[4].operation", is("SUM")));
            */
    }

}
