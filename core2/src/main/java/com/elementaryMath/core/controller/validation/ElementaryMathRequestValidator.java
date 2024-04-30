package com.elementaryMath.core.controller.validation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.elementaryMath.core.controller.protocol.ElementaryMathRequest;
import com.elementaryMath.core.utils.ElementaryMathValidOperations;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

@ToString
public class ElementaryMathRequestValidator {
    
    private final ElementaryMathRequest request;
    private Map<String, String> errors = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate = null;

    public ElementaryMathRequestValidator(ElementaryMathRequest request) {
        this.request = request;
        this.createdDate = new Date();
        this.errors = new HashMap<String, String>();
        validateElementaryMathRequest();
    }

    /*
    public Map<String, List<Map<String, String>>> getErrors() {
        List<Map<String, String>> errorsList = new ArrayList<Map<String, String>>();
        errorsList.add(this.errors);
        
        Map<String, List<Map<String, String>>> myErrors = new HashMap<String, List<Map<String, String>>>();
        myErrors.put("errors", errorsList);
        return myErrors;
    }
    */

    public Set<Entry<String, String>> getErrors() {
        return this.errors.entrySet();
    }

    public boolean isValid() {
        return this.errors.isEmpty() ? true : false;
    }

    private void validateElementaryMathRequest() {
        validateOperationParameter();
        validateStepParameter();
        validateValuesParameter();
    }

    private boolean validateOperationParameter() {
        if(this.request.getOperation() == null || this.request.getOperation().trim().equals("")) {
            this.errors.put("operation.missing", "operation parameter is missing");
            return false;
        }

        for(ElementaryMathValidOperations validOperation : ElementaryMathValidOperations.values()){
            if(this.request.getOperation().toLowerCase().equals(validOperation.getOperation().toLowerCase())){
                return true;
            }
        }

        this.errors.put("operation.error", "the operation parameter has an invalid value");
        return false;
    }

    private boolean validateStepParameter() {
        if(this.request.getStep() == null || this.request.getStep().trim().equals("")) {
            this.errors.put("step.missing", "step parameter is missing");
            return false;
        }
        
        if(this.request.getStep().equals("0")) {
            this.errors.put("step.error", "step parameter must be greater than zero");
            return false;
        }

        if (!this.request.getStep().matches("[0-9]+") && this.request.getStep().length() >= 1) {
            this.errors.put("step.error", "step parameter has an invalid value");
            return false;
        }

        return true;
    }

    private boolean validateValuesParameter() {
        if(this.request.getValues() == null || this.request.getValues().isEmpty()) {
            this.errors.put("values.missing", "values parameter is missing");
            return false;
        }

        if(this.request.getValues().size() < 2) {
            this.errors.put("values.error", "values parameter must have at least two values");
            return false;
        }

        for(String n : this.request.getValues()) {
            if (!n.matches("[0-9]+") && n.length() >= 1) {
                this.errors.put("values.error." + n, "'" + n + "' is an invalid value inside values parameter");
            }
        }
        return true;
    }

}
