package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TBSDANHMUC25;
import com.nsw.backend.mard.p25.repositories.TBSDANHMUC25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbsDanhmuc25ServiceImpl implements TbsDanhmuc25Service {
    @Autowired
    private TBSDANHMUC25Repository repository;
    @Override
    public List<TBSDANHMUC25> findByFiCatNoOrderByFiOrder(Long fiCatNo) {
        return repository.findByFiCatNoOrderByFiOrder(fiCatNo);
    }
}
