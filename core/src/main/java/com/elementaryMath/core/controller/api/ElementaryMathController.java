package com.elementaryMath.core.controller.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elementaryMath.core.controller.protocol.ElementaryMathRequest;
import com.elementaryMath.core.controller.protocol.ElementaryMathResponse;
import com.elementaryMath.core.controller.validation.ElementaryMathRequestValidator;
import com.elementaryMath.core.service.ElementaryMathService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("elementary-math")
public class ElementaryMathController {

    //@Autowired
    //private ElementaryMathNotificationService notificationService;
    
	@CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> execute(
        @RequestParam(value = "operation", defaultValue = "", required = true) String operation,
        @RequestParam(value = "step", defaultValue = "", required = true) String step,
        @RequestParam(value = "values", required = false) List<String> values
    ) {
        ElementaryMathRequest request = new ElementaryMathRequest(operation, step, values);
        log.info("Request receive: {}", request.toString());

        ElementaryMathRequestValidator validator = new ElementaryMathRequestValidator(request);
        if(!validator.isValid()) {
            log.error("Errors: {}", validator.getErrors().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validator);
        }

        ElementaryMathResponse response = new ElementaryMathService().execute(request);
        log.info("Response produced: {}", response.toString());

        //notificationService.send(request, response);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/cache", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> readCache() {
        return ResponseEntity.status(HttpStatus.OK).body("lendo dados do cache");
    }

}
