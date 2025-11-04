package com.example.demo.controller;

import com.example.demo.model.Participante;
import com.example.demo.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteRepository participanteRepository;

    // Crear un nuevo participante
    @PostMapping
    public Participante crearParticipante(@RequestBody Participante participante) {
        return participanteRepository.save(participante);
    }

    // Obtener todos los participantes
    @GetMapping
    public List<Participante> obtenerTodosLosParticipantes() {
        return participanteRepository.findAll();
    }

    // Buscar participantes por email
    @GetMapping("/buscar")
    public List<Participante> buscarParticipantesPorNombre(@RequestParam String nombre) {
        return participanteRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Obtener un participante por ID
    @GetMapping("/{id}")
    public Participante obtenerParticipantePorId(@PathVariable Long id) {
        return participanteRepository.findById(id).orElse(null);
    }

    // Actualizar un participante
    @PutMapping("/{id}")
    public Participante actualizarParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        participante.setId(id);
        return participanteRepository.save(participante);
    }

    // Eliminar un participante
    @DeleteMapping("/{id}")
    public void eliminarParticipante(@PathVariable Long id) {
        participanteRepository.deleteById(id);
    }
}