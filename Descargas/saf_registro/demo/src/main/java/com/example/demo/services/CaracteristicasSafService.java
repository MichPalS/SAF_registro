package com.example.demo.services;

import com.example.demo.DTO.CaracteristicasSafDTO;
import com.example.demo.entities.CaracteristicasSaf;
import com.example.demo.entities.Paciente;
import com.example.demo.repositories.CaracteristicasSafRepository;
import com.example.demo.repositories.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicasSafService implements IServices<CaracteristicasSaf> {
    
    @Autowired
    private CaracteristicasSafRepository caracteristicasSafRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    @Transactional(readOnly = true)
    @Override
    public List<CaracteristicasSaf> getAll() {
        return caracteristicasSafRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CaracteristicasSaf> getById(Long id) {
        return caracteristicasSafRepository.findById(id);
    }

    @Transactional
    @Override
    public CaracteristicasSaf save(CaracteristicasSaf item) {
        return caracteristicasSafRepository.save(item);
    }
    @Transactional
    public CaracteristicasSaf save(CaracteristicasSafDTO item){
        Paciente paciente = pacienteRepository.findById(item
            .getIdPaciente()).orElseThrow(()->
            new RuntimeException("Paciente no encotrado"));
        CaracteristicasSaf caracteristicasSaf=new CaracteristicasSaf();
        caracteristicasSaf.setIdPaciente(paciente);
        caracteristicasSaf.setTromboembolismoVenoso(item.getTromboembolismoVenoso());
        caracteristicasSaf.setEvc(item.getEvc());
        caracteristicasSaf.setInfartoMiocardio(item.getInfartoMiocardio());
        caracteristicasSaf.setAborto(item.getAborto());
        caracteristicasSaf.setObito(item.getObito());
        caracteristicasSaf.setPreeclampsiaEclampsia(item.getPreeclampsiaEclampsia());
        caracteristicasSaf.setOtrasManifestaciones(item.getOtrasManifestaciones());
        caracteristicasSaf.setManifestacionesNoCriterio(item.getManifestacionesNoCriterio());

        return caracteristicasSafRepository.save(caracteristicasSaf);

    }
    @Transactional
    public CaracteristicasSaf update(CaracteristicasSafDTO item, Long id){
        Optional<CaracteristicasSaf>optionalCaracteristicasSaf = caracteristicasSafRepository.findById(id);
        if (optionalCaracteristicasSaf.isPresent()){
            Paciente paciente = pacienteRepository.findById(item
            .getIdPaciente()).orElseThrow(()->
            new RuntimeException("Paciente no encotrado"));
            CaracteristicasSaf caracteristicasSafDB = optionalCaracteristicasSaf.get();
            caracteristicasSafDB.setIdPaciente(paciente);
            caracteristicasSafDB.setTromboembolismoVenoso(item.getTromboembolismoVenoso());
            caracteristicasSafDB.setEvc(item.getEvc());
            caracteristicasSafDB.setInfartoMiocardio(item.getInfartoMiocardio());
            caracteristicasSafDB.setAborto(item.getAborto());
            caracteristicasSafDB.setObito(item.getObito());
            caracteristicasSafDB.setPreeclampsiaEclampsia(item.getPreeclampsiaEclampsia());
            caracteristicasSafDB.setOtrasManifestaciones(item.getOtrasManifestaciones());
            caracteristicasSafDB.setManifestacionesNoCriterio(item.getManifestacionesNoCriterio());

            return caracteristicasSafRepository.save(caracteristicasSafDB);
        }
        return null;
    }

    @Transactional
    @Override
    public Optional<CaracteristicasSaf> deleteById(Long id) {
        Optional<CaracteristicasSaf> caracteristicasSaf = caracteristicasSafRepository.findById(id);
        caracteristicasSaf.ifPresent(caracteristicasSafRepository::delete);
        return caracteristicasSaf;
    }
}

