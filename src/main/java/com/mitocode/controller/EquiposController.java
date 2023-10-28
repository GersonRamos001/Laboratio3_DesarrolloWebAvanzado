package com.mitocode.controller;

import com.mitocode.dto.EquiposDTO;
import com.mitocode.dto.PatientDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Equipos;
import com.mitocode.model.Patient;
import com.mitocode.service.impl.EquiposServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/equipos")
public class EquiposController {

    private final EquiposServiceImp equiposService;

    public EquiposController (final EquiposServiceImp equiposService) {
        this.equiposService = equiposService;
    }

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EquiposDTO>> getAllEquipos() {

        List<EquiposDTO> list = equiposService.findAll().stream().map(p -> mapper.map(p, EquiposDTO.class )).collect(Collectors.toList());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquiposDTO> getEquipos(@PathVariable final Long id) {
        EquiposDTO dtoResponse;
        Equipos obj = equiposService.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            dtoResponse = mapper.map(obj, EquiposDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
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
