package com.mitocode.controller;

import com.mitocode.model.Equipos;
import com.mitocode.service.impl.EquiposServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/equipos")
public class EquiposController {

    private final EquiposServiceImp equiposService;

    public EquiposController (final EquiposServiceImp equiposService) {
        this.equiposService = equiposService;
    }

    @GetMapping
    public ResponseEntity<List<Equipos>> getAllEquipos() {
        return ResponseEntity.ok(equiposService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipos> getEquipos(@PathVariable final Long id) {
        return ResponseEntity.ok(equiposService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createEquipos(@RequestBody final Equipos equiposDTO) {
        final Long createdId = equiposService.save(equiposDTO).getId();
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateEquipos(@PathVariable final Long id,
                                              @RequestBody final Equipos equiposDTO) {
        equiposService.update(equiposDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipos(@PathVariable final Long id) {
        equiposService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
