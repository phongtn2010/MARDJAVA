package com.nsw.backend.mard.p09.service;

import com.nsw.backend.mard.p09.model.Tbdlichsu09;
import com.nsw.backend.mard.p09.repositories.Tbdlichsu09Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tbdlichsu09ServiceImpl implements Tbdlichsu09Service {
    private final Tbdlichsu09Repository tbdlichsu09Repository;


    @Autowired
    public Tbdlichsu09ServiceImpl(Tbdlichsu09Repository tbdlichsu09Repository) {
        this.tbdlichsu09Repository = tbdlichsu09Repository;
    }

    @Override
    public Tbdlichsu09 save(Tbdlichsu09 entity) {
        return tbdlichsu09Repository.save(entity);
    }

    @Override
    public List<Tbdlichsu09> findByHSCode(String fiMaHoso) {
        return tbdlichsu09Repository.findByFiHSCodeOrderByFiCreatedDateDesc(fiMaHoso);
    }

    @Override
    public Page<Tbdlichsu09> findByHSCodeAndPagable(String fiMaHoso, Pageable pageable) {
        return tbdlichsu09Repository.findByFiHSCodeOrderByFiIdHstDesc(fiMaHoso, pageable);
    }
}
