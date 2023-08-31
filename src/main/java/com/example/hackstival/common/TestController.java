package com.example.hackstival.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam String name) {
        return ResponseEntity.ok("hello " + name);
    }
}