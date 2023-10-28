package com.mitocode.controller;

import com.mitocode.dto.EquiposDTO;
import com.mitocode.dto.JugadoresDTO;
import com.mitocode.model.Jugadores;
import com.mitocode.service.impl.JugadoresServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jugadores")
public class JugadoresController {

    private final JugadoresServiceImpl jugadoresService;
    @Autowired
    private ModelMapper mapper;

    public JugadoresController(final JugadoresServiceImpl jugadoresService) {
        this.jugadoresService = jugadoresService;
    }



    @GetMapping
    public ResponseEntity<List<JugadoresDTO>> getAllEquipos() {

        List<JugadoresDTO> list = jugadoresService.findAll().stream().map(p -> mapper.map(p, JugadoresDTO.class )).collect(Collectors.toList());
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Jugadores> getJugadores(@PathVariable final Long id) {
        return ResponseEntity.ok(jugadoresService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createJugadores(
            @RequestBody final Jugadores jugadoresDTO) {
        final Long createdId = jugadoresService.save(jugadoresDTO).getId();
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }







}
