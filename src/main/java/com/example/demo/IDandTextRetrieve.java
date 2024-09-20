package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IDandTextRetrieve {

    @Autowired
    private ButonRepository butonRepository;

    @GetMapping("/lastId")
    public Long getLastId() {
        return butonRepository.findTopByOrderByIdDesc().map(Buton::getId).orElse(null);
    }

    @GetMapping("/getTextById/{id}")
    public ResponseEntity<String> getTextById(@PathVariable Long id) {
        Optional<Buton> buton = butonRepository.findById(id);
        return buton.map(b -> ResponseEntity.ok(b.getText()))
                    .orElse(ResponseEntity.notFound().build());
    }
}
