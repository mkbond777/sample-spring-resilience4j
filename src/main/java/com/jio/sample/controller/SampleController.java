package com.jio.sample.controller;

import com.jio.commons.httpclients.models.ClientObj;
import com.jio.commons.httpclients.models.HttpMethods;
import com.jio.commons.httpclients.models.ResponseSync;
import com.jio.commons.httpclients.okhttp.OkHttp3;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final OkHttp3 okHttp3;

    public SampleController(OkHttp3 okHttp3) {
        this.okHttp3 = okHttp3;
    }

    @GetMapping("/get")
    public String getData() {

        ClientObj clientObj = ClientObj.builder()
                .retryCount(2)
                .build();
        record GetResponse(Boolean success) {
        }

        ResponseSync<GetResponse> responseSync = okHttp3
                .httpCallSync("https://reqbin.com/echo/get/json", null,
                        GetResponse.class, HttpMethods.GET,clientObj);

        return responseSync.toString();
    }

}
