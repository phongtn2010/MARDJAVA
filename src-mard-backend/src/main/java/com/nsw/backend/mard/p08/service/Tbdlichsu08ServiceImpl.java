package com.nsw.backend.mard.p08.service;

import com.nsw.backend.mard.p08.model.Tbdlichsu08;
import com.nsw.backend.mard.p08.repositories.Tbdlichsu08Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tbdlichsu08ServiceImpl implements Tbdlichsu08Service {
    private final Tbdlichsu08Repository tbdlichsu08Repository;

    @Autowired
    public Tbdlichsu08ServiceImpl(Tbdlichsu08Repository tbdlichsu08Repository) {
        this.tbdlichsu08Repository = tbdlichsu08Repository;
    }

    @Override
    public Tbdlichsu08 findById(Long fiIdLichsu) {
        return tbdlichsu08Repository.findByFiIdHst(fiIdLichsu).orElse(null);
    }

    @Override
    public List<Tbdlichsu08> findAll() {
        return tbdlichsu08Repository.findAll();
    }

    @Override
    public Tbdlichsu08 save(Tbdlichsu08 entity) {
        return tbdlichsu08Repository.save(entity);
    }

    @Override
    public Tbdlichsu08 update(Tbdlichsu08 entity) {
        return tbdlichsu08Repository.save(entity);
    }

    @Override
    public Tbdlichsu08 create(Tbdlichsu08 entity) {
        return tbdlichsu08Repository.save(entity);
    }

    @Override
    public List<Tbdlichsu08> findByIdHS(long id) {
        return tbdlichsu08Repository.findByFiIdHS(id);
    }

    @Override
    public List<Tbdlichsu08> findByHSCode(String fiMaHoso) {
        return tbdlichsu08Repository.findByFiHSCodeOrderByFiCreatedDateDesc(fiMaHoso);
    }

    @Override
    public Page<Tbdlichsu08> findByHSCodeAndPagable(String fiHSCode, PageRequest pageRequest) {
        return tbdlichsu08Repository.findByFiHSCodeOrderByFiIdHstDesc(fiHSCode, pageRequest);
    }
}
