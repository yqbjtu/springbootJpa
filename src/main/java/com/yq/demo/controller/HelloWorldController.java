package com.yq.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class HelloWorldController {


    @ApiOperation(value = "hello demo", notes = "just for demo")
    @GetMapping(value = "/hello", produces = "text/xml;charset=UTF-8")
    public String hello() {
        return "Hello World";
    }
}