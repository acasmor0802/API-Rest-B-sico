package com.example.demo.repository;

import com.example.demo.model.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {
    Optional<Organizador> findByEmailContainingIgnoreCase(String email);
}
