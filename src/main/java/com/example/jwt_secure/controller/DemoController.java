package com.example.jwt_secure.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/hello")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> hello(){
        log.info("START point: {}", "Ok");
        return ResponseEntity.ok("Hello world!!!!!");
    }
}
