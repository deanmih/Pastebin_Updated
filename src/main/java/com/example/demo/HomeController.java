package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {
    
    @Autowired
    private ButonRepository butonRepository;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("buton", new Buton());
        return "index";
    }
    
    @PostMapping("/add")
    public ResponseEntity<Void> submitForm(Buton buton) {
        if (buton.getText().trim().compareTo("") > 0) {
            butonRepository.save(buton);
        }
        return ResponseEntity.noContent().build();
    }

}