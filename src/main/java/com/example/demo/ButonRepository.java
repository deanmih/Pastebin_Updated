package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ButonRepository extends JpaRepository<Buton, Long> {
    boolean existsByText(String text);
}