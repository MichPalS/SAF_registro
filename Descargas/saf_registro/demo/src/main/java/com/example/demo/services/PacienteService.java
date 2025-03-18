package com.example.demo.services;

import com.example.demo.entities.Paciente;
import com.example.demo.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IServices<Paciente> {

    @Autowired
    private final PacienteRepository pacienteRepository;

    
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> getAll() {
        return pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Paciente> getById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Transactional
    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Transactional
    @Override
    public Optional<Paciente> deleteById(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        paciente.ifPresent(pacienteRepository::delete);
        return paciente;
    }
}
