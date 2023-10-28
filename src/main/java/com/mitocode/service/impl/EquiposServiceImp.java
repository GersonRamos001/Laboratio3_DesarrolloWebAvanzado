package com.mitocode.service.impl;

import com.mitocode.model.Equipos;
import com.mitocode.model.Exam;
import com.mitocode.repo.IEquiposRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEquiposService;
import com.mitocode.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquiposServiceImp extends CRUDImpl<Equipos, Long> implements IEquiposService {

    @Autowired
    private IEquiposRepo equiposRepo;

    @Override
    protected IGenericRepo<Equipos, Long> getRepo() {
        return equiposRepo;
    }
}
