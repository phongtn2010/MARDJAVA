package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdChiTieuDG25;
import com.nsw.backend.mard.p25.repositories.TbdChiTieuDG25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdChiTieuDG25ServiceImpl implements TbdChiTieuDG25Service{
    @Autowired
    private TbdChiTieuDG25Repository repository;
    @Override
    public void save(TbdChiTieuDG25 tbdChiTieuDG25) {
        repository.save(tbdChiTieuDG25);
    }

    @Override
    public List<TbdChiTieuDG25> findByFiNSWFileCode(String fiNSWFileCode) {
        return repository.findByFiNSWFileCode(fiNSWFileCode);
    }

    @Override
    public List<TbdChiTieuDG25> findByFiIdProduct(Integer id) {
        return repository.findByFiIdProduct(id);
    }
}
