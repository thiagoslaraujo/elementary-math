package com.elementaryMath.core.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.elementaryMath.core.controller.protocol.ElementaryMathRequest;
import com.elementaryMath.core.controller.protocol.ElementaryMathResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Component
public class ElementaryMathNotificationService {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(ElementaryMathRequest requestPayload, ElementaryMathResponse responsePayload) {
        Map<String, String> payload = new HashMap<String, String>();
        payload.put("request", requestPayload.toString());
        payload.put("response", responsePayload.toString());
        
        try {
            log.info("trying to send message do queue...");
            rabbitTemplate.convertAndSend(this.queue.getName(), payload);
            log.info("message sent to queue successfully");
        } catch (Exception e) {
            log.error("an error was found when trying to send message to the queue: {}", e.getMessage());
        }
    }

}
