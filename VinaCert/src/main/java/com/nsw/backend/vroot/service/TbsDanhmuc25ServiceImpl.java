package com.nsw.backend.vroot.service;


import com.nsw.backend.vroot.model.TBSDANHMUC25;
import com.nsw.backend.vroot.repositories.TBSDANHMUC25Repository;
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

    @Override
    public List<TBSDANHMUC25> findByFiCatParentOrderByFiOrder(Long id) {
        return repository.findByFiCatParentOrderByFiOrder(id);
    }

    @Override
    public Long findFiMaxCatTypeByFiCatNo(Long fiCatNo) {
        return repository.findFiMaxCatTypeByFiCatNo(fiCatNo);
    }

    @Override
    public void save(TBSDANHMUC25 tbsdanhmuc25) {
        repository.save(tbsdanhmuc25);
    }

    @Override
    public List<TBSDANHMUC25> findByFiCatNoAndFiCatType(Long fiCatNo, Long fiCatType) {
        return repository.findByFiCatNoAndFiCatType(fiCatNo,fiCatType);
    }

    @Override
    public List<TBSDANHMUC25> findByFiCatNoAndFiCatNote(Long fiCatNo, String fiCatNote) {
        return repository.findByFiCatNoAndFiCatNote(fiCatNo,fiCatNote);
    }

    @Override
    public void delete(TBSDANHMUC25 tbsdanhmuc25) {
        repository.delete(tbsdanhmuc25);
    }
}
