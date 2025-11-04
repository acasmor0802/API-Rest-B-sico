package com.example.demo.controller;

import com.example.demo.model.Organizador;
import com.example.demo.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {

    @Autowired
    private OrganizadorRepository organizadorRepository;

    // Crear un nuevo organizador
    @PostMapping
    public Organizador crearOrganizador(@RequestBody Organizador organizador) {
        return organizadorRepository.save(organizador);
    }

    // Obtener todos los organizadores
    @GetMapping
    public List<Organizador> obtenerTodosLosOrganizadores() {
        return organizadorRepository.findAll();
    }

    // Buscar organizadores por nombre
    @GetMapping("/buscar")
    public List<Organizador> buscarOrganizadoresPorEmail(@RequestParam String nombre) {
        return organizadorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Obtener un organizador por ID
    @GetMapping("/{id}")
    public Organizador obtenerOrganizadorPorId(@PathVariable Long id) {
        return organizadorRepository.findById(id).orElse(null);
    }

    // Actualizar un organizador
    @PutMapping("/{id}")
    public Organizador actualizarOrganizador(@PathVariable Long id, @RequestBody Organizador organizador) {
        organizador.setId(id);
        return organizadorRepository.save(organizador);
    }

    // Eliminar un organizador
    @DeleteMapping("/{id}")
    public void eliminarOrganizador(@PathVariable Long id) {
        organizadorRepository.deleteById(id);
    }
}