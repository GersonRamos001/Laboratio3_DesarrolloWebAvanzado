package com.mitocode.controller;

import com.mitocode.model.Jugadores;
import com.mitocode.service.impl.JugadoresServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadoresController {

    private final JugadoresServiceImpl jugadoresService;

    public JugadoresController(final JugadoresServiceImpl jugadoresService) {
        this.jugadoresService = jugadoresService;
    }

    @GetMapping
    public ResponseEntity<List<Jugadores>> getAllJugadoress() {
        return ResponseEntity.ok(jugadoresService.findAll());
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
