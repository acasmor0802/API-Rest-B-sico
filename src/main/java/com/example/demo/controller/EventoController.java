package com.example.demo.controller;

import com.example.demo.model.Evento;
import com.example.demo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @PostMapping
    public Evento crearEvento(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping
    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll();
    }

    @GetMapping("/buscar")
    public List<Evento> buscarEventosPorTitulo(@RequestParam String titulo) {
        return eventoRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @GetMapping("/{id}")
    public Evento obtenerEventoPorId(@PathVariable Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Evento actualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        evento.setId(id);
        return eventoRepository.save(evento);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);
    }
}