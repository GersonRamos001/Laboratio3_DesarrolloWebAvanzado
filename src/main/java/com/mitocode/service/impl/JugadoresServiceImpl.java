package com.mitocode.service.impl;

import com.mitocode.dto.JugadoresDTO;
import com.mitocode.model.Equipos;
import com.mitocode.model.Jugadores;
import com.mitocode.repo.*;
import com.mitocode.service.IEquiposService;
import com.mitocode.service.IJugadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadoresServiceImpl extends CRUDImpl<Jugadores, Long> implements IJugadoresService {
    @Autowired
    private IJugadoresRepo repo;

    @Autowired
    private ICamisasRepo camisasRepo;
    @Autowired
    private IPosicionesRepo posicionesRepo;
    @Autowired
    private IEquiposRepo equiposRepo;
    @Override
    protected IGenericRepo<Jugadores, Long> getRepo() {
        return repo;
    }


}
