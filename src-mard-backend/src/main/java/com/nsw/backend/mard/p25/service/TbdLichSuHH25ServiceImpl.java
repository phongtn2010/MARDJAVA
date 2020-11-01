package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdLichSuHH25;
import com.nsw.backend.mard.p25.repositories.TbdLichSuHH25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbdLichSuHH25ServiceImpl implements TbdLichSuHH25Service {
    @Autowired
    private TbdLichSuHH25Repository repository;
    @Override
    public void save(TbdLichSuHH25 tbdLichSuHH25) {
        repository.save(tbdLichSuHH25);
    }
}
