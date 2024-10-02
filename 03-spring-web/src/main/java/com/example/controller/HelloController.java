package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/world")
    public ResponseEntity<Map<String, Object>> helloWorld() {
        return ResponseEntity.ok(Map.of("message", "Hello World"));
    }

    @GetMapping("/spring")
    public ResponseEntity<Map<String, Object>> helloSpring(@RequestParam String name) {
        return ResponseEntity.ok(Map.of("message", "Hello " + name));
    }
}
