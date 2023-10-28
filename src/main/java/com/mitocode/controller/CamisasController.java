package com.mitocode.controller;


import com.jayway.jsonpath.JsonPath;
import com.mitocode.model.Camisas;
import com.mitocode.model.Exam;
import com.mitocode.service.impl.CamisasServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camisas")
public class CamisasController {

    @Autowired
    private ModelMapper mapper;
    private final CamisasServiceImp camisasService;

    public CamisasController(final CamisasServiceImp camisasService) {
        this.camisasService = camisasService;
    }

    @GetMapping
    public ResponseEntity<List<Camisas>> getAllCamisass() {
        return ResponseEntity.ok(camisasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camisas> getCamisas(@PathVariable final Long id) {
        return ResponseEntity.ok(camisasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createCamisas(@RequestBody final Camisas camisasDTO) {
        final Long createdId = camisasService.save(camisasDTO).getId();
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamisas(@PathVariable final Long id) {
        camisasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
