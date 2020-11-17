package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdYcrut25;
import com.nsw.backend.mard.p25.repositories.TbdYcrut25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbdYcrut25ServiceImpl implements TbdYcrut25Service {

    @Autowired
    private TbdYcrut25Repository repository;

    @Override
    public void save(TbdYcrut25 tbdYcrut25) {
        repository.save(tbdYcrut25);
    }
}
