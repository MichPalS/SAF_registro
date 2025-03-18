package com.example.demo.controllers;

import com.example.demo.entities.Medico;
import com.example.demo.services.IServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoController {

    private final IServices<Medico> medicoService;

    public MedicoController(IServices<Medico> medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getAllMedicos() {
        return ResponseEntity.ok(medicoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) {
        return medicoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.save(medico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody Medico medicoDetails) {
        Optional<Medico> optionalMedico = medicoService.getById(id);
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            medico.setNombreCompleto(medicoDetails.getNombreCompleto());
            medico.setHospital(medicoDetails.getHospital());
            medico.setEmail(medicoDetails.getEmail());
            medico.setUsuario(medicoDetails.getUsuario());
            return ResponseEntity.ok(medicoService.save(medico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        Optional<Medico> deleted = medicoService.deleteById(id);
        return deleted.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
