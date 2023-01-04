package com.jio.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jio.commons.httpclients","com.jio.sample"})
// https://youtrack.jetbrains.com/issue/IDEA-281454/Could-not-autowire.-No-beans-of-XXX-type-found-IntelliJ-2021.2.3-Spring-2.5.6
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
