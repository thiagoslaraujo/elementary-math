package com.elementaryMath.core;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ElementaryMathApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElementaryMathApplication.class, args);
	}

}
