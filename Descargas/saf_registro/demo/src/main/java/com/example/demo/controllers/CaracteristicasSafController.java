package com.example.demo.controllers;

import com.example.demo.DTO.CaracteristicasSafDTO;
import com.example.demo.entities.CaracteristicasSaf;
import com.example.demo.services.CaracteristicasSafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caracteristicasSaf")
@CrossOrigin(origins = "http://localhost:4200")
public class CaracteristicasSafController {

    @Autowired
    private CaracteristicasSafService caracteristicasSafService;

    // Obtener todas las características SAF
    @GetMapping
    public ResponseEntity<List<CaracteristicasSaf>> getAll() {
        return ResponseEntity.ok(caracteristicasSafService.getAll());
    }

    // Obtener una característica SAF por ID
    @GetMapping("/{id}")
    public ResponseEntity<CaracteristicasSaf> getById(@PathVariable Long id) {
        return caracteristicasSafService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar una nueva característica SAF desde una entidad
    @PostMapping
    public ResponseEntity<CaracteristicasSaf> save(@RequestBody CaracteristicasSaf item) {
        return ResponseEntity.ok(caracteristicasSafService.save(item));
    }

    // Guardar una nueva característica SAF desde un DTO
    @PostMapping("/dto")
    public ResponseEntity<CaracteristicasSaf> saveFromDTO(@RequestBody CaracteristicasSafDTO item) {
        return ResponseEntity.ok(caracteristicasSafService.save(item));
    }

    // Actualizar una característica SAF existente
    @PutMapping("/{id}")
    public ResponseEntity<CaracteristicasSaf> update(@RequestBody CaracteristicasSafDTO item, @PathVariable Long id) {
        CaracteristicasSaf updated = caracteristicasSafService.update(item, id);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Eliminar una característica SAF por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<CaracteristicasSaf> deleted = caracteristicasSafService.deleteById(id);
        return deleted.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
