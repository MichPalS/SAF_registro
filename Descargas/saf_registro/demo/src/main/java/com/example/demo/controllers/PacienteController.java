package com.example.demo.controllers;

import com.example.demo.entities.Paciente;
import com.example.demo.services.IServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteController {

    private final IServices<Paciente> pacienteService;

    public PacienteController(IServices<Paciente> pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.save(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetails) {
        Optional<Paciente> optionalPaciente = pacienteService.getById(id);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.setNombre(pacienteDetails.getNombre());
            paciente.setApellido(pacienteDetails.getApellido());
            paciente.setCentroAtencion(pacienteDetails.getCentroAtencion());
            paciente.setFolio(pacienteDetails.getFolio());
            paciente.setSexo(pacienteDetails.getSexo());
            paciente.setFechaConsulta(pacienteDetails.getFechaConsulta());
            paciente.setTelefono(pacienteDetails.getTelefono());
            paciente.setDireccion(pacienteDetails.getDireccion());
            paciente.setEdoCivil(pacienteDetails.getEdoCivil());
            paciente.setOcupacion(pacienteDetails.getOcupacion());
            paciente.setEscolaridad(pacienteDetails.getEscolaridad());
            paciente.setDiscapacidadSaf(pacienteDetails.getDiscapacidadSaf());
            return ResponseEntity.ok(pacienteService.save(paciente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        Optional<Paciente> deleted = pacienteService.deleteById(id);
        return deleted.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
