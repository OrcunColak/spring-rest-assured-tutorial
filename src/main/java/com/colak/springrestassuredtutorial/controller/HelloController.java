package com.colak.springrestassuredtutorial.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // http://localhost:8080/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    // http://localhost:8080/hello/John
    @GetMapping("/hello/{name}")
    String sayHelloWithPathVariable(@PathVariable("name") String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("/hello1")
    String sayHelloWithRequestParameter(@RequestParam("name") String name){
        return "Hello, " + name + "!";
    }

    @PutMapping("/hello")
    public String updateMessage(@RequestBody String message) {
        return message;
    }

    @DeleteMapping("/hello")
    public String deleteMessage(@RequestBody String message) {
        return message;
    }
}

