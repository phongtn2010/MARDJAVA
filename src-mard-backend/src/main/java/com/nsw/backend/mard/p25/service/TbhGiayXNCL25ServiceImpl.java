package com.nsw.backend.mard.p25.service;


import com.nsw.backend.mard.p25.model.TbdGiayXNCL25;
import com.nsw.backend.mard.p25.repositories.TbdGiayXNCL25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TbhGiayXNCL25ServiceImpl implements TbdGiayXNCL25Service {
    @Autowired
    private TbdGiayXNCL25Repository repository;
    @Override
    public TbdGiayXNCL25 save(TbdGiayXNCL25 tbdGiayXNCL25) {
        return repository.save(tbdGiayXNCL25);
    }

}
