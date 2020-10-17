package com.nsw.backend.mard.p06.service;

import com.nsw.backend.mard.p06.model.TbdLichsu06;
import com.nsw.backend.mard.p06.repositories.TbdLichsu06Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbdLichsu06ServiceImpl implements TbdLichsu06Service {
    private final TbdLichsu06Repository hstRepository;

    @Autowired
    public TbdLichsu06ServiceImpl(TbdLichsu06Repository hstRepository) {
        this.hstRepository = hstRepository;
    }

    @Override
    public TbdLichsu06 findById(Long fiIdLichsu) {
        return hstRepository.findByFiIdHst(fiIdLichsu.intValue()).orElse(null);
    }

    @Override
    public List<TbdLichsu06> findAll() {
        return hstRepository.findAll();
    }

    @Override
    public TbdLichsu06 save(TbdLichsu06 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public TbdLichsu06 update(TbdLichsu06 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public TbdLichsu06 create(TbdLichsu06 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public List<TbdLichsu06> findByIdHS(long id) {
        return hstRepository.findByFiIdHS((int) id);
    }

    @Override
    public List<TbdLichsu06> findByHSCode(String fiMaHoso) {
        return hstRepository.findByFiHSCodeOrderByFiCreatedDateDesc(fiMaHoso);
    }

    @Override
    public Page<TbdLichsu06> findByHSCodeAndPagable(String fiHSCode, PageRequest pageRequest) {
        return hstRepository.findByFiHSCodeOrderByFiIdHstDesc(fiHSCode, pageRequest);
    }
}
