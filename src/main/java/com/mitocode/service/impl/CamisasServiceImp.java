package com.mitocode.service.impl;

import com.mitocode.model.Camisas;
import com.mitocode.repo.ICamisasRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICamisasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamisasServiceImp extends CRUDImpl<Camisas, Long> implements ICamisasService {
    @Autowired
    ICamisasRepo repo;

    @Override
    protected IGenericRepo<Camisas, Long> getRepo() {
        return repo;
    }
}
