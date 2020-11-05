package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.model.TBSDANHMUC26;
import com.nsw.backend.mard.p26.repositories.TBSDANHMUC26Repository;
import com.nsw.backend.mard.p26.service.TbsDanhmuc26Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbsDanhmuc26ServiceImpl implements TbsDanhmuc26Service {
    @Autowired
    private TBSDANHMUC26Repository repository;
    @Override
    public List<TBSDANHMUC26> findByFiCatNoOrderByFiOrder(Long fiCatNo) {
        return repository.findByFiCatNoOrderByFiOrder(fiCatNo);
    }

    @Override
    public List<TBSDANHMUC26> findByFiCatParentOrderByFiOrder(Long id) {
        return repository.findByFiCatParentOrderByFiOrder(id);
    }
}
