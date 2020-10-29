package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdLichsu25;
import com.nsw.backend.mard.p25.repositories.TbdLichsu25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdLichsu25ServiceImpl implements TbdLichsu25Service {
    private final TbdLichsu25Repository hstRepository;

    @Autowired
    public TbdLichsu25ServiceImpl(TbdLichsu25Repository hstRepository){
        this.hstRepository = hstRepository;
    }
    @Override
    public TbdLichsu25 findById(Long fiIdLichsu) {
        return hstRepository.findByFiIdHst(fiIdLichsu.intValue()).orElse(null);
    }

    @Override
    public List<TbdLichsu25> findAll() {
        return hstRepository.findAll();
    }

    @Override
    public TbdLichsu25 save(TbdLichsu25 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public TbdLichsu25 update(TbdLichsu25 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public TbdLichsu25 create(TbdLichsu25 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public List<TbdLichsu25> findByIdHS(long id) {
        return hstRepository.findByFiIdHS((int) id);
    }

    @Override
    public List<TbdLichsu25> findByHSCode(String fiMaHoso) {
        return hstRepository.findByFiHSCodeOrderByFiCreatedDateDesc(fiMaHoso);
    }

    @Override
    public Page<TbdLichsu25> findByHSCodeAndPagable(String fiHSCode, PageRequest pageRequest) {
        return hstRepository.findByFiHSCodeOrderByFiIdHstDesc(fiHSCode, pageRequest);
    }
}
