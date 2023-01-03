package com.jio.sample.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @CircuitBreaker(name="backendB")
    @GetMapping("/get")
    public String getData() {
        return "API controller";
    }

}
