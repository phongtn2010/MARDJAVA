package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdKQXL25;
import com.nsw.backend.mard.p25.repositories.TbdKQXL25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbdKQXL25ServiceImpl implements TbdKQXL25Service {
    @Autowired
    private TbdKQXL25Repository repository;
    @Override
    public void save(TbdKQXL25 tbdKQXL25) {
        repository.save(tbdKQXL25);
    }

    @Override
    public TbdKQXL25 findByFiNSWFileCodeAndFiProId(String nswFileCode, Integer proId) {
        return repository.findByFiNSWFileCodeAndFiProId(nswFileCode,proId);
    }

    @Override
    public TbdKQXL25 findByFiNSWFileCodeAndFiSoGCN(String nswFileCode, String soGCN) {
        return repository.findByFiNSWFileCodeAndFiSoGCN(nswFileCode,soGCN);
    }
}
