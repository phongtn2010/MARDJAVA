package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.model.TbdLichsu26;
import com.nsw.backend.mard.p26.repositories.TbdLichsu26Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdLichsu26ServiceImpl implements TbdLichsu26Service {
    @Autowired
    private TbdLichsu26Repository tbdLichsu26Repository;

    @Override
    public void save(TbdLichsu26 tbdLichsu26) {
        tbdLichsu26Repository.save(tbdLichsu26);
    }

    @Override
    public Page<TbdLichsu26> findByFiIdHSOrderByFiCreatedDate(Integer fiIdHS, Pageable pageable) {
        return tbdLichsu26Repository.findByFiIdHSOrderByFiCreatedDate(fiIdHS,pageable);
    }

    @Override
    public List<TbdLichsu26> findByFiIdHS(Integer fiIdHS) {
        return tbdLichsu26Repository.findByFiIdHS(fiIdHS);
    }
}
