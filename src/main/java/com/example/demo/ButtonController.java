package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ButtonController {

    @Autowired
    private ButonRepository butonRepository;

    @PostMapping("/checkValue")
    public ResponseEntity<Boolean> checkValue(@RequestBody String text) {
        boolean exists = butonRepository.existsByText(text);  
        return ResponseEntity.ok(exists);
    }
}