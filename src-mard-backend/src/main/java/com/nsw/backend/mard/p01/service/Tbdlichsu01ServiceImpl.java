package com.nsw.backend.mard.p01.service;

import com.nsw.backend.mard.p01.model.Tbdlichsu01;
import com.nsw.backend.mard.p01.repositories.Tbdlichsu01Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tbdlichsu01ServiceImpl implements Tbdlichsu01Service {

    private final Tbdlichsu01Repository tbdlichsu01Repository;

    @Autowired
    public Tbdlichsu01ServiceImpl(Tbdlichsu01Repository tbdlichsu01Repository) {
        this.tbdlichsu01Repository = tbdlichsu01Repository;
    }

    @Override
    public Tbdlichsu01 save(Tbdlichsu01 entity) {
        return tbdlichsu01Repository.save(entity);
    }

    @Override
    public Tbdlichsu01 create(Tbdlichsu01 entity) {
        return tbdlichsu01Repository.save(entity);
    }

    @Override
    public List<Tbdlichsu01> findByHSCode(String fiMaHoso) {
        return tbdlichsu01Repository.findByFiHSCodeOrderByFiCreatedDateDesc(fiMaHoso);
    }

    @Override
    public Page<Tbdlichsu01> findByHSCodeAndPagable(String fiNSWFileCode, Pageable pageRequest) {
        return tbdlichsu01Repository.findByFiHSCodeOrderByFiIdHstDesc(fiNSWFileCode, pageRequest);
    }
}
