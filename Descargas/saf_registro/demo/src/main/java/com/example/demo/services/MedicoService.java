package com.example.demo.services;

import com.example.demo.entities.Medico;
import com.example.demo.repositories.MedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements IServices<Medico> {
    @Autowired

    private MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Medico> getAll() {
        return medicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Medico> getById(Long id) {
        return medicoRepository.findById(id);
    }

    @Transactional
    @Override
    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Transactional
    @Override
    public Optional<Medico> deleteById(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        medico.ifPresent(medicoRepository::delete);
        return medico;
    }
}
