package com.example.demo.repository;

import com.example.demo.model.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {
    List<Organizador> findByNombreContainingIgnoreCase(String nombre);
}
