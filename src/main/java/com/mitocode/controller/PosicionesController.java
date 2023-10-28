package com.mitocode.controller;

import com.mitocode.model.Posiciones;
import com.mitocode.service.IPosicionesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/posiciones")
public class PosicionesController {

    @Autowired
    private IPosicionesService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<Posiciones>> getAllPosicioness() {
        return ResponseEntity.ok(service.findAll());
    }


}
