package com.mitocode.service.impl;

import com.mitocode.model.Equipos;
import com.mitocode.model.Jugadores;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IJugadoresRepo;
import com.mitocode.service.IEquiposService;
import com.mitocode.service.IJugadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JugadoresServiceImpl extends CRUDImpl<Jugadores, Long> implements IJugadoresService {
    @Autowired
    IJugadoresRepo repo;
    @Override
    protected IGenericRepo<Jugadores, Long> getRepo() {
        return repo;
    }
}
