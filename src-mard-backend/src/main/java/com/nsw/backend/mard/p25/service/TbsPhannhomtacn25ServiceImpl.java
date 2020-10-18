package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbsPhannhomtacn25;
import com.nsw.backend.mard.p25.repositories.TbsPhannhomtacn25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbsPhannhomtacn25ServiceImpl implements TbsPhannhomtacn25Service{
    @Autowired
    TbsPhannhomtacn25Repository repository;
    @Override
    public List<TbsPhannhomtacn25> findAll() {
        return repository.findAll();
    }
}
