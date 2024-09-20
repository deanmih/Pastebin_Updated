package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ButonRepository extends JpaRepository<Buton, Long> {
    Optional<Buton> findTopByOrderByIdDesc();
}