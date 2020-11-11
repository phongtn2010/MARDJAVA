package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.model.TbdLichsu26;
import com.nsw.backend.mard.p26.repositories.TbdLichsu26Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TbdLichsu26ServiceImpl implements TbdLichsu26Service {
    @Autowired
    private TbdLichsu26Repository tbdLichsu26Repository;

    @Override
    public void save(TbdLichsu26 tbdLichsu26) {
        tbdLichsu26Repository.save(tbdLichsu26);
    }
}
